package com.JavaFundamentals.DataTypesAndVariablesLab;

import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        double dul, sh, V = 0;

        System.out.print("Length: ");
        dul = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: " );
        sh = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        V = Double.parseDouble(scanner.nextLine());
        double Volume = (dul * sh * V) / 3;
        System.out.printf("Pyramid Volume: %.2f", Volume);

    }
}
