package com.alucar.car;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.alucar.R;
import com.alucar.car.Car;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity{

    private ImageView ivCar;
    private TextView tvModel,tvChassi,tvManufacturer,tvLicense,tvState,tvCity,tvKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        List<Car> carsList = getIntent().getParcelableArrayListExtra("carsList");

        int position = getIntent().getIntExtra("position", 0);

        Car actualCar = carsList.get(position);

        tvModel = (TextView) findViewById(R.id.tv_details_model);
        tvModel.setText(actualCar.getModel());

        tvChassi= (TextView) findViewById(R.id.tv_details_chassi);
        tvChassi.setText(actualCar.getChassi());

        tvManufacturer = (TextView) findViewById(R.id.tv_details_manufacturer);
        tvManufacturer.setText(actualCar.getManufacturer());

        tvLicense = (TextView) findViewById(R.id.tv_details_license);
        tvLicense.setText(actualCar.getLicensePlate());

        tvState = (TextView) findViewById(R.id.tv_details_state);
        tvState.setText(actualCar.getState());

        tvCity = (TextView) findViewById(R.id.tv_details_city);
        tvCity.setText(actualCar.getCity());

        tvKm = (TextView) findViewById(R.id.tv_details_km);
        tvKm.setText(actualCar.getKm()+"");

        ivCar = (ImageView) findViewById(R.id.iv_details_car);

        Picasso.with(this)
                .load(actualCar.getImage())
                .placeholder(R.drawable.no_car)
                .into(ivCar);

    }
}
