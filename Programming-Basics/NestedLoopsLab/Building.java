package NestedLoopsLab;

import java.util.Scanner;

public class Building {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int etaji = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int i = etaji; i >= 1; i--) {
            System.out.println();
            for (int j = 0; j < rooms; j++) {
                if (i == etaji) {
                    System.out.printf("L%d%d ", i, j);
                } else if (i % 2 == 0){
                    System.out.printf("O%d%d ", i, j);
                }else {
                    System.out.printf("A%d%d ", i, j);
                }
            }
        }
        System.out.println();
    }
}
