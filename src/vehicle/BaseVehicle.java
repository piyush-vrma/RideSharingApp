package vehicle;

import enums.VehicleType;

public abstract class BaseVehicle implements Vehicle {
    private final String name;
    private final String numberPlate;
    protected double farePerKm;
    private VehicleType vehicleType;

    BaseVehicle(String name, String np, VehicleType vehicleType) {
        this.name = name;
        this.numberPlate = np;
        this.vehicleType = vehicleType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void updateFarePrice(double updatedFarePerKm) {
        this.farePerKm = updatedFarePerKm;
    }
}
