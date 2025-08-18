package rpg;

public class Sample {
    // Tek method, tüm alt class tiplerini parametre olarak alacak
    public void performAttack(Character character) {
        character.attack(); //Polimorfizm
    }
}
