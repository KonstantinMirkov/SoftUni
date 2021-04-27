package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companies = new TreeMap<>();
        String input = scanner.nextLine();
        BeforeInputEnd(scanner, companies, input);
        Print(companies);
    }

    private static void BeforeInputEnd(Scanner scanner, Map<String, List<String>> companies, String input) {
        while (!input.equals("End")) {
            String[] commands = input.split(" -> ");
            String companyName = commands[0];
            String employeesID = commands[1];

            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new ArrayList<>());
            }
            if (companies.containsKey(companyName) && !companies.get(companyName).contains(employeesID)) {
                companies.get(companyName).add(employeesID);
            }
            input = scanner.nextLine();
        }
    }

    private static void Print(Map<String, List<String>> companies) {
        for (var entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            for (String IDs: entry.getValue()) {
                System.out.println("-- " + IDs);
            }
        }
    }
}
