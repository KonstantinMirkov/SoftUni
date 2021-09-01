package com.JavaAdvanced.DefiningClasses.CarSalesman;

public class CarInformation {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public String getColor() {
        return this.color;
    }

    public String getWeight() {
        return this.weight;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }

    public CarInformation(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }


    @Override
    public String toString() {
        return this.model + ":" +"\n"+ String.format("%s" +
                "  Weight: %s%n" +
                "  Color: %s",this.engine,this.weight,this.color);
    }
}
