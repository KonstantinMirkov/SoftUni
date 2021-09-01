package com.JavaAdvanced.DefiningClasses.CarInfo;

public class CarCar {
    public String brand;
    public String model;
    public int horsePower;

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
            horsePower = 0;
        }
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
