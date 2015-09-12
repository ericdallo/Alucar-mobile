package com.alucar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.alucar.R;
import com.alucar.activity.CarModelsActivity;

public class AlucarFragment extends Fragment{


    private Spinner spinnerLocal;
    private Button buttonOk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag,container);

        spinnerLocal = createSpinner(view,R.id.spinner_local,R.array.states);

        buttonOk = (Button) view.findViewById(R.id.bt_ok);
        buttonOk.setOnClickListener(v -> showCarModels());

        return view;
    }

    private Spinner createSpinner(View view, int spinnerId, int cubeList) {
        Spinner spinner = (Spinner) view.findViewById(spinnerId);
        ArrayAdapter<CharSequence> items = ArrayAdapter.createFromResource(view.getContext(),cubeList,android.R.layout.simple_spinner_item);
        items.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(items);
        return spinner;
    }

    private void showCarModels() {
        Intent intentModel = new Intent(getContext(),CarModelsActivity.class);
        startActivity(intentModel);
    }
}
