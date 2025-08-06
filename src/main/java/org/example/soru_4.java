package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class soru_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir cümle gir: ");
        String cumle = scanner.nextLine();

        cumle = cumle.toLowerCase();
        cumle = cumle.replaceAll("[^a-zğüşöçı]", "");

        List<Character> karakterListesi = new ArrayList<>();
        for (char c : cumle.toCharArray()) {
            karakterListesi.add(c);
        }

        Map<Character, Long> frekansMap = karakterListesi.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<Character, Long>> maxEntry = frekansMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxEntry.isPresent()) {
            System.out.println("En çok tekrar eden harf: " + maxEntry.get().getKey() +
                    " (" + maxEntry.get().getValue() + " kere)");
        } else {
            System.out.println("Geçerli harf bulunamadı.");
        }
    }
}
