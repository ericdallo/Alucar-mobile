package com.alucar.car;

public class Car {

    private long id;
    private String manufacturer;
    private String model;
    private String chassi;
    private String license;
    private String state;
    private String city;
    private String image;

    public Car(long id, String manufacturer, String model, String chassi, String license, String state, String city, String image) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.chassi = chassi;
        this.license = license;
        this.state = state;
        this.city = city;
        this.image = image;
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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
}
