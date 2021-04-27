package com.JavaFundamentals.ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> first = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> second = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> combined = new ArrayList<>();


        int index = 0;
        while (first.size() > 0 && second.size() > 0) {
            combined.add(first.get(index));
            combined.add(second.get(second.size() - 1));
            first.remove(index);
            second.remove(second.size() - 1);
        }

        int firstRange = 0;
        int secondRange = 0;
        boolean isFirstBigger = first.size() > second.size();
        List<Integer> filtered = new ArrayList<>();

        if (isFirstBigger) {
            firstRange = first.get(0);
            secondRange = first.get(1);
        } else {
            firstRange = second.get(0);
            secondRange = second.get(1);
        }

        for (int i = 0; i < combined.size(); i++) {
            if (firstRange > secondRange) {
                if (combined.get(i) > secondRange && combined.get(i) < firstRange) {
                    filtered.add(combined.get(i));
                }
            } else {
                if (combined.get(i) > firstRange && combined.get(i) < secondRange) {
                    filtered.add(combined.get(i));
                }

            }

        }

        Collections.sort(filtered);
        for (int number : filtered) {
            System.out.print(number + " ");
        }

    }
}
