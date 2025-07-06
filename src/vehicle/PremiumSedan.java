package vehicle;

import enums.VehicleType;

public class PremiumSedan extends BaseVehicle {

    public PremiumSedan(String name, String numberPlate) {
        super(name, numberPlate, VehicleType.PremiumSedan);
    }

    @Override
    public double getPerKMFare() {
        return 200;
    }
}