package mediator;

import enums.RideStatus;
import farecalculation.FareCalculationFactory;
import farecalculation.FareCalculationStrategy;
import notification.Observable;
import notification.RideObserver;
import paymentmode.PaymentStrategy;
import ridematching.RideMatching;
import user.User;
import user.driver.Driver;
import user.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

public class RideBookingApp implements RideBookingMediator, Observable {
    private final List<Passenger> passengers;
    private final List<Driver> drivers;

    public RideBookingApp() {
        passengers = new ArrayList<>();
        drivers = new ArrayList<>();
    }

    @Override
    public void addPassenger(Passenger passenger) {
        ((User) passenger).setRideBookingMediator(this);
        passengers.add(passenger);
    }

    @Override
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    @Override
    public void addDriver(Driver driver) {
        ((User) driver).setRideBookingMediator(this);
        drivers.add(driver);
    }

    @Override
    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    @Override
    public Driver bookRide(RideDetails rideDetails) {
        Driver nearestAvailableDriver = RideMatching.findNearestDriver(rideDetails, drivers);
        if (nearestAvailableDriver == null) {
            notify((RideObserver) rideDetails.getPassenger(), "Sorry No driver available at the moment :(\nPlease try again after sometime.");
        } else {
            nearestAvailableDriver.updateAvailability(false);
            nearestAvailableDriver.setRideDetails(rideDetails);

            System.out.println();
            notify((RideObserver) rideDetails.getPassenger(), "Rider found!!\nReaching at your pickUp spot" +
                    "\nDriver: " + ((User) nearestAvailableDriver).getName() +
                    "\nVehicle: " + nearestAvailableDriver.getVehicle().getName() +
                    "\nNumberPlate: " + nearestAvailableDriver.getVehicle().getNumberPlate());

            notify((RideObserver) nearestAvailableDriver, RideStatus.Started.toString());
            notify((RideObserver) rideDetails.getPassenger(), RideStatus.Started.toString());
        }
        return nearestAvailableDriver;
    }

    @Override
    public double completeRide(Driver driver) {
        RideDetails rideDetails = driver.getRideDetails();
        int distanceTravelled = rideDetails.getPickUp().getDistance(rideDetails.getDestination());
        FareCalculationStrategy fareCalculationStrategy = FareCalculationFactory.getFareCalculator(driver.getVehicle());
        double fare = fareCalculationStrategy.calculateFare(distanceTravelled);

        System.out.println("Please pay fare price: " + fare + ", for distance of " + distanceTravelled + " Km");
        System.out.println();

        driver.updateAvailability(true);
        driver.setRideDetails(null);

        notify((RideObserver) driver, RideStatus.Completed.toString());
        notify((RideObserver) rideDetails.getPassenger(), RideStatus.Completed.toString());

        return fare;
    }

    @Override
    public void payFarePrice(PaymentStrategy paymentStrategy, double farePrice) {
        paymentStrategy.pay(farePrice);
    }

    @Override
    public void notify(RideObserver rideObserver, String rideStatus) {
        rideObserver.rideStatusUpdate(rideStatus);
    }
}
