package utils;

import location.Location;
import mediator.RideBookingMediator;
import user.driver.Driver;
import user.driver.DriverConcrete;
import vehicle.Bike;
import vehicle.Car;
import vehicle.PremiumSedan;
import vehicle.Vehicle;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Util {

    public static void addDrivers(RideBookingMediator rideBookingMediator, Scanner myScanner) {
        addDriverByType("Car", Car::new, rideBookingMediator, myScanner);
        addDriverByType("Bike", Bike::new, rideBookingMediator, myScanner);
        addDriverByType("PremiumSedan", PremiumSedan::new, rideBookingMediator, myScanner);
    }

    private static void addDriverByType(
            String vehicleTypeName,
            BiFunction<String, String, Vehicle> vehicleConstructor,
            RideBookingMediator rideBookingMediator,
            Scanner scanner
    ) {
        System.out.println("Enter number of " + vehicleTypeName + " drivers");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("""
                Please enter following:
                Driver Name:
                Vehicle Name:
                NumberPlate:
                CurrentLocation:(x y)""");

        for (int i = 0; i < count; i++) {


            String driverName = scanner.nextLine();
            String vehicleName = scanner.nextLine();
            String numberPlate = scanner.nextLine();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            Driver driver = new DriverConcrete(
                    driverName,
                    vehicleConstructor.apply(vehicleName, numberPlate),
                    new Location("Doddanekundi", x, y)
            );

            rideBookingMediator.addDriver(driver);
        }
    }
}
