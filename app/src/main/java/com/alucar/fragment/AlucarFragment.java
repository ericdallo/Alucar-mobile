package com.alucar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alucar.R;
import com.alucar.activity.CarModelsActivity;
import com.alucar.adapter.ModelsAdapter;
import com.alucar.adapter.StatesAdapter;
import com.alucar.listener.RecyclerItemClickListener;
import com.alucar.states.StatesBr;
import com.alucar.util.HardcodedModels;

import java.util.List;

public class AlucarFragment extends Fragment{

    private RecyclerView recyclerView;
    private List<StatesBr> states;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_frag, container);

        states = StatesBr.getAllStates();

        StatesAdapter statesAdapter= new StatesAdapter(view.getContext(), states);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_states);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(statesAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(view.getContext(), this::showCarModels ));
        return view;
    }

    private void showCarModels(View view, int position) {
        Intent intentModel = new Intent(getContext(),CarModelsActivity.class);

        intentModel.putExtra("state", states.get(position).toString());
        startActivity(intentModel);
    }
}
