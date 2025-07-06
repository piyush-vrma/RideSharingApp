package notification;

import enums.RideStatus;

public interface RideObserver {
    void rideStatusUpdate(RideStatus status);
}