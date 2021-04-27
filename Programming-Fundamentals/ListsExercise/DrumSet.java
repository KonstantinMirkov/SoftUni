package com.JavaFundamentals.ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double savings = Double.parseDouble(sc.nextLine());
        String inputAsString = sc.nextLine();
        List<Integer> drumSet = Arrays.stream(inputAsString.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> initialValues = Arrays.stream(inputAsString.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String input = sc.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);

            for (int i = 0; i < drumSet.size(); i++) {
                int initialQuality = drumSet.get(i);
                drumSet.set(i, initialQuality - hitPower);

                if (drumSet.get(i) <= 0) {
                    double price = initialValues.get(i) * 3;
                    if (savings >= price) {
                        drumSet.set(i, initialValues.get(i));
                        savings -= price;
                    } else if (savings < price) {
                        drumSet.remove(i);
                        initialValues.remove(i);
                        i--;
                    }

                }

            }

            input = sc.nextLine();
        }

        for (int drum : drumSet) {
            System.out.print(drum + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);

    }
}
