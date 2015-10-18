package com.alucar.rest;

import android.os.AsyncTask;
import android.util.Log;

import com.alucar.R;
import com.alucar.car.CarSpecification;
import com.alucar.util.AlucarConfig;

import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class CarRest extends AsyncTask<Void,Void,CarJson>{

    private RestAdapter restAdapter;
    private RestResponse delegate;
    private CarSpecification carSpecification;

    public CarRest(RestResponse delegate, CarSpecification carSpecification) {
        this.delegate = delegate;
        this.carSpecification = carSpecification;
    }

    @Override
    protected void onPreExecute() {
        this.restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(AlucarConfig.BASE_URL)
                .build();
    }

    @Override
    protected CarJson doInBackground(Void... params) {
        AlucarApi api = restAdapter.create(AlucarApi.class);
        CarJson json = new CarJson();
        try{
            json = api.getCar(carSpecification.getModel(), carSpecification.getManufacturer());
        }catch (RetrofitError error){
            Log.i(String.valueOf(R.string.error_label), String.valueOf(R.string.unknow_host));
            delegate.showErrorMsg();
        }
        return json;
    }

    @Override
    protected void onPostExecute(CarJson carJson) {
        if(carJson.getCar() != null){
            delegate.processFinish(carJson.getCar());
        }
    }
}
