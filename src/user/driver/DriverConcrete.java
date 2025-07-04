package user.driver;

import enums.RideStatus;
import enums.VehicleType;
import location.Location;
import mediator.RideDetails;
import user.BaseUser;
import vehicle.Vehicle;

public class DriverConcrete extends BaseUser implements Driver {
    private boolean isAvailable;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Location currentLocation;
    private RideDetails rideDetails;

    public DriverConcrete(String name, Vehicle vehicle, VehicleType vehicleType, Location location) {
        super(name);
        this.currentLocation = location;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }

    @Override
    public void rideStatusUpdate(RideStatus status) {
        System.out.println("Dear Captain\nRideStatus: " + status);
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
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

    @Override
    public double completeRide() {
        return mediator.completeRide(this);
    }
}
