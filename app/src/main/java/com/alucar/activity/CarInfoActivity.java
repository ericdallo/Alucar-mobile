package com.alucar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alucar.R;
import com.alucar.adapter.CarsAdapter;
import com.alucar.car.Car;
import com.alucar.listener.RecyclerItemClickListener;

import java.util.ArrayList;

public class CarInfoActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ArrayList<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_info);
        cars = getIntent().getParcelableArrayListExtra("carsList");

        CarsAdapter carsAdapter = new CarsAdapter(this, cars);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(carsAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), this::showCarInfo));
    }

    private void showCarInfo(View view, int position) {

        Intent intentCarDetails = new Intent(this,CarDetailsActivity.class);

        intentCarDetails.putParcelableArrayListExtra("carsList", cars);
        intentCarDetails.putExtra("position", position);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<>(findViewById(R.id.tv_car_item_image), getString(R.string.transition_name_image))
        );
        ActivityCompat.startActivity(this, intentCarDetails, options.toBundle());
    }
}
