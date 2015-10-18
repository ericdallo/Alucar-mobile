package com.alucar.rest;

import com.alucar.car.Car;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CarJson{

    @SerializedName("list")
    private ArrayList<Car> cars;

    public ArrayList<Car> getCar() {
        return this.cars;
    }
}
