package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Set<Integer> setN = new LinkedHashSet<>(n);
        Set<Integer> setM = new LinkedHashSet<>(m);

        findNumbersInSet(scanner, n, setN);
        findNumbersInSet(scanner, m, setM);

        setN.retainAll(setM);
        setN.forEach(number -> System.out.print(number + " "));
    }

    private static void findNumbersInSet(Scanner scanner, int count, Set<Integer> set) {
        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();
            set.add(number);
        }
    }
}
