package user;

import enums.RideStatus;
import mediator.RideBookingMediator;

public interface User {
    String getName();

    void setRideBookingMediator(RideBookingMediator mediator);

    void rideStatusUpdate(RideStatus status);
}
