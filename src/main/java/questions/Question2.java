package questions;

import java.util.Random;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {

        /*random bir int sayı tutacak yazılım, kullanıcının 3 tahmin hakkı olacak.
         doğru bilirse bildiniz diyip bitecek. bilemezse 2 hakkınız, 1 hakkınız kaldı diye
         tekrar girmesini istiyecek. bu soruyu for, do-while ve while yapıları ile ayrı ayrı yazmalıyız
         */

        Scanner scanner = new Scanner(System.in);
        while (true) { //oyun döngüsü

            System.out.println("Hangi döngü yapısı ile çalıştırmak istersiniz?");
            System.out.println("1. For döngüsü");
            System.out.println("2. Do-While döngüsü");
            System.out.println("3. While döngüsü");
            System.out.print("Seçiminizi girin (1/2/3): ");

            int choice = scanner.nextInt(); //javada input girişi varsayılan olarak string onu int convert ettim

            switch (choice) { //seçim menüüs için switch case yapısı kullandım
                case 1:
                    System.out.println("For döngüsü ile başlıyor...");
                    forLoopGame(scanner);
                    break;
                case 2:
                    System.out.println("Do-While döngüsü ile başlıyor...");
                    doWhileLoopGame(scanner);
                    break;
                case 3:
                    System.out.println("While döngüsü ile başlıyor...");
                    whileLoopGame(scanner);
                    break;
                default:
                    System.out.println("Geçersiz seçim, program sonlanıyor.");
                    return;
            }

            System.out.print("Tekrar oynamak ister misiniz? (e/h): ");
            String answer = scanner.next();

            if (!answer.equals("e") && !answer.equals("E")) { //verilen answer e ye eşit değilse oyun döngüsü break ile kırılır
                System.out.println("Oyundan çıkılıyor...");
                break;
            }
        }

        scanner.close();
    }

    private static void forLoopGame(Scanner scanner) {
        Random random = new Random(); // random sayı tutulur
        int randomNum = random.nextInt(10); // 0 ile 10'a kadar
        System.out.println("0 ile 9 arasında sayı tuttum, 3 hakkınız var.");

        for (int attempts = 3; attempts > 0; attempts--) { // başlangıçta 3 değerini alan attempts döngü her başladığında bir azalır
            System.out.print("Tahmininizi girin: ");
            int guess = scanner.nextInt();

            if (guess == randomNum) {
                System.out.println("Tebrikler, doğru bildiniz!");
                return;
            } else {
                if (attempts - 1 > 0) { //eğer kullanıcı yanlış tahmin ederse attempti bir azaltır ve 0 dan büüyk mü diye bakarız
                    System.out.println("Yanlış. Kalan hakkınız: " + (attempts - 1));
                } else {
                    System.out.println("Tahmin hakkınız bitti. Doğru sayı: " + randomNum);
                }
            }
        }
    }

    private static void doWhileLoopGame(Scanner scanner) {
        Random random = new Random(); //random sayı
        int randomNum = random.nextInt(10); //0-10

        System.out.println("0 ile 9 arasında sayı tuttum, 3 hakkınız var.");
        int attempts = 3;
        int guess;
        do { //her halikarda en az bir kere çalışır
            System.out.print("Tahmininizi girin: ");
            guess = scanner.nextInt(); //convert işlemi
            if (guess == randomNum) {
                System.out.println("Tebrikler, doğru bildiniz!");
                return; // doğru tahmin edilse bile döngü devam etmemesi için return attık
            } else {
                attempts--; // yanlış bilindiği için attempts azalttık
                if (attempts > 0) {
                    System.out.println("Yanlış. Kalan hakkınız: " + attempts);
                } else {
                    System.out.println("Tahmin hakkınız bitti. Doğru sayı: " + randomNum);
                }
            }
        } while (attempts > 0); //attempts 0 dan büyük olduğu sürece döngüye devam et
        // do-while döngüsünde koşul döngü sonunda kontrol edilir
    }

    private static void whileLoopGame(Scanner scanner) {
        Random random = new Random(); // random sayı
        int randomNum = random.nextInt(10); //0-10
        System.out.println("0 ile 9 arasında sayı tuttum, 3 hakkınız var.");

        int attempts = 3; //3 hak
        while (attempts > 0) { // attempts 0 dan büyük olduğu sürece döngüyü devam ettir
            System.out.print("Tahmininizi girin: ");
            int guess = scanner.nextInt(); //convert işlemi

            if (guess == randomNum) {
                System.out.println("Tebrikler, doğru bildiniz!");
                return;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Yanlış. Kalan hakkınız: " + attempts);
                } else {
                    System.out.println("Tahmin hakkınız bitti. Doğru sayı: " + randomNum);
                }
            }
        }
    }
}