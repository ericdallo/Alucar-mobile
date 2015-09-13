package com.alucar.util;

import com.alucar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class HardcodedModels {


    private static List<Car> carsList;

    public static List<Car> setup(String state){
        carsList = new ArrayList<>();
        int i = 0;
        switch (state){
            case "SP":
                carsList.add(new Car(i++,"Audi","A1 Sportback","12345","PDJF-4851","SP","Guarulhos","a1sportback"));
                carsList.add(new Car(i++,"Audi","A3 Cabriolet","23456","OGKR-8375","SP","São Paulo","a3cabriolet"));
                carsList.add(new Car(i++,"Chevrolet","Volt","56789","WMVP-2967","SP","Barueri","volt"));
                carsList.add(new Car(i++,"Citroën","C3 Piscasso","678910","LEPW-9501","SP","São Paulo","c3picasso"));
                carsList.add(new Car(i++,"Dodge","Viper","89101112","EITU-9824","SP","Santos","viper"));
                break;
            case "RJ":
                carsList.add(new Car(i++,"BMW","Z4 Roadster","34567","KTLP-5296","RJ","Niterói","z4roadster"));
                carsList.add(new Car(i++,"BMW","i8","45678","RIVB-1852","RJ","Angra dos Reis","i8"));
                carsList.add(new Car(i++,"Citroën","C1 5 Doors","7891011","QPTO-2946","RJ","Rio de Janeiro","c15doors"));
                carsList.add(new Car(i++,"Dodge","Challenger","910111213","YRUW-4925","RJ","Cabo Frio","challenger"));
                break;
            default:
                carsList.add(new Car(i++,"","","","","","","no_car"));
        }

        return carsList;
    }

    public static List<Car> getCars() {
        return carsList;
    }
}
