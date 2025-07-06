package user.driver;

import location.Location;
import mediator.RideDetails;
import notification.RideObserver;
import user.BaseUser;
import vehicle.Vehicle;

public class DriverConcrete extends BaseUser implements Driver, RideObserver {
    private boolean isAvailable;
    private Vehicle vehicle;
    private Location currentLocation;
    private RideDetails rideDetails;

    public DriverConcrete(String name, Vehicle vehicle, Location location) {
        super(name);
        this.currentLocation = location;
        this.vehicle = vehicle;
        this.isAvailable = true;
    }

    @Override
    public void rideStatusUpdate(String rideStatus) {
        System.out.println("[Notification]");
        System.out.println("Dear Captain\nRideStatus: " + rideStatus);
        System.out.println();
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public void updateCurrentLocation(Location newLocation) {
        this.currentLocation = newLocation;
    }

    @Override
    public Location getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setRideDetails(RideDetails rideDetails) {
        this.rideDetails = rideDetails;
    }

    @Override
    public RideDetails getRideDetails() {
        return rideDetails;
    }
}
