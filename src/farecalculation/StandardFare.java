package farecalculation;

import vehicle.Vehicle;

public class StandardFare implements FareCalculationStrategy {
    private final Vehicle vehicle;

    StandardFare(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double calculateFare(int distance) {
        return vehicle.getPerKMFare() * distance * 5.5;
    }
}
