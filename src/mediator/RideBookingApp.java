package mediator;

import enums.RideStatus;
import farecalculation.FareCalculationFactory;
import farecalculation.FareCalculationStrategy;
import notification.Observable;
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
            System.out.println("Sorry No driver available at the moment :(\nPlease try again after sometime.");
        } else {
            nearestAvailableDriver.updateAvailability(false);
            nearestAvailableDriver.setRideDetails(rideDetails);
            notify(rideDetails.getPassenger(), nearestAvailableDriver, RideStatus.Started);
            System.out.println();
            System.out.println("Rider found!!\nReaching at your pickUp spot");
            System.out.println("Driver: " + ((User) nearestAvailableDriver).getName());
            System.out.println("Vehicle: " + nearestAvailableDriver.getVehicle().getName());
            System.out.println("NumberPlate: " + nearestAvailableDriver.getVehicle().getNumberPlate());
            System.out.println();
        }
        return nearestAvailableDriver;
    }

    @Override
    public double completeRide(Driver driver) {
        RideDetails rideDetails = driver.getRideDetails();
        int distanceTravelled = rideDetails.getPickUp().getDistance(rideDetails.getDestination());
        FareCalculationStrategy fareCalculationStrategy = FareCalculationFactory.getFareCalculator(driver.getVehicle());
        double fare = fareCalculationStrategy.calculateFare(distanceTravelled);
        System.out.println("Please pay fare price: " + fare + ", for distance of :" + distanceTravelled + " Km");
        driver.updateAvailability(true);
        driver.setRideDetails(null);
        notify(rideDetails.getPassenger(), driver, RideStatus.Completed);
        return fare;
    }

    @Override
    public void payFarePrice(PaymentStrategy paymentStrategy, double farePrice) {
        paymentStrategy.pay(farePrice);
    }

    @Override
    public void notify(Passenger passenger, Driver driver, RideStatus rideStatus) {
        ((User) passenger).rideStatusUpdate(rideStatus);
        ((User) driver).rideStatusUpdate(rideStatus);
    }
}
