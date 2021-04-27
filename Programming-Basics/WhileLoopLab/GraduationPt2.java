package WhileLoopLab;

import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        int badGrades = 0;
        int clazz = 1;
        double grades = 0.0;
        while (clazz <= 12){
            double grade = Double.parseDouble(scanner.nextLine()) ;
            if (grade < 4){
                badGrades++ ;
                if (badGrades == 2){
                    break;
                }
                continue;
            }
            grades += grade;
            clazz++ ;

        }
        if (clazz >= 12 ){
            System.out.printf("%s graduated. Average grade: %.2f", studentName , grades / 12 );
        }else {
            System.out.printf("%s has been excluded at %d grade", studentName , clazz);
        }

    }
}
