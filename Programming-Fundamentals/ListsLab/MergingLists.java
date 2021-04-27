package com.JavaFundamentals.ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int size = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < size; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }
        PrintTheRest(firstList,size);
        PrintTheRest(secondList,size);
    }
    static void PrintTheRest(List<Integer> numbers, int beginIndex){
        for (int i = beginIndex; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }

    }
}
