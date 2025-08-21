package drone;

import drone.factory.DroneFactory;
import drone.model.Drone;
import drone.model.DroneType;
import drone.request.DroneRequest;
import drone.strategy.DirectFlyStrategy;
import drone.strategy.ObstacleAvoidanceStrategy;
import drone.strategy.ExplorationStrategy;

public class Main {
    public static void main(String[] args) {
        Drone drone1 = DroneFactory.createDrone(DroneType.SAVUNMA, "Drone-A");
        Drone drone2 = DroneFactory.createDrone(DroneType.SALDIRI, "Drone-B");
        Drone drone3 = DroneFactory.createDrone(DroneType.KESIF, "Drone-C");

        System.out.println("=== Başlangıç Stratejileri ===");
        DroneRequest.requestDrone(drone1, new DirectFlyStrategy(), "Hedef-1");
        DroneRequest.requestDrone(drone2, new ObstacleAvoidanceStrategy(), "Hedef-1");
        DroneRequest.requestDrone(drone3, new ExplorationStrategy(), "Hedef-1");

        System.out.println("\n=== Strateji Değişimi ===");
        DroneRequest.requestDrone(drone1, new ObstacleAvoidanceStrategy(), "Hedef-2");
    }
}
