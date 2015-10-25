package com.alucar.devolution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.alucar.R;
import com.github.clans.fab.FloatingActionButton;

public class DevolutionFragment  extends Fragment{

    private View view;
    private EditText etSearch;
    private FloatingActionButton btSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.devolution_fragment,container);

        etSearch = (EditText) view.findViewById(R.id.et_client_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(etSearch.getText().toString().isEmpty()){
                    btSearch.hide(true);
                }else {
                    btSearch.show(true);
                }
            }
        });

        btSearch = (FloatingActionButton) view.findViewById(R.id.bt_client_search);
        btSearch.hide(false);
        btSearch.setOnClickListener(v ->{
            if(etSearch.getText().toString().isEmpty()){
                Snackbar.make(view, R.string.empty_search, Snackbar.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
