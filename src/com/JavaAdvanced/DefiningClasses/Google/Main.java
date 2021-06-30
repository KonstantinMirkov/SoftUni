package com.JavaAdvanced.DefiningClasses.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personData = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
             String[] parameters = input.split("\\s+");
            String name = parameters[0];
            if(!personData.containsKey(name)) {
                personData.put(name, new Person());
            }
            String enteredData = parameters[1];

            switch (enteredData) {
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName, department, salary);
                    personData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personData.get(name).getPokemon().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters[2];
                    String parentBirthday = parameters[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    personData.get(name).getParents().add(parent);
                    break;
                case "children":

                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Children child = new Children(childName, childBirthday);
                    personData.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);
                    CarTypeAndInfo car = new CarTypeAndInfo(carModel, carSpeed);
                    personData.get(name).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = personData.get(searchedPerson);
        System.out.println(personalData);

    }
}
