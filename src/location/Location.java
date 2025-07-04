package location;

public class Location {
    private final String name;
    private final int x;
    private final int y;

    public Location(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getDistance(Location location) {
        int netX = Math.abs(this.x - location.x);
        int netY = Math.abs(this.y - location.y);
        int sqDist = netX * netX + netY * netY;
        return (int) Math.sqrt(sqDist);
    }
}
