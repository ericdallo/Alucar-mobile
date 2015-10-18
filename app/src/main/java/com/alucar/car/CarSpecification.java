package com.alucar.car;

import android.os.Parcel;
import android.os.Parcelable;

public class CarSpecification implements Parcelable{

    private String model;
    private String manufacturer;

    public CarSpecification(Parcel source){
        model = source.readString();
        manufacturer = source.readString();
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        dest.writeString(manufacturer);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Object createFromParcel(Parcel source) {
            return new CarSpecification(source);
        }

        @Override
        public CarSpecification[] newArray(int size) {
            return new CarSpecification[size];
        }
    };
}
