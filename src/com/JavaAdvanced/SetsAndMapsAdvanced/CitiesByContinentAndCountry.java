package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCountries = Integer.parseInt(scanner.nextLine());
        Map<String, LinkedHashMap<String, ArrayList<String>>> countriesData = new LinkedHashMap<>();

        mapCountriesData(scanner, numberOfCountries, countriesData);
        print(countriesData);
    }

    private static void mapCountriesData(Scanner scanner, int numberOfCountries, Map<String, LinkedHashMap<String, ArrayList<String>>> countriesData) {
        while (numberOfCountries-- > 0) {
            String[] commands = scanner.nextLine().split("\\s+");

            String continent = commands[0];
            String country = commands[1];
            String city = commands[2];

            countriesData.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, ArrayList<String>> innerMap = countriesData.get(continent);
            innerMap.putIfAbsent(country, new ArrayList<>());
            innerMap.get(country).add(city);
        }
    }

    private static void print(Map<String, LinkedHashMap<String, ArrayList<String>>> countriesData) {
        for (var entry : countriesData.entrySet()) {
            String continent = entry.getKey();
            LinkedHashMap<String, ArrayList<String>> innerMap = entry.getValue();
            System.out.println(continent + ":");
            for (var innerEntry : innerMap.entrySet()) {
                System.out.println("  " + innerEntry.getKey() + " -> " + String.join(", ", innerEntry.getValue()));
            }
        }
    }
}
