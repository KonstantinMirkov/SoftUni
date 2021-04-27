package com.JavaFundamentals.ExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            String commands = command[0];
            switch (commands) {
                case "swap":
                    int swapIndex1 = Integer.parseInt(command[1]);
                    int swapIndex2 = Integer.parseInt(command[2]);
                    Collections.swap(listOfNumbers, swapIndex1, swapIndex2);
                    break;
                case "multiply":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    listOfNumbers.set(index1,listOfNumbers.get(index1)*listOfNumbers.get(index2));
                    break;
                case "decrease":  IntStream.range(0, listOfNumbers.size()).forEach(i -> listOfNumbers.set(i,listOfNumbers.get(i)-1));
                    break;
            }
            input = sc.nextLine();
        }
        System.out.print(Arrays.toString(new List[]{listOfNumbers}).replaceAll("[\\[\\]]", ""));

    }
}
