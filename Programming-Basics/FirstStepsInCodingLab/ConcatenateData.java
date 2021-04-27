package FirstStepsInCodingLab;

import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstname = scan.nextLine();
        String lastname = scan.nextLine();
        int age = scan.nextInt();
        scan.nextLine();
        String town = scan.nextLine();

        System.out.println("You are " + firstname + " " + lastname + ", a " + age + "-years old person from " + town + ".");
    }
}
