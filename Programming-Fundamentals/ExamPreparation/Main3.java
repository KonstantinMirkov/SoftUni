package com.JavaFundamentals.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> listOfPaintings = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = sc.nextLine();
        while (!input.equals("END")){
            String[] commands = input.split(" ");
            String command = commands[0];
            switch (command){
                case"Change":
                   int indexToChange = Integer.parseInt(commands[1]);
                   int replacingIndex = Integer.parseInt(commands[2]);
                    listOfPaintings.remove(indexToChange);
                    listOfPaintings.add(replacingIndex);
                    break;
                case"Switch":
                    Collections.swap(listOfPaintings, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case"Hide":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    listOfPaintings.remove(indexToRemove);
                    break;
                case"Insert":
                    int indexNum = Integer.parseInt(commands[1]);
                    int place = Integer.parseInt(commands[2]);
                    listOfPaintings.add(indexNum,place);
                    break;
                case"Reverse":
                    Collections.reverse(listOfPaintings);
                    break;
            }
            input = sc.nextLine();
        }
        System.out.print(Arrays.toString(new List[]{listOfPaintings}).replaceAll("[\\[\\]]", ""));
    }
}
