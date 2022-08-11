package com.mehboob.universalmarketings.Models;

public class RecyclerDashboardModel {

    int image;
    String title;

    public RecyclerDashboardModel(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
