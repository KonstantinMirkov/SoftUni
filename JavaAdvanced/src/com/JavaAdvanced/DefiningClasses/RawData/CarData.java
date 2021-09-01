package com.JavaAdvanced.DefiningClasses.RawData;

import java.util.ArrayList;

public class CarData {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoW;
    private String cargoType;
    private ArrayList<Tyres> tyres;

    public CarData(String model, int engineSpeed, int enginePower, int cargoW, String cargoType, ArrayList<Tyres> tyres) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoW = cargoW;
        this.cargoType = cargoType;
        this.tyres=tyres;
    }

    public ArrayList<Tyres> getTyres() {
        return tyres;
    }

    public void setTyres(ArrayList<Tyres> tyres) {
        this.tyres = tyres;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getCargoW() {
        return cargoW;
    }

    public void setCargoW(int cargoW) {
        this.cargoW = cargoW;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}

