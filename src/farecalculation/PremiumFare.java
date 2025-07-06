package farecalculation;

import vehicle.Vehicle;

public class PremiumFare implements FareCalculationStrategy {
    private final Vehicle vehicle;
    private final double baseFare = 50;
    private final double multiplier = 2.0;

    PremiumFare(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double calculateFare(int distance) {
        return baseFare + (vehicle.getPerKMFare() * distance * multiplier);
    }
}

