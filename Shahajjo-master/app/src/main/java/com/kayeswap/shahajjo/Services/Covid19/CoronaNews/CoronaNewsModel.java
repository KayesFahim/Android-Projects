package com.kayeswap.shahajjo.Services.Covid19.CoronaNews;

public class CoronaNewsModel {
    String title;
    String blog;
    String source;

    public CoronaNewsModel() {
    }

    public CoronaNewsModel(String title, String blog, String source) {
        this.title = title;
        this.blog = blog;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
