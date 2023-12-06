package com.cativointing.userdata;

public class BusinessInformation {
    private final String ID;
    private final String TITLE;
    private final String CATEGORY;
    private final String TYPE;

    public BusinessInformation(String ID, String title, String category, String type) {
        this.ID = ID;
        TITLE = title;
        CATEGORY = category;
        TYPE = type;
    }

    public String getID() {
        return ID;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "[" + TITLE + ", " + CATEGORY + ", " + TYPE + "]";
    }
}
