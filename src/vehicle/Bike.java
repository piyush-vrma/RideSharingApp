package vehicle;

public class Bike extends BaseVehicle {

    public Bike(String name, String numberPlate) {
        super(name, numberPlate);
    }

    @Override
    public double getPerKMFare() {
        return 100.8;
    }
}
