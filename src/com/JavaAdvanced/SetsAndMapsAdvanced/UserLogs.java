package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> userData = new TreeMap<>();
        while (!input.equals("end")) {

            String[] userInfo = input.split("\\s+");
            String username = userInfo[2].split("=")[1];

            String ip = userInfo[0].split("=")[1];

            // if contains username
            if (userData.containsKey(username)) {
                LinkedHashMap<String, Integer> ips = userData.get(username); //ip -> count
                if (ips.containsKey(ip)) {
                    ips.put(ip, ips.get(ip) + 1);
                } else {
                    ips.put(ip, 1);
                }

            } else {
                userData.put(username, new LinkedHashMap<>());
                userData.get(username).put(ip, 1);
            }

            input = scanner.nextLine();
        }


        printUserLogs(userData);
    }

    private static void printUserLogs(TreeMap<String, LinkedHashMap<String, Integer>> userData) {
        userData.forEach((key, value) -> {
            System.out.println(key + ": ");
            int countEntry = value.size();
            for (var ipEntry : value.entrySet()) {
                //ip -> count
                //IP => count,
                if (countEntry > 1) {
                    System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ", ");
                } else {
                    System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ".");
                }
                countEntry--;
            }
            System.out.println();
        });
    }
}
