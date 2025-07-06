package mediator;

import paymentmode.PaymentStrategy;
import user.driver.Driver;
import user.passenger.Passenger;

public class RideController {
    private final RideBookingMediator mediator;

    public RideController(RideBookingMediator mediator) {
        this.mediator = mediator;
    }

    public void bookAndCompleteRide(Passenger passenger, RideDetails rideDetails, PaymentStrategy paymentMethod) {
        Driver driver = passenger.bookRide(rideDetails);
        if (driver != null) {
            double fare = mediator.completeRide(driver);
            passenger.payFarePrice(paymentMethod, fare);
        }
    }
}

