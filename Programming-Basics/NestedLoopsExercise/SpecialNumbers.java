package NestedLoopsExercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

//цифра на хилядите
        for (int i = 1; i <= 9; i++) {
            //цифра на стотиците
            for (int j = 1; j <= 9; j++) {
                //цифра на десетиците
                for (int k = 1; k <= 9; k++) {
                    //цифра на единиците
                    for (int l = 1; l <= 9; l++) {
                        if (N % i == 0 && N % j == 0 && N % k == 0 && N % l == 0 ) {

                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
