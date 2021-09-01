package com.JavaAdvanced.DefiningClasses.Constructors;

public class CarInfo {
    public String brand;
    public String model;
    public int horsePower;

    public CarInfo(String brand) {
        this(brand, "unknown", -1);
    }

    public CarInfo(String brand, String model) {
        this(brand, model, -1);
    }

    public CarInfo(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }

    public CarInfo(String brand, String model, int horsePower) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setHorsePower(int horsePower) {
        if (horsePower < 0) {
            horsePower = -1;
        }
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
