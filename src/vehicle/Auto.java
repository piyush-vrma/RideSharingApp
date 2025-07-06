package vehicle;

import enums.VehicleType;

public class Auto extends BaseVehicle {

    public Auto(String name, String numberPlate) {
        super(name, numberPlate, VehicleType.Auto);
    }

    @Override
    public double getPerKMFare() {
        return 20;
    }
}
