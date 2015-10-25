package com.alucar.states;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alucar.R;

public class StatesViewHolder extends RecyclerView.ViewHolder{

    private final TextView tvState;
    private final ImageView ivState;

    public StatesViewHolder(View itemView) {
        super(itemView);
        tvState = (TextView) itemView.findViewById(R.id.tv_state);
        ivState = (ImageView) itemView.findViewById(R.id.iv_state_flag);
    }

    public TextView getTvState() {
        return tvState;
    }

    public ImageView getIvState() {
        return ivState;
    }
}
