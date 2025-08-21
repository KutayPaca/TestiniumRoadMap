package drone.model;

public class Drone {
    private String name;
    private DroneType type;

    public Drone(String name, DroneType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public DroneType getType() {
        return type;
    }
}
