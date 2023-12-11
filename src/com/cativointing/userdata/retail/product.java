package com.cativointing.userdata.retail;

public class product {
    private int ID;
    private String name;
    private String category;
    private String quantity;
    private int supp;
    private double price;

    public product(int ID, String name, String category, String quantity, int supp, double price) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.supp = supp;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getSupp() {
        return supp;
    }

    public void setSupp(int supp) {
        this.supp = supp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product [ID=" + ID + ", name=" + name + ", category=" + category + ", quantity=" + quantity + ", supp="
                + supp + ", price=" + price + "]";
    }

}