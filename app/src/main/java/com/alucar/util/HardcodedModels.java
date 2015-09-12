package com.alucar.util;

import com.alucar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class HardcodedModels {


    private static List<Car> carsList;

    public static List<Car> setup(){
        carsList = new ArrayList<>();

        int i = 0;
        carsList.add(new Car(i++,"Audi","A1 Sportback","12345","PDJF-4851","SP","Guarulhos","a1sportback"));
        carsList.add(new Car(i++,"Audi","A3 Cabriolet","23456","OGKR-8375","SP","Guarulhos","a3cabriolet"));
        carsList.add(new Car(i++,"BMW","Z4 Roadster","34567","KTLP-5296","SP","Guarulhos","z4roadster"));
        carsList.add(new Car(i++,"BMW","i8","45678","RIVB-1852","SP","Guarulhos","i8"));
        carsList.add(new Car(i++,"Chevrolet","Volt","56789","WMVP-2967","SP","Guarulhos","volt"));
        carsList.add(new Car(i++,"Citroën","C3 Piscasso","678910","LEPW-9501","SP","Guarulhos","c3picasso"));
        carsList.add(new Car(i++,"Citroën","C1 5 Doors","7891011","QPTO-2946","SP","Guarulhos","c15doors"));
        carsList.add(new Car(i++,"Dodge","Viper","89101112","EITU-9824","SP","Guarulhos","viper"));
        carsList.add(new Car(i++,"Dodge","Challenger","910111213","YRUW-4925","SP","Guarulhos","challenger"));

        return carsList;
    }

    public static List<Car> getCars() {
        return carsList;
    }
}
