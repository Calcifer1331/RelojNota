
package com.mywebmanager.models;

import java.sql.Date;

public class Category_Perfume {

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(Date DateAdded) {
        this.DateAdded = DateAdded;
    }

    private int Id;
    private String Name;
    private String Image;
    private String Description;
    private Date DateAdded;

    public Category_Perfume() {
    }

    public Category_Perfume(int Id, String Name, String Image, String Description, Date DateAdded) {
        this.Id = Id;
        this.Name = Name;
        this.Image = Image;
        this.Description = Description;
        this.DateAdded = DateAdded;
    }
    
}
