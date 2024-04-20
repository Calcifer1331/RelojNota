package com.mywebmanager.models;

public class Colors {

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

    public String getHexadecimal() {
        return Hexadecimal;
    }

    public void setHexadecimal(String Hexadecimal) {
        this.Hexadecimal = Hexadecimal;
    }
    private int Id;
    private String Name;
    private String Hexadecimal;

    public Colors() {
    }

    public Colors(int Id, String Name, String Hexadecimal) {
        this.Id = Id;
        this.Name = Name;
        this.Hexadecimal = Hexadecimal;
    }

}
