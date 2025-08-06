package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class soru_3 {
    public static void main(String[] args) {
        System.out.println("Lütfen bir cümle giriniz :");
        Scanner sc = new Scanner(System.in);
        String cumle = sc.nextLine();

        String[] kelimeler = cumle.split(" ");
        List<String> kelimeListesi = new ArrayList<>(Arrays.asList(kelimeler));

        for (int i = 0; i < kelimeListesi.size(); i++) {
            String kelime = kelimeListesi.get(i);
            if (kelime.length() == 0) continue;
            String yeniKelime = kelime.substring(0, 1).toUpperCase() + kelime.substring(1).toLowerCase();
            kelimeListesi.set(i, yeniKelime);
        }

        System.out.println(String.join(" ", kelimeListesi));
        sc.close();
    }
}
