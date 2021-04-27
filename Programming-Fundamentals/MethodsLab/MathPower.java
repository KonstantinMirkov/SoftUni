package com.JavaFundamentals.MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    static double power(double N, Double P)
    {
        return Math.pow(N, P);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double N = Double.parseDouble(sc.nextLine());
        Double P = Double.parseDouble(sc.nextLine());

        System.out.println(new DecimalFormat("0.####").format(power(N,P)));
    }
}
