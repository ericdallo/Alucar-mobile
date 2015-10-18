package com.alucar.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alucar.R;
import com.alucar.car.Car;
import com.alucar.holder.CarViewHolder;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private final List<Car> modelsList;
    private Context context;

    public CarsAdapter(Context context, List<Car> modelsList) {
        this.context = context;
        this.modelsList = modelsList;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.car_list_item, viewGroup, false);

        return new CarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CarViewHolder carViewHolder, int i) {
        Car actualCar = modelsList.get(i);

        carViewHolder.getTvModel().setText(actualCar.getModel());
        carViewHolder.getTvManufacturer().setText(actualCar.getManufacturer());
        carViewHolder.getTvState().setText(actualCar.getState());

        Uri uri = Uri.parse(actualCar.getImage());
        carViewHolder.getIvCar().setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return this.modelsList.size();
    }

}
