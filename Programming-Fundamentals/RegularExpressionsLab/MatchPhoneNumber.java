package com.JavaFundamentals.RegularExpressionsLab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b";
        String phoneNumber = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher phoneMatcher = pattern.matcher(phoneNumber);

        List<String> matchedPhones = new ArrayList<>();

        while (phoneMatcher.find()){
            matchedPhones.add(phoneMatcher.group());
        }
        System.out.println(matchedPhones.toString().replaceAll("[\\]\\[]", ""));
    }
}
