package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> printerQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                String canceledFile = printerQueue.poll();
                if (canceledFile != null) {
                    System.out.println("Canceled " + canceledFile);
                } else {
                     System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();

        }
        printerQueue.forEach(System.out::println);
    }
}
