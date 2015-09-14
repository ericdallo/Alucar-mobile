package com.alucar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.alucar.R;
import com.alucar.activity.CarModelsActivity;

public class AlucarFragment extends Fragment{

    private Spinner spinnerLocal;
    private FloatingActionButton buttonOk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag,container);
        spinnerLocal = createSpinner(view,R.id.spinner_local,R.array.states);

        buttonOk = (FloatingActionButton) view.findViewById(R.id.bt_ok);
        buttonOk.setOnClickListener(v -> {
            if (!spinnerLocal.getSelectedItem().toString().contains("Escolha")) {
                showCarModels();
                return;
            }
            Snackbar.make(view,R.string.choose_state,Snackbar.LENGTH_SHORT).show();
        });

        return view;
    }

    private Spinner createSpinner(View view, int spinnerId, int cubeList) {
        Spinner spinner = (Spinner) view.findViewById(spinnerId);
        ArrayAdapter<CharSequence> items = ArrayAdapter.createFromResource(view.getContext(),cubeList,R.layout.spinner_item);
        items.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(items);
        return spinner;
    }

    private void showCarModels() {
        Intent intentModel = new Intent(getContext(),CarModelsActivity.class);
        intentModel.putExtra("state",spinnerLocal.getSelectedItem().toString());
        startActivity(intentModel);
    }
}
