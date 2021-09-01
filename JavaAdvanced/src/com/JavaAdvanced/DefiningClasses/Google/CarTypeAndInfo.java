package com.JavaAdvanced.DefiningClasses.Google;

public class CarTypeAndInfo {
    private String carModel;
    private int carSpeed;

    public CarTypeAndInfo(String carModel , int carSpeed){
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
