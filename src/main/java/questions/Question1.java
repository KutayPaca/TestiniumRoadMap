package questions;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        while(true){ //genel döngü
            System.out.println("Hangi döngü yapısı ile çalıştırmak istersiniz?");
            System.out.println("1. if yapısı ile ");
            System.out.println("2. switch yapısı ile ");
            System.out.print("Seçiminizi girin (1/2): ");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("İf yapısı ile başlıyor");
                    ifStatement(scanner);
                    break;
                case 2:
                    System.out.println("Switch yapısı ile başlıyor");
                    switchStatement(scanner);
                    break;
                default:
                    System.out.println("Seçim geeçrsiz program sonlanıyor");
                    continue; //döngü başına döner
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
    public static void ifStatement(Scanner scanner){
        System.out.print("1 ve 7 arasında sayı giriniz: ");
        int num = scanner.nextInt();
        if (num == 1){
            System.out.println("Pazartesi");
        }
        else if (num == 2){
            System.out.println("Salı");
        }
        else if (num == 3){
            System.out.println("Çarşamba");
        }
        else if (num == 4){
            System.out.println("Perşembe");
        }
        else if (num == 5){
            System.out.println("Cuma");
        }
        else if (num == 6){
            System.out.println("Cumartesi");
        } else if (num == 7) {
            System.out.println("Pazar");
        }
        else {
            System.out.println("Hatalı giriş yaptınız");
        }
    }
    public static void switchStatement(Scanner scanner){
        System.out.print("1 ve 7 arasında sayı giriniz: ");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşmaba");
                break;
            case 4:
                System.out.println("perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.println("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
            default:
                System.out.println("Hatalı seçim yaptınız");
                break;
        }
    }
}
