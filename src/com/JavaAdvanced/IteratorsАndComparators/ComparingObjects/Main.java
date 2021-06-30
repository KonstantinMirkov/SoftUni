package com.JavaAdvanced.IteratorsАndComparators.ComparingObjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> peopleData = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            peopleData.add(person);
            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person searchedPerson = peopleData.get(n - 1);
        int countEquals = 0;

        for (Person person : peopleData) {
            if (searchedPerson.compareTo(person) == 0) {
                countEquals++;
            }
        }

        if (countEquals == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(countEquals + " " + (peopleData.size() - countEquals) + " " + peopleData.size());
        }
    }
}
