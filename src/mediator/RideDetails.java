package mediator;

import enums.VehicleType;
import location.Location;
import user.passenger.Passenger;

public class RideDetails {
    private Location pickUp;
    private Location destination;
    private VehicleType vehicleType;
    private Passenger passenger;

    public RideDetails(Passenger passenger, Location pickUp, Location destination, VehicleType vehicleType) {
        this.passenger = passenger;
        this.pickUp = pickUp;
        this.destination = destination;
        this.vehicleType = vehicleType;
    }

    public Location getPickUp() {
        return pickUp;
    }

    public Location getDestination() {
        return destination;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
