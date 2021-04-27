package com.JavaFundamentals.MapsLambdaAndStreamAPILab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayOfWords = scanner.nextLine().split(" ");
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : arrayOfWords) {
            String wordInLowerCase = word.toLowerCase();
            if (counts.containsKey(wordInLowerCase)) {
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
            } else {
                counts.put(wordInLowerCase, 1);
            }
        }
        List<String> oddWords = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1){
                oddWords.add(entry.getKey());
            }
        }
        for (int i = 0; i < oddWords.size(); i++) {
            System.out.print(oddWords.get(i));
            if(i < oddWords.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
