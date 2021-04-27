package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static String stringRepeat(String input, int repeatCount) {

        String[] result = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            result[i] = input;
        }
        return String.join("", result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int repeatCount = Integer.parseInt(sc.nextLine());
        String repeater = stringRepeat(input, repeatCount);
        System.out.println(repeater);
    }
}
