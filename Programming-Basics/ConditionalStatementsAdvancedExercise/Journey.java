package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String seasonsVariable = scanner.nextLine();
        double expenses = 0.0;
        String destination = "";
        String mqsto = "";
        if (budget <= 100) {
            destination = "Bulgaria";
            if (seasonsVariable.equals("summer")) {
                expenses = budget * 0.30;
                mqsto = "Camp";
            }
            else if (seasonsVariable.equals("winter")){
                expenses =  budget * 0.70;
                mqsto = "Hotel";
            }
        }
        else if (budget <= 1000) {
            destination = "Balkans";
            if (seasonsVariable.equals("summer")) {
                expenses =  budget * 0.40;
                mqsto = "Camp";
            }
            else if (seasonsVariable.equals("winter")){
                expenses =  budget * 0.80;
                mqsto = "Hotel";
            }
        }else  {
            destination = "Europe";

            expenses =  budget * 0.90;
            mqsto = "Hotel";
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", mqsto , expenses);
    }
}
