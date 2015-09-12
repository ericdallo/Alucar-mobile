package com.alucar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.alucar.R;
import com.alucar.adapter.ModelsAdapter;
import com.alucar.car.Car;
import com.alucar.listener.RecyclerItemClickListener;
import com.alucar.util.HardcodedModels;

import java.util.ArrayList;
import java.util.List;

public class CarModelsActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private List<Car> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_models);

        models = HardcodedModels.setup();

        ModelsAdapter modelsAdapter = new ModelsAdapter(this, models);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(modelsAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, (v, position) ->
            showCarInfo(position)
        ));

    }

    public void showCarInfo(int position) {
        Intent intentCarInfo = new Intent(this,CarInfo.class);
        intentCarInfo.putExtra("position",position);
        startActivity(intentCarInfo);
    }

}
