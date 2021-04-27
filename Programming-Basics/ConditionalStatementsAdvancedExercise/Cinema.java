package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        double income = 0.0;

        if ("Premiere".equals(projection)){
            income= rows * columns * 12;
        }
        if ("Normal".equals(projection)){
            income= rows * columns * 7.50;
        }
        if ("Discount".equals(projection)){
            income= rows * columns * 5;
        }
        System.out.printf("%.2f", income);
        System.out.println(" leva");
    }
}
