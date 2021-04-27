package com.JavaFundamentals.ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> playerOne = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> playerTwo = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (playerOne.size() > 0 && playerTwo.size() > 0) {
            int firstPlayerBestCard = playerOne.remove(0);
            int secondPlayerBestCard = playerTwo.remove(0);
            if (firstPlayerBestCard > secondPlayerBestCard) {
                playerOne.add(firstPlayerBestCard);
                playerOne.add(secondPlayerBestCard);
            } else if (firstPlayerBestCard < secondPlayerBestCard) {
                playerTwo.add(secondPlayerBestCard);
                playerTwo.add(firstPlayerBestCard);
            }

        }
        if (playerOne.size() > 0) {
            sumAndPrint(playerOne, "First");
        } else if (playerTwo.size() > 0) {
            sumAndPrint(playerTwo, "Second");
        }

    }

    private static void sumAndPrint(List<Integer> playerWinner, String player) {
        int sum = 0;
        for (int element : playerWinner)
            sum += element;
        System.out.println(player + " player wins! Sum: " + sum);
    }
}
