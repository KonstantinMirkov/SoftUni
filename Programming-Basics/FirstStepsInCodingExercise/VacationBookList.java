package FirstStepsInCodingExercise;

import java.util.Scanner;

public class VacationBookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Broinastranici = Integer.parseInt(scanner.nextLine());
        int StraniciZaChas = Integer.parseInt(scanner.nextLine());
        int VremeZaChetene = Integer.parseInt(scanner.nextLine());

        int izhod1 = Broinastranici / StraniciZaChas;
        int izhod2 = izhod1 / VremeZaChetene ;




        System.out.println(izhod2);
    }
}
