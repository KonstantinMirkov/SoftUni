package com.JavaFundamentals.ExamPreparation;

import java.util.*;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeEfficiency1 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency2 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency3 = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());

        int hoursCount = 0;
        int totalQuestionsToAnswer = employeeEfficiency1 + employeeEfficiency2 + employeeEfficiency3;

        while (peopleCount > 0){
            peopleCount -= totalQuestionsToAnswer;
            hoursCount++;

        if(hoursCount % 4 == 0){
            hoursCount++;
        }
        }
        System.out.printf("Time needed: %dh.",hoursCount);
    }
}
