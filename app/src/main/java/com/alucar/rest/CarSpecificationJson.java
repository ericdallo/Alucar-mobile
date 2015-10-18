package com.alucar.rest;

import com.alucar.car.CarSpecification;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CarSpecificationJson {

    @SerializedName("list")
    private ArrayList<CarSpecification> carSpecificationList;

    public ArrayList<CarSpecification> getCarSpec() {
        return this.carSpecificationList;
    }
}
