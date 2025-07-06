package vehicle;

import enums.VehicleType;

public class Bike extends BaseVehicle {

    public Bike(String name, String numberPlate) {
        super(name, numberPlate, VehicleType.Bike);
    }

    @Override
    public double getPerKMFare() {
        return 50;
    }
}
