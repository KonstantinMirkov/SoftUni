package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JudgeZadacha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,LinkedHashMap<String, Integer>> judgeContest = new LinkedHashMap<>();


        iterateBeforeEndingInput(scanner, input, judgeContest);
        printResults(judgeContest);


    }

    private static void iterateBeforeEndingInput(Scanner scanner, String input, Map<String, LinkedHashMap<String, Integer>> judgeContest) {
        while(!input.equals("no more time")){
            String[] commands = input.split(" -> ");
            String userName = commands[0];
            String contestName = commands[1];
            int points = Integer.parseInt(commands[2]);

            checkTheContestName(judgeContest, userName, contestName, points);
            input = scanner.nextLine();
        }
    }

    private static void checkTheContestName(Map<String, LinkedHashMap<String, Integer>> judgeContest, String userName, String contestName, int points) {
        if(!judgeContest.containsKey(contestName)){
            judgeContest.put(contestName,new LinkedHashMap<>());
            judgeContest.get(contestName).put(userName, points);
        }else{
            if(judgeContest.get(contestName).containsValue(userName)){
                if (points > judgeContest.get(contestName).get(userName)) {
                    judgeContest.get(contestName).put(userName, points);
                }
            }else{
                    judgeContest.get(contestName).put(userName, points);
                }
        }
    }


    private static void printResults(Map<String, LinkedHashMap<String, Integer>> judgeContest) {
                    AtomicInteger num = new AtomicInteger();
                 judgeContest.forEach((k, v) -> {
                     num.set(0);
                     System.out.printf("%s: %d participants%n", k, v.size());
                     v.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                             .thenComparing(Map.Entry.comparingByKey()))
                             .forEach(e -> System.out.printf("%d. %s <::> %d%n", num.incrementAndGet(), e.getKey(), e.getValue()));
                 });

            System.out.println("Individual standings:");

            Map<String, Integer> results = new LinkedHashMap<>();

            for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : judgeContest.entrySet()) {
                for (Map.Entry<String, Integer> mapEntry : entry.getValue().entrySet()) {
                results.putIfAbsent(mapEntry.getKey(), 0);
                results.put(mapEntry.getKey(), results.get(mapEntry.getKey()) + mapEntry.getValue());
            }
        }

        num.set(0);
        results.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%d. %s -> %d%n", num.incrementAndGet(), e.getKey(), e.getValue()));
    }
}
