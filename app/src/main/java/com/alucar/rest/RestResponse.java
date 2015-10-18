package com.alucar.rest;

import android.os.Parcelable;

import java.util.ArrayList;

public interface RestResponse {

    void processFinish(ArrayList<? extends Parcelable> list);

    void showErrorMsg();
}
