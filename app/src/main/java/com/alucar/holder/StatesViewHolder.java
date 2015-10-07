package com.alucar.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alucar.R;

public class StatesViewHolder extends RecyclerView.ViewHolder{

    private final TextView tvState;

    public StatesViewHolder(View itemView) {
        super(itemView);
        tvState = (TextView) itemView.findViewById(R.id.tv_state);
    }

    public TextView getTvState() {
        return tvState;
    }
}
