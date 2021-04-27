package com.JavaFundamentals.ExamTesting;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Complete")) {
            String[] commands = input.split(" ");
            String command = commands[0];

            switch (command) {
                case "Make":
                    if ("Upper".equals(commands[1])) {
                        email = email.toUpperCase();
                    } else {
                        email = email.toLowerCase();
                    }
                    System.out.println(email);
                case "GetDomain":
                    int countToGet = Integer.parseInt(commands[1]);
                    String domain = email.substring(email.length() - countToGet);
                    System.out.println(domain);
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        String subString = "@";
                        String start = email.substring(email.length(), subString.length());
                        System.out.println(start);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;
                case "Replace":
                    String replacing = commands[1];
                    email = email.replace(replacing, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":

            }
        }
    }
}
