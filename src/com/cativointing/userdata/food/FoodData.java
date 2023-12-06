package com.cativointing.userdata.food;

import java.util.HashMap;
import java.util.Map;

import com.cativointing.userdata.BusinessInformation;
import com.cativointing.userdata.CustomerData;

public class FoodData extends BusinessInformation {
    private static final Map<Integer, CustomerData> CUSTOMERS = new HashMap<>();

    public FoodData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    public static Map<Integer, CustomerData> getCUSTOMERS() {
        return CUSTOMERS;
    }

    public static CustomerData getCustomer(int ID) {
        return CUSTOMERS.get(ID);
    }

    public static void addCustomer(CustomerData c) {
        CUSTOMERS.put(c.getID(), c);
    }

    public static void removeCustomer(int ID) {
        CUSTOMERS.remove(ID);
    }

    public static void saveData() {

    }

    public static void loadData() {
        
    }

    @Override
    public String toString() {
        return "FoodData [" + super.toString() + "]";
    }
}
