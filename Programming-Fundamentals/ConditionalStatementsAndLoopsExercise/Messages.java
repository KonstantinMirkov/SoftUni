package com.JavaFundamentals.ConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        int tapTimes = Integer.parseInt(scan.nextLine());
        StringBuilder message = new StringBuilder();


        for (int i = 0; i < tapTimes; i++) {
            String input = scan.nextLine();


            int numberOfDigits = input.length();
            char buttonNumber = input.charAt(0);

            if (buttonNumber == '2') {
                if (numberOfDigits == 1) {
                    message.append("a");
                } else if (numberOfDigits == 2) {
                    message.append("b");
                } else if (numberOfDigits == 3) {
                    message.append("c");
                }
            } else if (buttonNumber == '3') {
                if (numberOfDigits == 1) {
                    message.append("d");
                } else if (numberOfDigits == 2) {
                    message.append("e");
                } else if (numberOfDigits == 3) {
                    message.append("f");
                }
            } else if (buttonNumber == '4') {
                if (numberOfDigits == 1) {
                    message.append("g");
                } else if (numberOfDigits == 2) {
                    message.append("h");
                } else if (numberOfDigits == 3) {
                    message.append("i");
                }
            } else if (buttonNumber == '5') {
                if (numberOfDigits == 1) {
                    message.append("j");
                } else if (numberOfDigits == 2) {
                    message.append("k");
                } else if (numberOfDigits == 3) {
                    message.append("l");
                }
            } else if (buttonNumber == '6') {
                if (numberOfDigits == 1) {
                    message.append("m");
                } else if (numberOfDigits == 2) {
                    message.append("n");
                } else if (numberOfDigits == 3) {
                    message.append("o");
                }
            } else if (buttonNumber == '7') {
                if (numberOfDigits == 1) {
                    message.append("p");
                } else if (numberOfDigits == 2) {
                    message.append("q");
                } else if (numberOfDigits == 3) {
                    message.append("r");
                } else if (numberOfDigits == 4) {
                    message.append("s");
                }
            } else if (buttonNumber == '8') {
                if (numberOfDigits == 1) {
                    message.append("t");
                } else if (numberOfDigits == 2) {
                    message.append("u");
                } else if (numberOfDigits == 3) {
                    message.append("v");
                }
            } else if (buttonNumber == '9') {
                if (numberOfDigits == 1) {
                    message.append("w");
                } else if (numberOfDigits == 2) {
                    message.append("x");
                } else if (numberOfDigits == 3) {
                    message.append("y");
                } else if (numberOfDigits == 4) {
                    message.append("z");
                }
            } else if (buttonNumber == '0') {
                message.append(" ");
            }
        }
        System.out.println(message);
    }
}
