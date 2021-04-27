package com.JavaFundamentals.LabTextProcessing;

import java.util.*;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"end".equals(line)){
            StringBuilder reversed = new StringBuilder();
            for (int i = line.length() - 1; i >= 0 ; i--) {
                reversed.append(line.charAt(i));
            }
            System.out.printf("%s = %s%n",line, reversed.toString());
            line= scanner.nextLine();
        }

    }
}
