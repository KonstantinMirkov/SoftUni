package ForLoopExercise;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int browsers = Integer.parseInt(scanner.nextLine());
        int salary =  Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < browsers; i++) {
            String tab = scanner.nextLine();
            if (tab.equals("Facebook")) {
                salary -= 150;
            } else if (tab.equals("Instagram")) {
                salary -= 100;
            } else if (tab.equals("Reddit")) {
                salary -= 50;
            }
            if (salary <= 0) {
                break;
            }
        }
        if (salary <= 0){
            System.out.println("You have lost your salary.");
        }else {
            System.out.println(salary);
        }
    }
}
