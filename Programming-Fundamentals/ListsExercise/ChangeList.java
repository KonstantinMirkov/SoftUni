package com.JavaFundamentals.ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("end")){

            String command = input.split(" ") [0];
            int element = Integer.parseInt(input.split(" ") [1]);
            if(command.equals("Delete")){
                numbers.removeAll(Arrays.asList(element));
            }else if (command.equals("Insert")) {
                int index  = Integer.parseInt(input.split(" ") [2]);
                numbers.add(index, element);
            }
            input = sc.nextLine();
        }
        printList(numbers);
    }
    static void printList (List<Integer> numbers){

        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }
}
