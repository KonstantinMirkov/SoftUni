package ConditionalStatementsExercise;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String result = scanner.nextLine();

        if (input.equals("mm")) {
            number = number / 1000;
        } else if (input.equals("cm")) {
            number = number / 100;
        }
        else if (input.equals("m")) {
            number = number / 1;
        }

        if (result.equals("mm")) {
            number = number * 1000;
        } else if (result.equals("cm")) {
            number = number * 100;
        }
        else if (result.equals("m")) {
            number = number * 1;
        }
        System.out.printf("%.3f", number);
    }
}
