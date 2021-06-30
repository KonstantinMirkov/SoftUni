package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int namesLength = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> checkNamesLength = name -> name.length() <= namesLength;

       Arrays.stream(names).filter(checkNamesLength).forEach(System.out::println);
    }
}
