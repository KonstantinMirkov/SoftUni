package com.JavaFundamentals.FinalExamPrep;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> heroesHP = new TreeMap<>();
        Map<String, Integer> heroesMP = new TreeMap<>();

        heroesData(scanner, heroesHP, heroesMP);

        iteratingBeforeEndCommand(scanner, heroesHP, heroesMP);
        print(heroesHP, heroesMP);
    }

    private static void print(Map<String, Integer> heroesHP, Map<String, Integer> heroesMP) {
        heroesHP.entrySet().stream()//sorted in descending order
                .sorted((h1, h2) -> Integer.compare(h2.getValue(), h1.getValue()))
                .forEach(hero -> {
                    String heroName = hero.getKey();
                    System.out.println(heroName);
                    System.out.println("  HP: " + hero.getValue());
                    System.out.println("  MP: " + heroesMP.get(heroName));
                });
    }

    private static void iteratingBeforeEndCommand(Scanner scanner, Map<String, Integer> heroesHP, Map<String, Integer> heroesMP) {
        String commandsInput = scanner.nextLine();
        while (!commandsInput.equals("End")) {
            String[] commands = commandsInput.split(" - ");
            String command = commands[0];
            String heroName = commands[1];
            switch (command) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commands[2]);
                    String spellName = commands[3];
                    int currentMP = heroesMP.get(heroName);
                    if (currentMP >= mpNeeded) {
                        int mpLeft = currentMP - mpNeeded;
                        heroesMP.put(heroName, mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damageDealt = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    int currentHP = heroesHP.get(heroName);
                    if (currentHP > damageDealt) {
                        int hpLeft = currentHP - damageDealt;
                        heroesHP.put(heroName, hpLeft);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damageDealt, attacker, hpLeft);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroesHP.remove(heroName);
                        heroesMP.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amountIncreaseMp = Integer.parseInt(commands[2]);
                    int currentMp = heroesMP.get(heroName);
                    int increasedMp = currentMp + amountIncreaseMp;
                    if (increasedMp > 200) {
                        increasedMp = 200;
                    }
                    heroesMP.put(heroName, increasedMp);
                    System.out.printf("%s recharged for %d MP!%n", heroName, increasedMp - currentMp);
                    break;
                case "Heal":
                    int amountIncreaseHp = Integer.parseInt(commands[2]);
                    int currentHp = heroesHP.get(heroName);
                    int increasedHp = currentHp + amountIncreaseHp;
                    if (increasedHp > 100) {
                        increasedHp = 100;
                    }
                    heroesHP.put(heroName, increasedHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, increasedHp - currentHp);
                    break;
            }
            commandsInput = scanner.nextLine();
        }
    }

    private static void heroesData(Scanner scanner, Map<String, Integer> heroesHP, Map<String, Integer> heroesMP) {
        int countHeroes = Integer.parseInt(scanner.nextLine());
        for (int hero = 1; hero <= countHeroes; hero++) {
            String input = scanner.nextLine();
            String[] heroBeginData = input.split("\\s+");
            String heroName = heroBeginData[0];
            int beginHP = Integer.parseInt(heroBeginData[1]);
            int beginMP = Integer.parseInt(heroBeginData[2]);

            if (beginHP <= 100) {
                heroesHP.put(heroName, beginHP);
            }
            if (beginMP <= 200) {
                heroesMP.put(heroName, beginMP);
            }
        }
    }
}

