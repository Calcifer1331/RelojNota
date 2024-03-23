package com.mywebmanager.models;

public class Gallery {

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    private int Id;
    private String Image;

    public Gallery() {
    }

    public Gallery(int Id, String Image) {
        this.Id = Id;
        this.Image = Image;
    }

}
