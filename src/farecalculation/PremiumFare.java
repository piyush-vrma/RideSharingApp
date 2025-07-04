package farecalculation;

import vehicle.Vehicle;

public class PremiumFare implements FareCalculationStrategy {
    private final Vehicle vehicle;

    PremiumFare(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double calculateFare(int distance) {
        return vehicle.getPerKMFare() * distance * 12.5;
    }
}

