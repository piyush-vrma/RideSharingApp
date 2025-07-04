package farecalculation;

import enums.VehicleType;
import user.driver.Driver;

public class FareCalculationFactory {
    public static FareCalculationStrategy getFareCalculator(Driver driver) {
        if (driver.getVehicleType() == VehicleType.PremiumSedan) {
            return new PremiumFare(driver.getVehicle());
        }
        return new StandardFare(driver.getVehicle());
    }
}
