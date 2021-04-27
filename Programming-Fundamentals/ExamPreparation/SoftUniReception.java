package com.JavaFundamentals.ExamPreparation;

import java.util.*;
public class SoftUniReception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());
        int n3 = Integer.parseInt(sc.nextLine());
        int StudentsCount = Integer.parseInt(sc.nextLine());

        int hoursNeed = 0;
        int questionsPerHour = n1 + n2 + n3;

        while (StudentsCount > 0){
            StudentsCount -= questionsPerHour;
            hoursNeed++;

            if (hoursNeed % 4 == 0) {
                hoursNeed++;
            }

        }
        System.out.printf("Time needed: %dh.",hoursNeed);
    }
}

