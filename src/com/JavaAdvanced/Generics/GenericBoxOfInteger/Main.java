package com.JavaAdvanced.Generics.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Box<Integer> integers = new Box<>();
        int integersCount = Integer.parseInt(scanner.nextLine());

        while (integersCount-- > 0){
            int integer = Integer.parseInt(scanner.nextLine());
            integers.add(integer);
        }

        System.out.println(integers);
    }
}
