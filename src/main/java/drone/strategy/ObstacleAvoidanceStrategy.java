package drone.strategy;

public class ObstacleAvoidanceStrategy implements FlyStrategy {
    @Override
    public void fly(String droneName, String destination) {
        System.out.println(droneName + " engelleri algılıyor ve " + destination + " hedefine güvenli bir rota ile ulaşıyor");
    }
}
