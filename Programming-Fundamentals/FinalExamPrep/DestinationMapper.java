package com.JavaFundamentals.FinalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destinationInput = scanner.nextLine();
        String regex = "([\\=\\/])(?<destinations>[A-Z][a-z]{3,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(destinationInput);
        List<String> destinationsList = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {

            String destinations = matcher.group("destinations");

            destinationsList.add(destinations);
            for (int i = 0; i < destinations.length(); i++) {
                travelPoints++;

            }


        }
        System.out.println("Destinations: " + String.join(", ", destinationsList));
        System.out.println("Travel Points: " + travelPoints);
    }
}