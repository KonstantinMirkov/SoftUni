package com.JavaFundamentals.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> averageNumbers = input.stream().filter(e -> e > input.stream()
                .mapToDouble(Integer::doubleValue).average().orElse(0.0))
                .sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());
        if (averageNumbers.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.print(Arrays.toString(new List[]{averageNumbers})
                    .replaceAll("[\\[\\]]", "").replaceAll(", ", " "));
        }
    }
}

