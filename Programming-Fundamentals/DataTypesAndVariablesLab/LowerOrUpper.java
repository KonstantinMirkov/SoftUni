package com.JavaFundamentals.DataTypesAndVariablesLab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ch = sc.nextLine();
        char c = ch.charAt(0);
        if (c >= 'A' && c <= 'Z')
            System.out.println("upper-case");

        else if (c >= 'a' && c <= 'z')
            System.out.println("lower-case");
    }
}
