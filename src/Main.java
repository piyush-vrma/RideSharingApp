import enums.VehicleType;
import location.Location;
import mediator.RideBookingApp;
import mediator.RideBookingMediator;
import mediator.RideController;
import mediator.RideDetails;
import paymentmode.UPI;
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

        // Adc Passenger
        Passenger passenger = new PassengerConcrete("Robert");
        rideBookingMediator.addPassenger(passenger);

        // Create pickup & destination
        Location pickup = new Location("Doddanekundi", 7, 10);
        Location destination = new Location("Koremangla", 1, 2);

        // Start app
        RideController controller = new RideController(rideBookingMediator);
        RideDetails rideDetails = new RideDetails(passenger, pickup, destination, VehicleType.PremiumSedan);
        controller.bookAndCompleteRide(passenger, rideDetails, new UPI());
    }
}