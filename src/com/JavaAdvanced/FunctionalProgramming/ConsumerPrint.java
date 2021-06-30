package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> output = System.out::println;
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(output);
    }
}
