package com.cativointing.userdata.service;

public class schedule {
    private int ID;
    private String name;
    private String date;

    public schedule(int ID, String name, String date) {
        this.ID = ID;
        this.name = name;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "schedule [ID=" + ID + ", name=" + name + ", date=" + date + "]";
    }

}