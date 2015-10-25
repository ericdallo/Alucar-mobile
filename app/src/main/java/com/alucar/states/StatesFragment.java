package com.alucar.states;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alucar.R;
import com.alucar.car.CarListActivity;
import com.alucar.listener.RecyclerItemClickListener;
import com.alucar.car.CarRest;
import com.alucar.rest.RestResponse;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class StatesFragment extends Fragment implements RestResponse {

    private RecyclerView recyclerView;
    private List<StatesBr> states;
    private View view;
    private AlertDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dialog = new SpotsDialog(getContext());

        view = inflater.inflate(R.layout.states_fragment, container);
        states = StatesBr.getAllStates();

        StatesAdapter statesAdapter= new StatesAdapter(view.getContext(), states);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_states);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(statesAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(view.getContext(), this::findCarByState));
        return view;
    }

    private void findCarByState(View view, int position) {
        dialog.show();
        CarRest rest = new CarRest(this,states.get(position).toString());
        rest.execute();
    }

    @Override
    public void processFinish(ArrayList<? extends Parcelable> carsList) {
        dialog.dismiss();
        Intent intentCars = new Intent(getContext(), CarListActivity.class);

        intentCars.putParcelableArrayListExtra("carsList", carsList);

        startActivity(intentCars);
    }

    @Override
    public void showErrorMsg() {
        dialog.dismiss();
        Snackbar.make(view, R.string.unknow_host, Snackbar.LENGTH_SHORT).show();
    }
}
