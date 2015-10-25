package com.alucar.init;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alucar.R;

public class WelcomeFragment extends Fragment {


    private View view;
    private TextView tvWelcome;
    private TextView tvSubWelcome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.welcome_fragment, container);

        tvWelcome = (TextView) view.findViewById(R.id.tv_welcome);
        tvSubWelcome= (TextView) view.findViewById(R.id.tv_sub_welcome);

        return view;
    }
}
