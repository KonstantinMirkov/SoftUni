package com.JavaFundamentals.VehicleCatalogue;

import java.util.*;

public class Exam3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> PetersData = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Log out")) {
            String[] commands = input.split(": ");
            String command = commands[0];


            switch (command) {
                case "New follower":
                    String newFollower = commands[1];
                    if (!PetersData.containsKey(newFollower)) {
                        PetersData.put(newFollower, 0);
                    }
                    break;

                case "Like":
                    String likedUsername = commands[1];
                    int countLikes = Integer.parseInt(commands[2]);

                    if (PetersData.containsKey(likedUsername)) {
                        int currentLikes = PetersData.get(likedUsername);
                        PetersData.put(likedUsername, countLikes + currentLikes);
                    } else {
                        PetersData.put(likedUsername, countLikes);
                    }
                    break;

                case "Comment":
                    String newComment = commands[1];

                    if (PetersData.containsKey(newComment)) {
                        int currentComments = PetersData.get(newComment);
                        PetersData.put(newComment, currentComments + 1);
                    } else {
                        PetersData.put(newComment, 1);
                    }
                    break;

                case "Blocked":
                    String blocked = commands[1];

                    if (PetersData.containsKey(blocked)) {
                        PetersData.remove(blocked);
                    } else {
                        System.out.printf("%s doesn't exist.%n", blocked);
                    }
                    break;
            }

            input = scanner.nextLine();

        }
        System.out.printf("%d followers%n", PetersData.size());
        PetersData.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue() - a.getValue();
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
