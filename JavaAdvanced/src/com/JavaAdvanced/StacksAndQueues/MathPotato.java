package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] childes = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();

        int cycle = 1;
        for (String child : childes) {
            queue.offer(child);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}