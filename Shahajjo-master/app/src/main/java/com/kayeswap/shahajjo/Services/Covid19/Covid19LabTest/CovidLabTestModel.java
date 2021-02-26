package com.kayeswap.shahajjo.Services.Covid19.Covid19LabTest;

public class CovidLabTestModel{

    String name;
    String location;
    String contact;

    public CovidLabTestModel() {
    }

    public CovidLabTestModel(String name, String location, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
