package com.JavaAdvanced.Workshops.Workshop1;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();
        //Implementation that works as ArrayList.
        //But stores only int elements.
        List<Integer> numbers = new ArrayList<>();

        IntStream.range(0, 100).forEach(numbers::add);
    }
}
