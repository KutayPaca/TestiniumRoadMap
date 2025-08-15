package questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir cümle gir: ");
        String sentence = scanner.nextLine();

        sentence = sentence.toLowerCase();
        sentence = sentence.replaceAll("[^a-zğüşöçı]", "");

        List<Character> characterList = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            characterList.add(c);
        }

        Map<Character, Long> frekansMap = characterList.stream()
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
