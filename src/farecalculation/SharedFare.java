package farecalculation;

import vehicle.Vehicle;

public class SharedFare implements FareCalculationStrategy {
    private final Vehicle vehicle;

    SharedFare(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double calculateFare(int distance) {
        return vehicle.getPerKMFare() * distance * 1.5;
    }
}

