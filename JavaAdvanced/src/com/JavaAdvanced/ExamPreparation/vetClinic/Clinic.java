package com.JavaAdvanced.ExamPreparation.vetClinic;

import java.util.*;

public class Clinic {
    private int capacity;
    private List<Pet1> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet1 pet) {
        this.data.add(pet);
    }

    public boolean remove(String name) {
        for (Pet1 pet : data) {
            if (pet.getName().equals(name)) {
                return data.remove(pet);
            }
        }
        return false;
    }

    public Pet1 getPet(String name, String owner) {
        if (!data.isEmpty()) {
            for (Pet1 pet : data) {
                if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                    return pet;
                }
            }
        }
        return null;
    }

    public Pet1 getOldestPet() {
        int maxAge = Integer.MIN_VALUE;
        for (Pet1 pet : data) {
            if (pet.getAge() > maxAge) {
                maxAge = pet.getAge();
            }
        }
        for (Pet1 pet : data) {
            if (pet.getAge() == maxAge) {
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

   public String getStatistics(){
        StringBuilder printBuilder = new StringBuilder();
        printBuilder.append("The clinic has the following patients:").append(System.lineSeparator());
       for (Pet1 pet : data) {
           printBuilder.append(String.format("%s %s",pet.getName(),pet.getOwner())).append(System.lineSeparator());;
       }
       return printBuilder.toString().trim();
   }
}
