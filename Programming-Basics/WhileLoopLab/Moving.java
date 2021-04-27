package WhileLoopLab;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int volume = length * width * height;

        while (volume > 0) {
            String input = scanner.nextLine();
            if (input.equals("Done")) {
                break;
            }
            int boxes = Integer.parseInt(input);
            volume -= boxes;
        }
        if (volume >= 0) {
            System.out.printf("%d Cubic meters left.", volume);
        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(volume));
        }
    }
}
