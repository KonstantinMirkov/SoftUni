package FirstStepsInCodingLab;

import java.util.Scanner;

public class InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in) ;

        double Inches = Double.parseDouble(scanner.nextLine()) ;
        double centimeters = Inches * 2.54 ;
        System.out.println(centimeters) ;
    }
}
