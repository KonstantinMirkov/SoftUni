package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childes = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();

        for (String child : childes) {
            queue.offer(child);
        }
        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
                System.out.println("Removed " + queue.poll());

        }
        System.out.println("Last is " + queue.poll());
    }
}
