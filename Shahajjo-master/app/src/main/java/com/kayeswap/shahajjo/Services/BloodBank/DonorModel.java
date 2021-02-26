package com.kayeswap.shahajjo.Services.BloodBank;

public class DonorModel {
    String name;
    String contact;
    String address;

    public DonorModel() {
    }

    public DonorModel(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
