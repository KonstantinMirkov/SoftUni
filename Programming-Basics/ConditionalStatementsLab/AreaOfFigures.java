package ConditionalStatementsLab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();

        double x1 = Double.parseDouble(scanner.nextLine());

        if (shape.equals("square")) {

            double area = x1 * x1;
            System.out.println(area);
        }

        else if (shape.equals("triangle")) {
            double x2= Double.parseDouble(scanner.nextLine());
            double area = x1 * x2/2;
            System.out.println(area);
        }

        else if (shape.equals("rectangle")) {
            double x2= Double.parseDouble(scanner.nextLine());
            double area = x1 * x2;
            System.out.println(area);
        }

        else if (shape.equals("circle")) {
            double area= (Math.PI * x1 * x1);
            System.out.println(area);
        }

    }
}
