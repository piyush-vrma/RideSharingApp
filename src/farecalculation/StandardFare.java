package farecalculation;

import vehicle.Vehicle;

public class StandardFare implements FareCalculationStrategy {
    private final Vehicle vehicle;
    private final double baseFare = 25;
    private final double multiplier = 1.5;

    StandardFare(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double calculateFare(int distance) {
        return baseFare + (vehicle.getPerKMFare() * distance * multiplier);
    }
}
