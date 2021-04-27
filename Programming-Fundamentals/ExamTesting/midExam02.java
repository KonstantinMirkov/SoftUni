package com.JavaFundamentals.ExamTesting;

import java.util.*;
import java.util.stream.Collectors;

public class midExam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            if ("add to start".equals(command)) {
                int integersToAdd = Integer.parseInt(commands[1]);
                for (int i = 0; i < integersToAdd; i++) {
                    integerList.add(0, integersToAdd);
                }
            }
            if ("add to end".equals(command)) {
                int integersToAddAtEnd = Integer.parseInt(commands[1]);
                for (int i = 0; i < integersToAddAtEnd; i++) {
                    integerList.add(integerList.size(), integersToAddAtEnd);
                }
            }
            if ("remove lower than".equals(command)) {
                int removeLowerIndex = Integer.parseInt(commands[1]);
                for (int i = 0; i < integerList.size(); i++) {
                    if (integerList.get(i) < removeLowerIndex) {
                        integerList.remove(i);
                        i--;
                    }
                }
            }
            if ("remove greater than".equals(command)) {
                int removeGreaterIndex = Integer.parseInt(commands[1]);
                for (int i = 0; i < integerList.size(); i++) {
                    if (integerList.get(i) > removeGreaterIndex) {
                        integerList.remove(i);
                        i--;
                    }
                }
            }
            if ("replace".equals(command)) {
                int valueToReplace = Integer.parseInt(commands[1]);
                int replacementValue = Integer.parseInt(commands[2]);
                for (int i = 0; i < integerList.size(); i++) {
                    if (integerList.get(i).equals(valueToReplace)) {
                        integerList.remove(valueToReplace);
                        integerList.add(valueToReplace, replacementValue);
                    }
                }
            }
             if ("remove at index".equals(command)) {
                int indexToRemove = Integer.parseInt(commands[1]);
                if (indexToRemove <= integerList.size()) {
                    integerList.remove(indexToRemove);
                } else {
                    break;
                }
            }
             if ("remove count".equals(command)) {
                LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(integerList);
                integerList = new ArrayList<>(hashSet);
            }
             if ("find even".equals(command)) {
                for (int i = 0; i < integerList.size(); i++) {
                    if (integerList.get(i) % 2 == 0) {
                        System.out.print(integerList.get(i) + ", ");
                    }
                }
            }
             if ("find odd".equals(command)) {
                for (int i = 0; i < integerList.size(); i++) {
                    if (integerList.get(i) % 2 != 0) {
                        System.out.print(integerList.get(i) + ", ");
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.print(Arrays.toString(new List[]{integerList}).replaceAll("[\\[\\]]", ""));
    }
}
