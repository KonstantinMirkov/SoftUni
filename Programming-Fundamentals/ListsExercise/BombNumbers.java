package com.JavaFundamentals.ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bombNum = bombInfo.get(0);
        int power = bombInfo.get(1);

        while (list.contains(bombNum)) {
            int bombPosition = list.indexOf(bombNum);
            int leftBound = Math.max(0, bombPosition - power);
            int rightBound = Math.min(list.size() - 1, bombPosition + power);

            for (int i = rightBound; i >= leftBound; i--) {
                list.remove(i);
            }
        }
        printSum(list);
    }

    private static void printSum(List<Integer> list) {
        int sum = 0;
        for (Integer n : list) {
            sum += n;
        }
        System.out.println(sum);
    }
}
