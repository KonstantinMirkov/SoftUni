package com.JavaFundamentals.DataTypesAndVariablesLab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        Double kilometer = meters / 1000.0;
        System.out.printf("%.2f", kilometer );
    }
}
