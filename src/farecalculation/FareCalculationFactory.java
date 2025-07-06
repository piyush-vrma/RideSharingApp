package farecalculation;

import vehicle.Vehicle;

public class FareCalculationFactory {
    public static FareCalculationStrategy getFareCalculator(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case PremiumSedan -> {
                return new PremiumFare(vehicle);
            }
            case Auto -> {
                return new SharedFare(vehicle);
            }
            default -> {
                return new StandardFare(vehicle);
            }
        }
    }
}
