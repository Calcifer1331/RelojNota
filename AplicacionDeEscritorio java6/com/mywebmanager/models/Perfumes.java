package com.mywebmanager.models;

import java.sql.Date;

public class Perfumes {

    public int getCategory_Perfume_Id() {
        return Category_Perfume_Id;
    }

    public void setCategory_Perfume_Id(int Category_Perfume_Id) {
        this.Category_Perfume_Id = Category_Perfume_Id;
    }

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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setInventoryQuantity(int InventoryQuantity) {
        this.InventoryQuantity = InventoryQuantity;
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
    private double Price;
    private int InventoryQuantity;
    private Date DateAdded;
    private int Category_Perfume_Id;

    public Perfumes() {
    }

    public Perfumes(int Id, String Name, String Image, String Description, double Price, int InventoryQuantity, Date DateAdded, int Category_Perfume_Id) {
        this.Id = Id;
        this.Name = Name;
        this.Image = Image;
        this.Description = Description;
        this.Price = Price;
        this.InventoryQuantity = InventoryQuantity;
        this.DateAdded = DateAdded;
        this.Category_Perfume_Id = Category_Perfume_Id;
    }

}
