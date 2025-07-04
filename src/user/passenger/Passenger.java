package user.passenger;

import mediator.RideDetails;
import paymentmode.PaymentStrategy;
import user.driver.Driver;

/**
 * Passenger can:
 * 1. bookRide
 * 2. pay fare price
 **/
public interface Passenger {
    Driver bookRide(RideDetails rideDetails);

    void payFarePrice(PaymentStrategy paymentStrategy, double farePrice);
}

