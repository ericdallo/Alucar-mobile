package com.alucar.rest;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface AlucarApi {

    @GET("/automoveis/json/{state}")
    CarSpecificationJson getCarSpecification(
            @Path("state") String state
    );

    @GET("/automoveis/json/detalhes")
    CarJson getCar(
            @Query("spec.model") String model,
            @Query("spec.manufacturer") String manufacturer
    );
}
