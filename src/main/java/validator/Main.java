package validator;

public class Main {
    public static void main(String[] args) {
        ValidatorService validator = new ValidatorService();

        try {
            validator.validate(10);   // geçerli
            validator.validate(-5);   // exception fırlatır
        } catch (NotValidException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
