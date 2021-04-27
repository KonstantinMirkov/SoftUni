package com.JavaFundamentals.ArraysExercise;

import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] field = new int [n];
        String[] bugs = sc.nextLine().split(" ");
        for (int i = 0; i < bugs.length; i++) {
            int bug = Integer.parseInt(bugs[i]);
            if (bug >= 0 && bug < field.length) {
                field[bug] = 1;
            }
        }
        String line = sc.nextLine();
        while (!line.equals("end")){
            String[] commands = line.split(" ");
            int  bugIndex = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flyLength = Integer.parseInt(commands[2]);

            if (bugIndex < 0 || bugIndex >= field.length || field[bugIndex] != 1){
                line = sc.nextLine();
                continue;
            }
            field[bugIndex] = 0;
            if (direction.equals("right")) {
                bugIndex += flyLength;
                while (bugIndex < field.length && field[bugIndex] == 1) {
                    bugIndex += flyLength;
                }
                if (bugIndex < field.length) {
                    field[bugIndex] = 1;
                }
            }else {
                bugIndex -= flyLength;
                while (bugIndex >= 0 && field[bugIndex] == 1) {
                    bugIndex -= flyLength;

                }
                if (bugIndex >= 0){
                    field[bugIndex] = 1;
                }
            }
            line = sc.nextLine();
        }
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
        }
    }
}
