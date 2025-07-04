package mediator;

import paymentmode.PaymentStrategy;
import user.driver.Driver;
import user.passenger.Passenger;

public interface RideBookingMediator {
    void addPassenger(Passenger passenger);

    void removePassenger(Passenger passenger);

    void addDriver(Driver driver);

    void removeDriver(Driver driver);

    // returns the assigned driver
    Driver bookRide(RideDetails rideDetails);

    // returns final fare
    double completeRide(Driver driver);

    void payFarePrice(PaymentStrategy paymentStrategy, double farePrice);
}
