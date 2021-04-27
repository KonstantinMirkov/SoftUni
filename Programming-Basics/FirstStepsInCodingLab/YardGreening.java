package FirstStepsInCodingLab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = Double.parseDouble(scanner.nextLine());
        double finalPrice = price * 7.61;
        double CountDiscount = 0.18 * finalPrice;
        double discount = finalPrice - CountDiscount;
        System.out.printf("The final price is: %.2f lv.%n", discount);
        System.out.printf("The discount is: %.2f lv.", CountDiscount);
    }
}
