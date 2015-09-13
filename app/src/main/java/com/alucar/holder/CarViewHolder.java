package com.alucar.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alucar.R;

public class CarViewHolder extends RecyclerView.ViewHolder{

    private CardView cardView;
    private ImageView ivCar;
    private TextView tvModel,tvManufacturer,tvState;

    public CarViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_models);
        tvModel = (TextView) itemView.findViewById(R.id.tv_car_item_model);
        tvManufacturer = (TextView) itemView.findViewById(R.id.tv_car_item_manufacturer);
        tvState = (TextView) itemView.findViewById(R.id.tv_car_item_state);
        ivCar = (ImageView) itemView.findViewById(R.id.tv_car_item_image);
    }

    public ImageView getIvCar() {
        return ivCar;
    }

    public void setIvCar(ImageView ivCar) {
        this.ivCar = ivCar;
    }

    public TextView getTvModel() {
        return tvModel;
    }

    public void setTvModel(TextView tvModel) {
        this.tvModel = tvModel;
    }

    public TextView getTvManufacturer() {
        return tvManufacturer;
    }

    public void setTvManufacturer(TextView tvManufacturer) {
        this.tvManufacturer = tvManufacturer;
    }

    public TextView getTvState() {
        return tvState;
    }

    public void setTvState(TextView tvState) {
        this.tvState = tvState;
    }
}
