package user;

import mediator.RideBookingMediator;

public interface User {
    String getName();

    void setRideBookingMediator(RideBookingMediator mediator);
}
