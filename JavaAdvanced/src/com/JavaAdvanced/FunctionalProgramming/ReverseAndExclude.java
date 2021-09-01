package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(listOfNumbers);
        Predicate<Integer> filter = e -> e % n == 0;
        listOfNumbers.removeIf(filter);
       listOfNumbers.forEach(e -> System.out.print(e + " "));
    }
}
