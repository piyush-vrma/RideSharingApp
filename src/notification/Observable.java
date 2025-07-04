package notification;

import enums.RideStatus;
import user.driver.Driver;
import user.passenger.Passenger;

public interface Observable {
    void notify(Passenger passenger, Driver driver, RideStatus rideStatus);
}
