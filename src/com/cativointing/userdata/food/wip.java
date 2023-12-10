package com.cativointing.userdata.food;

public class wip {
    private int ID;
    private String product;
    private String status;

    public wip(int ID, String product, String status) {
        this.ID = ID;
        this.product = product;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "wip [ID=" + ID + ", product=" + product + ", status=" + status + "]";
    }

}
