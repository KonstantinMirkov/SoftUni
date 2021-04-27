package NestedLoopsLab;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;
        while (!"Finish".equals(movie)) {
            int seatsFree = Integer.parseInt(scanner.nextLine());
            int currentMovie = 0;
            for (int i = 0; i < seatsFree; i++) {
                String ticketType = scanner.nextLine();
                if ("student".equals(ticketType)) {
                    studentTickets++;
                } else if ("standard".equals(ticketType)) {
                    standardTickets++;
                } else if ("kid".equals(ticketType)) {
                    kidTickets++;
                } else if ("End".equals(ticketType)) {
                    break;
                }
                currentMovie++;
            }
            double percentage = currentMovie * 1.0 / seatsFree * 100;

            System.out.printf("%s - %.2f%% full.%n", movie, percentage);
            movie = scanner.nextLine();
        }


        int totalTickets = studentTickets + standardTickets + kidTickets;
        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", studentTickets * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardTickets * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidTickets * 1.0 / totalTickets * 100);
    }
}
