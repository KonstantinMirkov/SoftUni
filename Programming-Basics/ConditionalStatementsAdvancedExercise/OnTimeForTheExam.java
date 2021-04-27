package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourExam = Integer.parseInt(scanner.nextLine());
        int minExam = Integer.parseInt(scanner.nextLine());
        int hourArv = Integer.parseInt(scanner.nextLine());
        int minArv = Integer.parseInt(scanner.nextLine());
        String time;
        int minAllExam = (hourExam * 60) + minExam;
        int minAllArv = (hourArv * 60) + minArv;

        if (hourExam < hourArv) {
            time = "Late";
        } else if (hourExam == hourArv && minExam < minArv) {
            time = "Late";
        } else if ((minAllExam - minAllArv) <= 30) {
            time = "On time";
        } else {
            time = "Early";
        }
        System.out.println(time);

        if (minAllArv < minAllExam) {
            int minAllBefore = minAllExam - minAllArv;

            if (minAllBefore < 60) {
                System.out.printf("%d minutes before the start", minAllBefore);
            } else {
                if (minAllBefore % 60 < 10) {
                    System.out.printf("%d:0%d hours before the start", minAllBefore / 60, minAllBefore % 60);
                } else {
                    System.out.printf("%d:%d hours before the start", minAllBefore / 60, minAllBefore % 60);
                }
            }
        }
        if (minAllArv > minAllExam) {
            int minAllAfter = minAllArv - minAllExam;

            if (minAllAfter < 60) {
                System.out.printf("%d minutes after the start", minAllAfter);
            } else {
                if (minAllAfter % 60 < 10) {
                    System.out.printf("%d:0%d hours after the start", minAllAfter / 60, minAllAfter % 60);
                } else {
                    System.out.printf("%d:%d hours after the start", minAllAfter / 60, minAllAfter % 60);
                }
            }
        }
    }
}
