package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class RecursiveFibonacci {

    public static void main(String[] args) {
        printRecursiveFibonacci();
    }

    public static long[] fibonacciInfo;

    private static void printRecursiveFibonacci() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        fibonacciInfo = new long[n + 1];
        System.out.println(getFibonacci(n));
    }

    public static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (fibonacciInfo[n] != 0) {
            return fibonacciInfo[n];
        }
        return fibonacciInfo[n] = getFibonacci(n - 1) + getFibonacci(n - 2);

    }
}