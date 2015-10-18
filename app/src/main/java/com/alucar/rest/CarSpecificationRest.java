package com.alucar.rest;

import android.os.AsyncTask;
import android.util.Log;

import com.alucar.R;
import com.alucar.util.AlucarConfig;

import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class CarSpecificationRest extends AsyncTask<Void, Void, CarSpecificationJson> {

    private RestAdapter restAdapter;
    private RestResponse delegate;
    private String state;

    public CarSpecificationRest(RestResponse delegate, String state) {
        this.delegate = delegate;
        this.state = state;
    }

    @Override
    protected void onPreExecute() {
        this.restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(AlucarConfig.BASE_URL)
                .build();
    }

    @Override
    protected CarSpecificationJson doInBackground(Void... params) {
        AlucarApi api = restAdapter.create(AlucarApi.class);
        CarSpecificationJson json = new CarSpecificationJson();
        try{
            json = api.getCarSpecification(state);
        }catch (RetrofitError error){
            Log.i(String.valueOf(R.string.error_label), String.valueOf(R.string.unknow_host));
            delegate.showErrorMsg();
        }
        return json;
    }

    @Override
    protected void onPostExecute(CarSpecificationJson carSpecificationJson) {
        if(carSpecificationJson.getCarSpec() != null){
            delegate.processFinish(carSpecificationJson.getCarSpec());
        }

    }

}
