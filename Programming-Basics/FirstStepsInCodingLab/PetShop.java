package FirstStepsInCodingLab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int dogs = Integer.parseInt(scanner.nextLine());
        int othersAnimals = Integer.parseInt(scanner.nextLine());

        double total= dogs * 2.50 + othersAnimals * 4 ;

        System.out.println(total);
    }
}
