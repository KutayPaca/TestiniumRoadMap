package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        System.out.println("Lütfen bir cümle giriniz :");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        String[] word = sentence.split(" ");
        List<String> wordList = new ArrayList<>(Arrays.asList(word));

        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            if (word1.length() == 0) continue;
            String newWord = word1.substring(0, 1).toUpperCase() + word1.substring(1).toLowerCase();
            wordList.set(i, newWord);
        }

        System.out.println(String.join(" ", wordList));
        sc.close();
    }
}
