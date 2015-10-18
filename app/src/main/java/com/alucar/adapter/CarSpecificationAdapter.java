package com.alucar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alucar.R;
import com.alucar.car.CarSpecification;
import com.alucar.holder.CarSpecificationViewHolder;

import java.util.List;

public class CarSpecificationAdapter extends RecyclerView.Adapter<CarSpecificationViewHolder>{

    private Context context;
    private List<CarSpecification> carSpecifications;

    public CarSpecificationAdapter(Context context, List<CarSpecification> carSpecifications) {
        this.context = context;
        this.carSpecifications = carSpecifications;
    }

    @Override
    public CarSpecificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.car_specification_list_item, parent, false);

        return new CarSpecificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarSpecificationViewHolder holder, int position) {
        CarSpecification spec = carSpecifications.get(position);

        holder.getTvModel().setText(spec.getModel());
        holder.getTvManufacturer().setText(spec.getManufacturer());
    }

    @Override
    public int getItemCount() {
        return this.carSpecifications.size();
    }
}
