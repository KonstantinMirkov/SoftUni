package com.JavaFundamentals.ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] array = Arrays.stream(sc.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        int biggestCounter = 0;
        int keepFirstIndex = 0;
        int keepSecondIndex = 0;

        int i = 0;

        while(i < array.length - 1 ) {
            int j = i + 1;

            int counter = 1;
            while(j < array.length && array[j] == array[i]){
                counter++;
                j++;
            }
            if(counter > biggestCounter) {
                biggestCounter = counter;
                keepFirstIndex = i;
                keepSecondIndex = j;
            }
            i = j;
        }
        for ( i = keepFirstIndex; i < keepSecondIndex ; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
