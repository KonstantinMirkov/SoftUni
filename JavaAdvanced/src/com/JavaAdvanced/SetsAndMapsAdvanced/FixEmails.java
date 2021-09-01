package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input.split("\\s+")[0];
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.put(name, email);
            }

            input = scanner.nextLine();
        }
        print(emails);
    }

    private static void print(Map<String, String> emails) {
        for (var entry : emails.entrySet()) {
            String names = entry.getKey();
            System.out.println(names + " -> " + entry.getValue());
        }
    }
}
