package com.JavaFundamentals.RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexOfEmail = "(([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+))(@)([a-zA-Z]+.[a-zA-Z]+[\\.\\-_]?([a-zA-Z0-9]+))";
        Pattern pattern = Pattern.compile(regexOfEmail);
        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
