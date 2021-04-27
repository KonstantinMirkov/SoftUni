package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void positive() {
        Scanner scanner = new Scanner(System.in);
        int printSign = scanner.nextInt();
        if(printSign > 0){
            System.out.printf("The number %d is positive.", printSign);
        }else if (printSign < 0 ){
            System.out.printf("The number %d is negative.",printSign);
        }else {
            System.out.printf("The number %d is zero.",printSign );
        }
    }
    public static void main(String[] args) {

        positive();

    }
}
