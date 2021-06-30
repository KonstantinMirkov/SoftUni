package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] phonebookInfo = input.split("-");
            String contactName = phonebookInfo[0];
            String phoneNumber = phonebookInfo[1];
            phonebook.put(contactName, phoneNumber);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] phonebookInfo = input.split("-");
            String contactName = phonebookInfo[0];
            if (!phonebook.containsKey(contactName)) {
                System.out.printf("Contact %s does not exist.%n", contactName);
            } else {
                System.out.printf("%s -> %s%n", contactName, phonebook.get(contactName));
            }
            input = scanner.nextLine();
        }
    }


}
