package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class DragonArmy {
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            defaultDragonInfo(scanner, dragons);
        }
        for (Map.Entry<String, TreeMap<String, int[]>> dragon : dragons.entrySet()) {
            double[] averageStats = calculateAverageStats(dragon.getValue());
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragon.getKey(), averageStats[0], averageStats[1], averageStats[2]);
            for (Map.Entry<String, int[]> dragonInfo : dragon.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragonInfo.getKey(),
                        dragonInfo.getValue()[0],
                        dragonInfo.getValue()[1],
                        dragonInfo.getValue()[2]);
            }
        }
    }

    private static void defaultDragonInfo(Scanner scanner, LinkedHashMap<String, TreeMap<String, int[]>> dragons) {
        String[] commands = scanner.nextLine().split("\\s+");
        String type = commands[0];
        String name = commands[1];
        int damage = commands[2].equals("null") ? DEFAULT_DAMAGE : Integer.parseInt(commands[2]);
        int health = commands[3].equals("null") ? DEFAULT_HEALTH : Integer.parseInt(commands[3]);
        int armor = commands[4].equals("null") ? DEFAULT_ARMOR : Integer.parseInt(commands[4]);

        if (!dragons.containsKey(type)) {
            dragons.put(type, new TreeMap<>());
        }
        if (!dragons.get(type).containsKey(name)) {
            dragons.get(type).put(name, new int[3]);
        }
        dragons.get(type).get(name)[0] = damage;
        dragons.get(type).get(name)[1] = health;
        dragons.get(type).get(name)[2] = armor;
    }

    private static double[] calculateAverageStats(TreeMap<String,int[]> dragonValue) {
        double totalEntries = dragonValue.size();
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmor = 0;

        for (Map.Entry<String, int[]> entry : dragonValue.entrySet()) {
            totalDamage += entry.getValue()[0];
            totalHealth += entry.getValue()[1];
            totalArmor += entry.getValue()[2];
        }

        return new double[] {
                totalDamage / totalEntries,
                totalHealth / totalEntries,
                totalArmor / totalEntries
        };
    }


}
