package com.JavaAdvanced.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> robots = Arrays.stream(scanner.nextLine()
                .split(";"))
                .collect(Collectors.toList());

        String[] robotsNames = new String[robots.size()];
        int[] robotsProcessTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] robotsData = robots.get(i).split("-");
            String robotName = robotsData[0];
            robotsNames[i] = robotName;
            int processTime = Integer.parseInt(robotsData[1]);
            robotsProcessTime[i] = processTime;
        }
        String startTime = scanner.nextLine();
        Deque<String> productsQueue = new ArrayDeque<>();
        String inputProduct = scanner.nextLine();
        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }
        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotWorkLeft = new int[robots.size()];
        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;

            String product = productsQueue.poll();
            int index = -1;
            for (int i = 0; i < robotWorkLeft.length; i++) {
                if (robotWorkLeft[i] > 0) {
                    robotWorkLeft[i]--;
                }

                if (robotWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }
            if (index != -1) {
                robotWorkLeft[index] = robotsProcessTime[index];
                System.out.println(printRobotData(robotsNames[index], product, startTimeInSeconds));
            } else {
                productsQueue.offer(product);
            }
        }
    }

    private static String printRobotData(String robot, String product, int beginTime) {
        long seconds = beginTime % 60;
        long minutes = (beginTime / 60) % 60;
        long hours = (beginTime / (60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return String.format("%s - %s [%s]", robot, product, time);
    }
}
