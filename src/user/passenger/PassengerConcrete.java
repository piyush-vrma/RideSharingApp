package user.passenger;

import enums.RideStatus;
import mediator.RideDetails;
import notification.RideObserver;
import paymentmode.PaymentStrategy;
import user.BaseUser;
import user.driver.Driver;

public class PassengerConcrete extends BaseUser implements Passenger, RideObserver {

    public PassengerConcrete(String name) {
        super(name);
    }

    @Override
    public void rideStatusUpdate(RideStatus status) {
        System.out.println("Dear Passenger\nRideStatus: " + status);
    }

    @Override
    public Driver bookRide(RideDetails rideDetails) {
        return mediator.bookRide(rideDetails);
    }

    @Override
    public void payFarePrice(PaymentStrategy paymentStrategy, double farePrice) {
        mediator.payFarePrice(paymentStrategy, farePrice);
    }
}
