package com.JavaFundamentals.ArraysLab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        String[] days = new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        int day = new Scanner(System.in).nextInt();

        if (day >= 1 && day <= 7) {
            System.out.println(days[day - 1]);
        }
        else {
            System.out.println("Invalid day!");
        }
    }
}
