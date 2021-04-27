package com.JavaFundamentals.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Lines> lines = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Lines p = new Lines(name, id, age);


            lines.add(p);

            input = sc.nextLine();
        }
        lines.sort((f, s) -> f.getAge() - s.getAge());

        for (Lines line : lines) {
            System.out.println(String.format("%s with ID: %s is %d years old.", line.getName(), line.getId(), line.getAge()));
        }
    }
}
