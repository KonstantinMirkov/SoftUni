package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int noshtuvki = Integer.parseInt(scanner.nextLine());
        double Apartment = 0.0;
        double Studio = 0.0;


        if (month.equals("May") || month.equals("October")) {
            Studio = 50;
            Apartment = 65;
            if (noshtuvki > 7 && noshtuvki <= 14) {
                Studio = 50 * 0.95;

            } else if (noshtuvki > 14) {
                Studio = 50 * 0.70;
                Apartment = 65 * 0.90;
            }

        }

        else if (month.equals("June") || month.equals("September")) {
            Studio = 75.20;
            Apartment = 68.70;
            if (noshtuvki > 14) {
                Studio = 75.20 * 0.80;
                Apartment = 68.70 * 0.90;
            }

        }
        else if (month.equals("July") || month.equals("August")) {
            Studio = 76;
            Apartment = 77;
            if (noshtuvki > 14) {
                Apartment = 77 * 0.90;
            }

        }

        System.out.printf("Apartment: %.2f lv. %n", Apartment * noshtuvki);
        System.out.printf("Studio: %.2f lv.", Studio * noshtuvki);
    }
}
