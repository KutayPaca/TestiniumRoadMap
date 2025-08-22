# Custom Exception Oluşturma ve Fırlatma – Java

Bu proje, Java’da kendi custom exception sınıfını nasıl oluşturabileceğinizi ve onu nasıl fırlatıp kullanabileceğinizi gösterir.

---

## 1. Custom Exception Sınıfı Oluşturma

Java’da kendi özel hata sınıfınızı Exception sınıfını extend ederek oluşturabilirsiniz.

```java
package validator;

public class NotValidException extends Exception {
public NotValidException(String message) {
super(message); // Hata mesajını ana Exception sınıfına gönderir
}
}
```


- Exception sınıfını extend ettiğimiz için bu bir checked exception olur.
- Constructor’da super(message) ile hata mesajını ana Exception sınıfına iletiriz.

---

## 2. ValidatorService Sınıfı

Pozitif sayıları valid kabul eden, negatif sayılarda NotValidException fırlatan bir servis sınıfı:

````java
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
````


- Negatif sayı gelirse throw new NotValidException(...) ile exception fırlatılır.
- finally bloğu sayesinde, exception fırlasa da fırlamasada her zaman "işlem tamamlandı" ekrana yazdırılır.

---

## 3. Main Sınıfı – Exception Yönetimi

ValidatorService’i test etmek ve exception’ı yakalamak için:

````java
package validator;

public class Main {
    public static void main(String[] args) {
        ValidatorService validator = new ValidatorService();
        try {
            validator.validate(10);   // Pozitif sayı, sorun yok
            validator.validate(-5);   // Negatif sayı, exception fırlatır
        } catch (NotValidException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}

````

---

## Özet

- Custom exception oluşturmak için Exception sınıfını extend ettik.
- throw ile exception fırlatıldı.
- finally bloğu sayesinde method sonunda her durumda bir mesaj gösterildi.
- try-catch ile exception Main sınıfında yakalandı ve yönetildi.

Bu yöntem, Java’da hata yönetimini kontrol altına almak ve kendi özel durumlarınızı tanımlamak için kullanılır.
