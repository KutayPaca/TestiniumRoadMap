package drone.strategy;

public class ExplorationStrategy implements FlyStrategy {
    @Override
    public void fly(String droneName, String destination) {
        System.out.println(droneName + " keşif yaparak " + destination + " hedefine ulaşıyor.");
    }
}
