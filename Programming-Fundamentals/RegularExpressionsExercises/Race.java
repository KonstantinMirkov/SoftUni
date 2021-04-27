package com.JavaFundamentals.RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexForNames = "[A-Za-z]+";
        String regexForDistance = "[0-9]";
        Pattern namePattern = Pattern.compile(regexForNames);
        Pattern distancePattern = Pattern.compile(regexForDistance);


        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersDistance = new LinkedHashMap<>();
        racers.forEach(racer -> racersDistance.put(racer, 0));
        String input = scanner.nextLine();


        while (!input.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder nameOfTheRacer = new StringBuilder();
            while (nameMatcher.find()) {
                nameOfTheRacer.append(nameMatcher.group());
            }
            int distance = 0;
            Matcher distanceMatcher = distancePattern.matcher(input);
            while (distanceMatcher.find()) {
                distance += Integer.parseInt(distanceMatcher.group());
            }
            if (racersDistance.containsKey(nameOfTheRacer.toString())) {
                racersDistance.put(nameOfTheRacer.toString(), racersDistance.get(nameOfTheRacer.toString()) + distance);
            }
            input = scanner.nextLine();
        }
       List<String> topThreeRacers = racersDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + topThreeRacers.get(0));
        System.out.println("2nd place: " + topThreeRacers.get(1));
        System.out.println("3rd place: " + topThreeRacers.get(2));
    }
}
