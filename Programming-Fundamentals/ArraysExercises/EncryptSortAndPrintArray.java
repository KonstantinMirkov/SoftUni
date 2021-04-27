package com.JavaFundamentals.ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            String sequence = sc.nextLine();
            int len = sequence.length();
            int sum = 0;
            for (int j = 0; j < sequence.length(); j++) {
                char currentChar = sequence.charAt(j);

                if (isVowel(currentChar)) {
                    sum += currentChar * len;
                } else {
                    sum += currentChar / len;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int element :
                numbers) {
            System.out.println(element);
        }
    }

    public static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(c + "");
    }

    public static boolean isConsanant(char c) {
        String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return cons.contains(c + "");
    }
}
