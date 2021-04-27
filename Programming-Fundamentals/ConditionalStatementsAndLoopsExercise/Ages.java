package com.JavaFundamentals.ConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int years = Integer.parseInt(sc.nextLine());
        if (years >= 0 && years <= 2){
            System.out.print("baby");
        }else if (years >= 3 && years <= 13){
            System.out.print("child");
        }else if (years >= 14 && years <= 19){
            System.out.print("teenager");
        }else if (years >= 20 && years <= 65){
            System.out.print("adult");
        }else if (years >= 66){
            System.out.print("elder");
        }
    }
}
