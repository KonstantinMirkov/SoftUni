package com.JavaFundamentals.ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1){
                break;
            }
            int curElement = numbers.get(i);
            int oppositeElement = numbers.get(numbers.size() - 1);

            numbers.set(i, curElement + oppositeElement);
            numbers.remove(numbers.size() - 1);
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
