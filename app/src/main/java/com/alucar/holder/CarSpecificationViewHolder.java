package com.alucar.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alucar.R;

public class CarSpecificationViewHolder extends RecyclerView.ViewHolder{

    private final TextView tvModel;
    private final TextView tvManufacturer;

    public CarSpecificationViewHolder(View itemView) {
        super(itemView);
        tvModel = (TextView) itemView.findViewById(R.id.tv_model);
        tvManufacturer= (TextView) itemView.findViewById(R.id.tv_manufacturer);
    }

    public TextView getTvModel() {
        return tvModel;
    }

    public TextView getTvManufacturer() {
        return tvManufacturer;
    }
}
