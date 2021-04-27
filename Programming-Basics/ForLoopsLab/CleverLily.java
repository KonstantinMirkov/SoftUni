package ForLoopsLab;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int years = Integer.parseInt(scanner.nextLine());
        double pricePeralnq = Double.parseDouble(scanner.nextLine());
        int priceToys = Integer.parseInt(scanner.nextLine());
        int toysCount = 0;
        double money = 10;
        double sum = 0.0;
        for(int i = 1 ; i <= years; i++ ){

            if (i % 2 == 0) {
                sum += money;
                sum -= 1;


                money +=10;
            }else {
                toysCount++;
            }

        }
        sum += priceToys * toysCount;

        if (pricePeralnq <= sum){
            System.out.printf("Yes! %.2f", sum - pricePeralnq);
        }else {
            System.out.printf("No! %.2f", pricePeralnq - sum);
        }

    }
}
