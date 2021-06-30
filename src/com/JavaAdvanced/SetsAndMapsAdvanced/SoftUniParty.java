package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        checkWhoIsOnTheParty(scanner, vip, regular);
        print(vip, regular);
    }

    private static void checkWhoIsOnTheParty(Scanner scanner, Set<String> vip, Set<String> regular) {
        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scanner.nextLine();
        }
    }

    private static void print(Set<String> vip, Set<String> regular) {
        System.out.println(vip.size() + regular.size());
        if (!vip.isEmpty()) {
            vip.forEach(System.out::println);
        }
        if (!regular.isEmpty()) {
            regular.forEach(System.out::println);
        }
    }
}
