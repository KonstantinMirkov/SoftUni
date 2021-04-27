package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        boolean fruitType = fruit.equals("banana") ||
                fruit.equals("apple") ||
                fruit.equals("orange") ||
                fruit.equals("grapefruit") ||
                fruit.equals("kiwi") ||
                fruit.equals("pineapple") ||
                fruit.equals("grapes");

        boolean workDay = day.equals("Monday") ||
                day.equals("Tuesday") ||
                day.equals("Wednesday") ||
                day.equals("Thursday") ||
                day.equals("Friday");

        boolean weekend = day.equals("Saturday") || day.equals("Sunday");

        double price = 0.0;

        if (fruitType && (workDay || weekend)) {
            if (fruit.equals("banana")) {
                if (workDay) {
                    price = 2.50 * quantity;
                } else {
                    price = 2.70 * quantity;
                }
            } else if (fruit.equals("apple")) {
                if (workDay) {
                    price = 1.20 * quantity;
                } else {
                    price = 1.25 * quantity;
                }
            } else if (fruit.equals("orange")) {
                if (workDay) {
                    price = 0.85 * quantity;
                } else {
                    price = 0.90 * quantity;
                }
            } else if (fruit.equals("grapefruit")) {
                if (workDay) {
                    price = 1.45 * quantity;
                } else {
                    price = 1.60 * quantity;
                }
            } else if (fruit.equals("kiwi")) {
                if (workDay) {
                    price = 2.70 * quantity;
                } else {
                    price = 3.00 * quantity;
                }
            } else if (fruit.equals("pineapple")) {
                if (workDay) {
                    price = 5.50 * quantity;
                } else {
                    price = 5.60 * quantity;
                }
            } else if (fruit.equals("grapes")) {
                if (workDay) {
                    price = 3.85 * quantity;
                } else {
                    price = 4.20 * quantity;
                }
            }
            System.out.printf("%.2f",price);
        } else {
            System.out.println("error");
        }
    }
}
