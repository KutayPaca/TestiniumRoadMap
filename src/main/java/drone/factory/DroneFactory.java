package drone.factory;

import drone.model.Drone;
import drone.model.DroneType;

public class DroneFactory {
    public static Drone createDrone(DroneType type, String name) {
        return new Drone(name, type);
    }
}
