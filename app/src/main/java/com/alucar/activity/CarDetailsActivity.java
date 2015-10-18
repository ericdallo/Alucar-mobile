package com.alucar.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alucar.R;
import com.alucar.car.Car;
import com.alucar.util.Util;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity{

    private SimpleDraweeView ivCar;
    private TextView tvModel,tvChassi,tvManufacturer,tvLicense,tvState,tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        List<Car> carsList = getIntent().getParcelableArrayListExtra("carsList");

        int position = getIntent().getIntExtra("position", -1);

        Car actualCar = carsList.get(position);

        tvModel = (TextView) findViewById(R.id.tv_info_model);
        tvModel.setText(actualCar.getModel());

        tvChassi= (TextView) findViewById(R.id.tv_info_chassi);
        tvChassi.setText(actualCar.getChassi());

        tvManufacturer = (TextView) findViewById(R.id.tv_info_manufacturer);
        tvManufacturer.setText(actualCar.getManufacturer());

        tvLicense = (TextView) findViewById(R.id.tv_info_license);
        tvLicense.setText(actualCar.getLicensePlate());

        tvState = (TextView) findViewById(R.id.tv_info_state);
        tvState.setText(actualCar.getState());

        tvCity = (TextView) findViewById(R.id.tv_info_city);
        tvCity.setText(actualCar.getCity());

        ivCar = (SimpleDraweeView) findViewById(R.id.iv_info_car);
        Uri uri = Uri.parse(actualCar.getImage());
        ivCar.setImageURI(uri);

    }
}
