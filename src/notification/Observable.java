package notification;

public interface Observable {
    void notify(RideObserver rideObserver, String rideStatus);
}
