package com.alucar.rest;

import com.alucar.car.CarJson;

import retrofit.http.GET;
import retrofit.http.Path;

public interface AlucarApi {

    @GET("/automoveis/json/{state}")
    CarJson getCar(
            @Path("state") String state
    );
}
