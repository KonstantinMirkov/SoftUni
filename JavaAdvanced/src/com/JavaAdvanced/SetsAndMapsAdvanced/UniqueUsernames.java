package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class UniqueUsernames  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int usernamesCount = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueUsernames = new LinkedHashSet<>();
        for (int i = 0; i < usernamesCount; i++) {
            String username = scanner.nextLine();
           uniqueUsernames.add(username);
        }
        uniqueUsernames.forEach(System.out::println);
    }
}
