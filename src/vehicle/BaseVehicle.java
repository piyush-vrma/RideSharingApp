package vehicle;

public abstract class BaseVehicle implements Vehicle {
    private final String name;
    private final String numberPlate;
    protected double farePerKm;

    BaseVehicle(String name, String np) {
        this.name = name;
        this.numberPlate = np;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumberPlate() {
        return numberPlate;
    }

    public void updateFarePrice(double updatedFarePerKm) {
        this.farePerKm = updatedFarePerKm;
    }
}
