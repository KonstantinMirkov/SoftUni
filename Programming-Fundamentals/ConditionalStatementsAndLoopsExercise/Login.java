package com.JavaFundamentals.ConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String user = sc.nextLine();
        String pass = sc.nextLine();
        StringBuilder sb = new StringBuilder(user);
        String reversedUser = sb.reverse().toString();
        int counter = 0;
        while(true) {
            if(!pass.equals(reversedUser)) {
                counter++;
                if(counter == 4) {
                    System.out.println("User " + user + " blocked!");
                    return ;
                }
                System.out.println("Incorrect password. Try again.");
            } else {
                System.out.println("User " + user + " logged in.");
                break;
            }
            pass = sc.nextLine();
        }

    }
}
