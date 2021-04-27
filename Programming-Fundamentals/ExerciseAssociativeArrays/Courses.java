package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        BeforeInputEnd(scanner, input, courses);
        Print(courses);
    }

    private static void Print(Map<String, List<String>> courses) {
        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(student -> System.out.println("-- " + student));
                });
    }

    private static void BeforeInputEnd(Scanner scanner, String input, Map<String, List<String>> courses) {
        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];
            input = scanner.nextLine();

            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
            }
            courses.get(course).add(studentName);
        }
    }

}
