package com.JavaAdvanced.DefiningClasses.Google;

import java.util.*;

public class Person {
    private Company company;
    private CarTypeAndInfo car;

    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemon;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(CarTypeAndInfo car) {
        this.car = car;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Company getCompany() {
        return company;
    }

    public CarTypeAndInfo getCar() {
        return car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("Company:").append("\n");
        if(company != null) {
            builder.append(company.toString()).append("\n");
        }

        builder.append("Car:").append("\n");
        if(car != null) {
            builder.append(car.toString()).append("\n");
        }


        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemon ) {
            builder.append(pokemon.toString()).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent.toString()).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Children child : children) {
            builder.append(child.toString()).append("\n");
        }

        return builder.toString();
    }
}