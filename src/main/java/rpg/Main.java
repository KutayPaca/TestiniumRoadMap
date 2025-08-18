package rpg;

public class Main {
    public static void main(String[] args) {
        Sample sample = new Sample();
        Character mage = new Mage();
        Character archer = new Archer();
        Character warrior = new Warrior();

        sample.performAttack(mage);
        sample.performAttack(archer);
        sample.performAttack(warrior);

    }
}
