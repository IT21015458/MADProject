package com.example.foodapp.classes;

public class Foods {

    String name, price;

    public Foods() {
    }

    public Foods(String name, String price, String fid) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
