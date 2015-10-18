package com.alucar.fragment;

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
import com.alucar.activity.CarSpecsActivity;
import com.alucar.adapter.StatesAdapter;
import com.alucar.car.CarSpecification;
import com.alucar.listener.RecyclerItemClickListener;
import com.alucar.rest.CarSpecificationRest;
import com.alucar.rest.RestResponse;
import com.alucar.states.StatesBr;

import java.util.ArrayList;
import java.util.List;

public class AlucarFragment extends Fragment implements RestResponse {

    private RecyclerView recyclerView;
    private List<StatesBr> states;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_frag, container);
        states = StatesBr.getAllStates();

        StatesAdapter statesAdapter= new StatesAdapter(view.getContext(), states);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_states);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(statesAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(view.getContext(), this::findCarSpecificationByState));
        return view;
    }

    private void findCarSpecificationByState(View view, int position) {
        CarSpecificationRest rest = new CarSpecificationRest(this,states.get(position).toString());
        rest.execute();
    }

    @Override
    public void processFinish(ArrayList<? extends Parcelable> carSpecificationList) {
        Intent intentSpec = new Intent(getContext(),CarSpecsActivity.class);

        intentSpec.putParcelableArrayListExtra("list", carSpecificationList);
        startActivity(intentSpec);
    }

    @Override
    public void showErrorMsg() {
        Snackbar.make(view, R.string.unknow_host, Snackbar.LENGTH_SHORT).show();
    }
}
