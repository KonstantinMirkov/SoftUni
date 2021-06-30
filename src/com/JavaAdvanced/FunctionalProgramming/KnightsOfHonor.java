package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> output = name -> System.out.println("Sir " + name);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(output);
    }
}
