package com.alucar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alucar.R;
import com.alucar.holder.StatesViewHolder;
import com.alucar.states.StatesBr;

import java.util.List;

public class StatesAdapter extends RecyclerView.Adapter<StatesViewHolder>{

    private Context context;
    private List<StatesBr> statesBrs;

    public StatesAdapter(Context context, List<StatesBr> statesBrs) {
        this.context = context;
        this.statesBrs = statesBrs;
    }

    @Override
    public StatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.state_list_item, parent, false);

        return new StatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatesViewHolder holder, int position) {
        StatesBr state = statesBrs.get(position);

        holder.getTvState().setText(state.toString());
    }

    @Override
    public int getItemCount() {
        return statesBrs.size();
    }
}
