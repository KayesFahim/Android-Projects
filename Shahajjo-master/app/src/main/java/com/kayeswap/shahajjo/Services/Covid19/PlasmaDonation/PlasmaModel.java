package com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation;

public class PlasmaModel {
    String name;
    String contact;
    String location;
    String age;
    String blood;

    public PlasmaModel() {

    }

    public PlasmaModel(String name, String contact, String location, String age,String blood ) {
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.age = age;
        this.blood = blood;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}