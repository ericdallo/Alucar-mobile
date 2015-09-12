package com.alucar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alucar.R;
import com.alucar.car.Car;
import com.alucar.holder.CarViewHolder;

import java.util.List;

public class ModelsAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private final List<Car> modelsList;
    private Context context;

    public ModelsAdapter(Context context,List<Car> modelsList) {
        this.context = context;
        this.modelsList = modelsList;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.model_list_item, viewGroup, false);
        CarViewHolder carViewHolder = new CarViewHolder(view);

        return carViewHolder;

    }

    @Override
    public void onBindViewHolder(CarViewHolder carViewHolder, int i) {
        Car actualCar = modelsList.get(i);

        carViewHolder.getTvModel().setText(actualCar.getModel());
        carViewHolder.getTvManufacturer().setText(actualCar.getManufacturer());
        carViewHolder.getTvState().setText(actualCar.getState());
        carViewHolder.getIvCar().setImageResource( getDrawable(context, actualCar.getImage()) );
    }

    @Override
    public int getItemCount() {
        return this.modelsList.size();
    }

    public static int getDrawable(Context context, String image){
        return context.getResources().getIdentifier("drawable/" + image, null, context.getPackageName());
    }

}
