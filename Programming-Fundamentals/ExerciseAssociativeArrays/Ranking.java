package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contests = new LinkedHashMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();
        UntilInputEndOfContests(scanner, contests, input);

        input = scanner.nextLine();
        UntilInputEndOfSubmission(scanner, contests, users, input);

        int totalSum = getTotalSum(users);

        Print(users, totalSum);
    }

    private static void UntilInputEndOfContests(Scanner scanner, LinkedHashMap<String, String> contests, String input) {
        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];

            contests.put(contest, password);

            input = scanner.nextLine();
        }
    }

    private static void UntilInputEndOfSubmission(Scanner scanner, LinkedHashMap<String, String> contests, TreeMap<String, LinkedHashMap<String, Integer>> users, String input) {
        while (!input.equals("end of submissions")) {
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String userName = tokens[2];
            int userPoints = Integer.parseInt(tokens[3]);

            if (contests.containsKey(contest)) {
                if (contests.get(contest).equals(password)) {

                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(contest, userPoints);

                    if (!users.containsKey(userName)) {
                        users.put(userName, course);
                    } else {
                        if (!users.get(userName).containsKey(contest)) {
                            users.get(userName).put(contest, userPoints);
                        } else {
                            users.get(userName).put(contest, Math.max(userPoints, users.get(userName).get(contest)));
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static int getTotalSum(TreeMap<String, LinkedHashMap<String, Integer>> users) {
        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }
        return totalSum;
    }

    private static void Print(TreeMap<String, LinkedHashMap<String, Integer>> users, int totalSum) {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }

        System.out.println("Ranking:");
        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
    }
}
