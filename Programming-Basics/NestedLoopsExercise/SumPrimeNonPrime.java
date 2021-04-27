package NestedLoopsExercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;


        while (!line.equals("stop")) {
            boolean flag = false;

            int number = Integer.parseInt(line);

            if (number < 0) {
                System.out.println("Number is negative.");
                line = scanner.nextLine();
                continue;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                nonPrimeSum += number;
            } else {
                primeSum += number;
            }
            line = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeSum);
    }
}
