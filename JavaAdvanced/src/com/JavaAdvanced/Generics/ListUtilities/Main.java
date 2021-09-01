package com.JavaAdvanced.Generics.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = List.of(33, 60, 69,89, 10);

        List<String> listOfStrings = List.of("a", "B", "d");

        List<Integer> emptyList = List.of();
        System.out.println(ListUtils.getMin(listOfStrings));
        System.out.println(ListUtils.getMax(listOfStrings));
        System.out.println(ListUtils.getMin(listOfIntegers));
        System.out.println(ListUtils.getMax(listOfIntegers));
    }
}
