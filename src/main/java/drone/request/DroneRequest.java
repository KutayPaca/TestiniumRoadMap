package drone.request;

import drone.model.Drone;
import drone.strategy.FlyStrategy;

public class DroneRequest {

    public static void requestDrone(Drone drone, FlyStrategy strategy, String destination) {
        if (!drone.getType().isActive()) {
            System.out.println("[" + drone.getType() + "] Bu drone aktif değil, uçuş iptal edildi!");
            return;
        }
        System.out.print("[" + drone.getType() + "] ");
        strategy.fly(drone.getName(), destination);
    }
}
