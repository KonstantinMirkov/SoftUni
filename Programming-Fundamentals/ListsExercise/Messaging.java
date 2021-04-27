package com.JavaFundamentals.ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<String> charArray = Arrays.stream(sc.nextLine().split("(?!^)"))
                .collect(Collectors.toList());

        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int ii = 0; ii < String.valueOf(input[i]).length(); ii++) {
                sum += Character.getNumericValue(String.valueOf(input[i]).charAt(ii));
            }
            while (sum >= charArray.size()) sum -= charArray.size();
            System.out.print(charArray.get(sum));
            charArray.remove(sum);
        }
    }
}
