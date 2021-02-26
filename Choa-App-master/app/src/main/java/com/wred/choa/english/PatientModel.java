package com.wred.choa.english;

public class PatientModel {
    private String name;
    private  String age;
    private  String location;
    private  String imgurl;
    private  String id;

    public PatientModel() {
    }

    public PatientModel(String name, String age, String  location, String  imgurl, String id){
        this.name = name;
        this.age = age;
        this.location = location;
        this.imgurl = imgurl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
