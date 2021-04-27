package com.JavaFundamentals.ConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = Integer.parseInt(sc.nextLine());
        int minute = Integer.parseInt(sc.nextLine());

        minute += 30;
        if (minute >= 60) {
            minute -= 60;
            hour++;
            if (hour >= 24) {
                hour -= 24;
            }
        }
        System.out.printf("%d:%02d", hour, minute);
    }
}
