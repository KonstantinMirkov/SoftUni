package NestedLoopsLab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] main){
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String destination = scanner.nextLine();
            if(destination.equals("End"))
            {
                break;
            }
            double budget = Double.parseDouble(scanner.nextLine());
            double sum = 0;
            while(budget > sum){
                double money = Double.parseDouble(scanner.nextLine());
                sum += money;
                money++;
            }
            System.out.printf("Going to %s!%n", destination);
        }
    }
}
