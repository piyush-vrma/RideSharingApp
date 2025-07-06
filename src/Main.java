import enums.VehicleType;
import location.Location;
import mediator.RideBookingApp;
import mediator.RideBookingMediator;
import mediator.RideDetails;
import paymentmode.UPI;
import user.driver.Driver;
import user.passenger.Passenger;
import user.passenger.PassengerConcrete;
import utils.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        RideBookingMediator rideBookingMediator = new RideBookingApp();

        // Add drivers
        Util.addDrivers(rideBookingMediator, myScanner);

        Passenger prince = new PassengerConcrete("Prince");
        rideBookingMediator.addPassenger(prince);

        Location pickup = new Location("Doddanekundi", 7, 10);
        Location destination = new Location("Koremangla", 1, 2);
        Driver driver = prince.bookRide(new RideDetails(prince, pickup, destination, VehicleType.PremiumSedan));
        if (driver != null) {
            double fare = rideBookingMediator.completeRide(driver);
            prince.payFarePrice(new UPI(), fare);
        }
    }
}