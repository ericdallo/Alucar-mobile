package com.alucar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alucar.R;

import java.util.ArrayList;
import java.util.List;

public class CarModelsActivity extends AppCompatActivity{

    private ListView listModels;
    private List<String> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_models);

        setupHardcoded();

        listModels = (ListView) findViewById(R.id.list_models);
        listModels.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,models));

    }

    private void setupHardcoded() {
        models = new ArrayList<>();
        models.add("Modelo 1");
        models.add("Modelo 2");
        models.add("Modelo Teste");
    }
}
