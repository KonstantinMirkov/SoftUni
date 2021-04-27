package ConditionalStatementsLab;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double excPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int lorries = Integer.parseInt(scanner.nextLine());


        double allToysPrice = (puzzles * 2.6) + (dolls * 3.0) + (teddyBears * 4.10) + (minions * 8.2) + (lorries * 2.0);

        int allToys = puzzles + dolls + teddyBears + minions + lorries;

        double rent = allToysPrice * 0.1;

        double finalSum = allToysPrice - rent;

        if (allToys >= 50) {
            finalSum = finalSum * 0.75;
        }



        if (finalSum >= excPrice) {
            double diff = finalSum - excPrice;

            System.out.printf("Yes! %.2f lv left.", diff);

        }else if ( excPrice > finalSum){

            double diff = excPrice - finalSum;
            System.out.printf("Not enough money! %.2f lv needed.", diff);
        }
    }
}
