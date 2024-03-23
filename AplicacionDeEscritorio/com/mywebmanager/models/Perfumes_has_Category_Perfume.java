package com.mywebmanager.models;

public class Perfumes_has_Category_Perfume {

    public int getCategory_Perfume_Id() {
        return Category_Perfume_Id;
    }

    public void setCategory_Perfume_Id(int Category_Perfume_Id) {
        this.Category_Perfume_Id = Category_Perfume_Id;
    }

    public int getPerfumes_Id() {
        return Perfumes_Id;
    }

    public void setPerfumes_Id(int Perfumes_Id) {
        this.Perfumes_Id = Perfumes_Id;
    }

    private int Category_Perfume_Id;
    private int Perfumes_Id;

    public Perfumes_has_Category_Perfume(int Category_Perfume_Id, int Perfumes_Id) {
        this.Category_Perfume_Id = Category_Perfume_Id;
        this.Perfumes_Id = Perfumes_Id;
    }

    public Perfumes_has_Category_Perfume() {
    }

}
