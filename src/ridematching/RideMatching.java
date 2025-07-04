package ridematching;

import mediator.RideDetails;
import user.driver.Driver;

import java.util.List;

public class RideMatching {
    public static Driver findNearestDriver(RideDetails rideDetails, List<Driver> drivers) {
        int minDist = Integer.MAX_VALUE;
        Driver nearestAvailableDriver = null;

        for (Driver driver : drivers) {
            if (rideDetails.getVehicleType() == driver.getVehicleType() && driver.isAvailable()) {
                int dist = rideDetails.getPickUp().getDistance(driver.getCurrentLocation());
                if (dist < minDist) {
                    minDist = dist;
                    nearestAvailableDriver = driver;
                }
            }
        }

        return nearestAvailableDriver;
    }
}
