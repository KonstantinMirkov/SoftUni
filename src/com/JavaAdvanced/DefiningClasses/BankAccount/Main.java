package com.JavaAdvanced.DefiningClasses.BankAccount;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accountsMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            String command = commands[0];
            String output = null;
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accountsMap.put(bankAccount.getId(), bankAccount);

                output = String.format("Account ID%d created", bankAccount.getId());

            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(commands[1]);
                int amount = Integer.parseInt(commands[2]);
                BankAccount bankAccount = accountsMap.get(id);
                output = executeIfAccountExist(bankAccount, b -> {
                    b.deposit(amount);
                    return String.format("Deposited %d to ID%d", amount, id);
                });

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(commands[1]);
                BankAccount.setInterestRate(interest);
            } else {
                int id = Integer.parseInt(commands[1]);
                int years = Integer.parseInt(commands[2]);
                BankAccount bankAccount = accountsMap.get(id);
                output = executeIfAccountExist(bankAccount, b -> {
                    double interest = b.getInterest(years);
                    return String.format("%.2f", interest);
                });
            }

            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }

    }

    public static String executeIfAccountExist(BankAccount account, Function<BankAccount, String> function) {
        if (account == null) {
            return "Account does not exist";
        }
        return function.apply(account);
    }
}
