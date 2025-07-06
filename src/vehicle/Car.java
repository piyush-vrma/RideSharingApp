package vehicle;

import enums.VehicleType;

public class Car extends BaseVehicle {

    public Car(String name, String numberPlate) {
        super(name, numberPlate, VehicleType.Car);
    }

    @Override
    public double getPerKMFare() {
        return 100;
    }
}
