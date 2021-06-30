package com.JavaAdvanced.JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Стек:
        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);
        //Опашка:
        Deque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int valueOfTheTask = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty() && valueOfTheTask != 0) {

            int lastTask = tasks.peek();
            int firstThread = threads.peek();


            if (lastTask <= firstThread) {
                if (valueOfTheTask == lastTask) {
                    System.out.printf("Thread with value %d killed task %d", firstThread, valueOfTheTask);
                    valueOfTheTask = 0;
                } else {
                    tasks.pop(); // премахвам от върха на стека
                    threads.poll(); // премахвам от края на опашката
                }
            } else {
                if (valueOfTheTask == lastTask) {
                    System.out.printf("Thread with value %d killed task %d", firstThread, valueOfTheTask);
                    valueOfTheTask = 0;
                } else {
                    threads.poll(); // премахвам от края на опашката
                }
            }
        }
        System.out.println();

        while (!threads.isEmpty()) {
            System.out.print(threads.peek() + " ");
            threads.remove();
        }
    }

}
