package farecalculation;

import vehicle.Vehicle;

public class SharedFare implements FareCalculationStrategy {
    private final Vehicle vehicle;
    private final double baseFare = 10;
    private final double multiplier = 0.5;

    SharedFare(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double calculateFare(int distance) {
        return baseFare + (vehicle.getPerKMFare() * distance * multiplier);
    }
}

