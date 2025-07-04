package user;

import mediator.RideBookingMediator;

public abstract class BaseUser implements User {
    protected final String name;
    protected RideBookingMediator mediator;

    protected BaseUser(String name) {
        this.name = name;
    }

    @Override
    public void setRideBookingMediator(RideBookingMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return name;
    }
}
