package NestedLoopsExercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (int i = num1; i <= num2; i++) {
            int number = i;
            int evenSum = 0;
            int oddSum = 0;
            // String currentNum = "" + i;
            for (int j = 6; j >= 1; j--) {
                int digit = number % 10;
                number /= 10;
                if (j % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
            if(evenSum == oddSum){
                System.out.print(i + " ");
            }
        }
    }
}
