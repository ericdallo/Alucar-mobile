package com.alucar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alucar.R;
import com.alucar.adapter.CarSpecificationAdapter;
import com.alucar.car.CarSpecification;
import com.alucar.listener.RecyclerItemClickListener;
import com.alucar.rest.CarRest;
import com.alucar.rest.RestResponse;

import java.util.ArrayList;

public class CarSpecsActivity extends AppCompatActivity implements RestResponse {

    private RecyclerView recyclerView;
    private ArrayList<CarSpecification> specs;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_specification);
        view = findViewById(R.id.layout_car_specification);
        specs = getIntent().getParcelableArrayListExtra("list");

        CarSpecificationAdapter specAdapter= new CarSpecificationAdapter(this, specs);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvSpecification);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(specAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), this::showCarInfo));

    }

    public void showCarInfo(View v, int position) {
        CarRest rest = new CarRest(this,specs.get(position));
        rest.execute();
    }

    @Override
    public void processFinish(ArrayList<? extends Parcelable> carsList) {

        Intent intentCarInfo = new Intent(this,CarInfoActivity.class);

        intentCarInfo.putParcelableArrayListExtra("carsList",carsList);

        startActivity(intentCarInfo);

        /*ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<>(v.findViewById(R.id.tv_car_item_image),getString(R.string.transition_name_image))
        );
        ActivityCompat.startActivity(this, intentCarInfo, options.toBundle());*/
    }

    @Override
    public void showErrorMsg() {
        Snackbar.make(view, R.string.unknow_host, Snackbar.LENGTH_SHORT).show();
    }
}
