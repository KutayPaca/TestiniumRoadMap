package validator;

public class ValidatorService {

    public void validate(int number) throws NotValidException {
        try {
            if (number < 0) {
                throw new NotValidException("girilen sayı negatif");
            }
        } finally {
            System.out.println("işlem tamamlandı");
        }
    }
}
