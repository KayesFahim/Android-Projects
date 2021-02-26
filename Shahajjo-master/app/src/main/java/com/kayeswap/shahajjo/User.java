package com.kayeswap.shahajjo;

public class User {

    String name;
    String phone;
    String blood;
    String location;

    public User() {
    }

    public User(String name, String blood) {
        this.name = name;
        this.phone = phone;
        this.blood = blood;
        this.location = location;
    }

    public String getName() {
        return name;
    }


    public String getPhone() {
        return phone;

    }

    public String getBlood() {
        return blood;
    }

    public String getLocation() {
        return location;
    }

}
