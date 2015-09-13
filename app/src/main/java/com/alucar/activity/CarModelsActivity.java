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
import com.alucar.adapter.ModelsAdapter;
import com.alucar.car.Car;
import com.alucar.listener.RecyclerItemClickListener;
import com.alucar.util.HardcodedModels;

import java.util.List;

public class CarModelsActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private List<Car> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_models);
        String state = getIntent().getStringExtra("state");

        models = HardcodedModels.setup(state);

        ModelsAdapter modelsAdapter = new ModelsAdapter(this, models);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(modelsAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, (v, position) ->
            showCarInfo(v,position)
        ));

    }

    public void showCarInfo(View v, int position) {
        Intent intentCarInfo = new Intent(this,CarInfo.class);
        intentCarInfo.putExtra("position", position);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<>(v.findViewById(R.id.tv_car_item_image),getString(R.string.transition_name_image))    

        );
        ActivityCompat.startActivity(this, intentCarInfo, options.toBundle());
    }

}
