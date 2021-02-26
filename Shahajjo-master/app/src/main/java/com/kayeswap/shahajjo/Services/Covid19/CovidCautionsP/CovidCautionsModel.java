package com.kayeswap.shahajjo.Services.Covid19.CovidCautionsP;

public class CovidCautionsModel {
    String title;
    String blog;

    public CovidCautionsModel() {
    }

    public CovidCautionsModel(String title, String blog) {
        this.title = title;
        this.blog = blog;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

}
