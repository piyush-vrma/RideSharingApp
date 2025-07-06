package vehicle;

import enums.VehicleType;

public interface Vehicle {
    VehicleType getVehicleType();

    double getPerKMFare();

    String getName();

    String getNumberPlate();
}
