package vehicle;

public class PremiumSedan extends BaseVehicle {

    public PremiumSedan(String name, String numberPlate) {
        super(name, numberPlate);
    }

    @Override
    public double getPerKMFare() {
        return 100.50;
    }
}