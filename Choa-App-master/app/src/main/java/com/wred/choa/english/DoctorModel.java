package com.wred.choa.english;

public class DoctorModel {
    private String name;
    private String imgurl;
    private String tag;
    private String id;

    public DoctorModel() {
    }

    public DoctorModel(String name, String imgurl, String tag, String id) {
        this.name = name;
        this.imgurl = imgurl;
        this.tag = tag;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}