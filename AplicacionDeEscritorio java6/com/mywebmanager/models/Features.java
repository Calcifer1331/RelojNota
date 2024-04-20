package com.mywebmanager.models;

public class Features {

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getParagraph() {
        return Paragraph;
    }

    public void setParagraph(String Paragraph) {
        this.Paragraph = Paragraph;
    }
    private int Id;
    private String Icon;
    private String Title;
    private String Paragraph;

    public Features(int Id, String Icon, String Title, String Paragraph) {
        this.Id = Id;
        this.Icon = Icon;
        this.Title = Title;
        this.Paragraph = Paragraph;
    }

    public Features() {
    }

}
