package ForLoopExercise;

import java.util.Scanner;

public class DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;


        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 2 == 0) {
                sum2+=1;
            } if (number % 3 == 0) {
                sum3+=1;
            } if (number % 4 == 0) {
                sum4+=1;
            }


        }
        double p1 = sum2 / n * 100;
        double p2 = sum3 / n * 100;
        double p3 = sum4 / n * 100;

        System.out.printf("%.2f%%%n", p1 );
        System.out.printf("%.2f%%%n",  p2 );
        System.out.printf("%.2f%%%n", p3);
    }
}
