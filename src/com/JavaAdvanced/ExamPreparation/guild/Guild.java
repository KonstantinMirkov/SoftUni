package com.JavaAdvanced.ExamPreparation.guild;

import java.util.*;
import java.util.stream.Collectors;

public class Guild {
    List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player != null) {
            roster.remove(player);
            return true;
        }
        return false;
    }

    //    public void promotePlayer(String name) {
    //        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    //        if (player != null) {
    //            player.setRank("Member");
    //        }
    //    }
    public void promotePlayer(String name) {
        roster.stream().filter(p -> p.getName().equals(name))
                .findFirst()
                .ifPresent(player -> player.setRank("Member"));
    }

    public void demotePlayer(String name) {
        roster.stream().filter(p -> p.getName().equals(name))
                .findFirst()
                .ifPresent(player -> player.setRank("Trial"));
    }

    public int count() {
        return this.roster.size();
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> players = roster.stream().filter(p -> p.getClazz().equals(clazz)).collect(Collectors.toList());
        roster.removeAll(players);
        return players.toArray(Player[]::new);
    }

    public String report() {
        return String.format("Players in the guild: %s:%n%s", name,
                roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        ).trim();
    }
}
