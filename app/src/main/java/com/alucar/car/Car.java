package com.alucar.car;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {

    private long id;
    private String manufacturer;
    private String model;
    private String chassi;
    private String licensePlate;
    private String state;
    private String city;
    private String image;

    public Car(Parcel source){
        id = source.readLong();
        manufacturer = source.readString();
        model = source.readString();
        chassi = source.readString();
        licensePlate = source.readString();
        state = source.readString();
        city = source.readString();
        image = source.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(manufacturer);
        dest.writeString(model);
        dest.writeString(chassi);
        dest.writeString(licensePlate);
        dest.writeString(state);
        dest.writeString(city);
        dest.writeString(image);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Object createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
