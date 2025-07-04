package vehicle;

public class Car extends BaseVehicle {

    public Car(String name, String numberPlate) {
        super(name, numberPlate);
    }

    @Override
    public double getPerKMFare() {
        return 200.89;
    }
}
