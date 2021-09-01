package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int compoundsCount = Integer.parseInt(scanner.nextLine());
        TreeSet<String> setOFCompounds = new TreeSet<>();
        getCompounds(scanner, compoundsCount, setOFCompounds);
        printCompounds(setOFCompounds);
    }

    private static void printCompounds(TreeSet<String> setOFCompounds) {
        setOFCompounds.forEach(element -> System.out.print(element + " "));
    }

    private static void getCompounds(Scanner scanner, int compoundsCount, TreeSet<String> setOFCompounds) {
        for (int compound = 0; compound < compoundsCount; compound++) {
            String compounds = scanner.nextLine();
            String[] elements = compounds.split("\\s+");
            Collections.addAll(setOFCompounds, elements);
        }
    }
}
