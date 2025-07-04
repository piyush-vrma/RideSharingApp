package user.driver;

import enums.VehicleType;
import location.Location;
import mediator.RideDetails;
import vehicle.Vehicle;

/**
 * Driver has:
 * 1. Vehicle
 * 2. VehicleType
 * 3. CurrentLocation
 * 4. Available
 * <p>
 * Driver Can:
 * 1. Accept the ride // we'll not implement this in the first iteration [MVP]
 * 2. Complete the ride and ask for payment
 **/
public interface Driver {
    VehicleType getVehicleType();

    Vehicle getVehicle();

    void updateCurrentLocation(Location newLocation);

    Location getCurrentLocation();

    void updateAvailability(boolean isAvailable);

    boolean isAvailable();

    void setRideDetails(RideDetails rideDetails);

    RideDetails getRideDetails();

    double completeRide();
}


