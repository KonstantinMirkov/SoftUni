package com.JavaAdvanced.DefiningClasses.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());

        List<PersonalInfo> people = new ArrayList<>();
        while (peopleCount-- > 0) {
            String[] personalData = scanner.nextLine().split("\\s+");
            String name = personalData[0];
            int age = Integer.parseInt(personalData[1]);

            if (age > 30) {
                PersonalInfo person = new PersonalInfo(name, age);
                people.add(person);
            }
        }
        people.sort(Comparator.comparing(PersonalInfo::getName));

        people.forEach(p -> System.out.println(p.getName() +  " - " + p.getAge()));
    }
}
