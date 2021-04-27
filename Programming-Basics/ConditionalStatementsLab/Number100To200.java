package ConditionalStatementsLab;

import java.util.Scanner;

public class Number100To200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chislo = Integer.parseInt(scanner.nextLine());


        if (chislo <= 99) {
            System.out.println("Less than 100");
        }
        else if (chislo >= 201) {
            System.out.println("Greater than 200");

        } else if (chislo >= 100 && chislo <= 200) {
            System.out.println("Between 100 and 200");

        }
    }
}
