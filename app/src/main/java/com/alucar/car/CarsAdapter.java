package com.alucar.car;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alucar.R;
import com.alucar.car.Car;
import com.alucar.car.CarViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private final List<Car> carList;
    private Context context;

    public CarsAdapter(Context context, List<Car> modelsList) {
        this.context = context;
        this.carList = modelsList;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.car_list_item, viewGroup, false);

        return new CarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CarViewHolder carViewHolder, int i) {
        Car actualCar = carList.get(i);

        carViewHolder.getTvModel().setText(actualCar.getModel());
        carViewHolder.getTvManufacturer().setText(actualCar.getManufacturer());
        carViewHolder.getTvState().setText(actualCar.getState());

        Picasso.with(context)
                .load(actualCar.getImage())
                .placeholder(R.drawable.no_car)
                .into(carViewHolder.getIvCar());
    }

    @Override
    public int getItemCount() {
        return this.carList.size();
    }

}
