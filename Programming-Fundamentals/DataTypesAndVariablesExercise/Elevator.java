package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personsNum = Integer.parseInt(sc.nextLine());
        int capOfPeople = Integer.parseInt(sc.nextLine());
        int courses = personsNum / capOfPeople;
        if (personsNum <= capOfPeople) {
            System.out.println("1");
        } else if (personsNum % capOfPeople == 0) {
            System.out.println(courses);
        } else {
            courses += 1;
            System.out.println(courses);
        }
    }
}
