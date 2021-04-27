package com.JavaFundamentals.ListsExercise;

import java.util.*;

public class TakeOrSkipRope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Character> strings = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            strings.add(input.charAt(i));
        }

        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < strings.size(); index++) {
            char currentChar = strings.get(index);
            if (Character.isDigit(currentChar)) {
                numbers.add((int) currentChar - 48);
                strings.remove((Character) currentChar);
                index--;
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }


        StringBuilder builder = new StringBuilder();
        int indexTakeSkip = 0;
        int currentIndex = 0;
        label:
        while (strings.size() > 0 && takeList.size() > indexTakeSkip && skipList.size() > indexTakeSkip) {
            int count;
            if (currentIndex > strings.size() - 1) {
                currentIndex = 0;
            }

            count = takeList.get(indexTakeSkip);
            while (count > 0) {
                builder.append(strings.get(0));
                strings.remove(0);
                count--;
                if (strings.size() <= 0) {
                    break label;
                }
            }

            count = skipList.get(indexTakeSkip);
            while (count > 0) {
                strings.remove(0);
                count--;
                if (strings.size() <= 0) {
                    break label;
                }
            }
            indexTakeSkip++;
            currentIndex++;
        }

        System.out.println(builder.toString());
    }
}
