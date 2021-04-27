package FirstStepsInCodingExercise;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NaemNaZalata = Integer.parseInt(scanner.nextLine());
        int Torta = NaemNaZalata * (20) /100;
        double Napitki = Torta - Torta * 0.45 ;
        double Animator = NaemNaZalata / 3;

        double NeobhodimaSuma = NaemNaZalata + Torta + Napitki + Animator ;

        System.out.println(NeobhodimaSuma);
    }
}
