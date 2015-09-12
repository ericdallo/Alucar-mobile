package com.alucar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alucar.R;
import com.alucar.car.Car;
import com.alucar.util.HardcodedModels;

import java.util.List;

public class CarInfo extends AppCompatActivity{

    private TextView tvModel,tvChassi,tvManufacturer,tvLicense,tvState,tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);

        List<Car> modelsList = HardcodedModels.getCars();

        int position = getIntent().getIntExtra("position", -1);

        Car actualCar = modelsList.get(position);

        tvModel = (TextView) findViewById(R.id.tv_info_model);
        tvModel.setText(actualCar.getModel());

        tvChassi= (TextView) findViewById(R.id.tv_info_chassi);
        tvChassi.setText(actualCar.getChassi());

        tvManufacturer = (TextView) findViewById(R.id.tv_info_manufacturer);
        tvManufacturer.setText(actualCar.getManufacturer());

        tvLicense = (TextView) findViewById(R.id.tv_info_license);
        tvLicense.setText(actualCar.getLicense());

        tvState = (TextView) findViewById(R.id.tv_info_state);
        tvState.setText(actualCar.getState());

        tvCity = (TextView) findViewById(R.id.tv_info_city);
        tvCity.setText(actualCar.getCity());

    }
}
