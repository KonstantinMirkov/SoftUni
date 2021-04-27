package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static int Areas(int width, int height) {
        return width * height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = Integer.parseInt(sc.nextLine());
        int height = Integer.parseInt(sc.nextLine());

        int area = Areas(width, height);
        System.out.println(area);
    }
}
