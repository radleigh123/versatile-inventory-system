package com.cativointing.userdata;

import com.cativointing.userdata.food.FoodData;
import com.cativointing.userdata.retail.RetailData;
import com.cativointing.userdata.service.ServiceData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AvailableBusinesses {

    // clientCode, BusinessInformation
    public static Map<String, BusinessInformation> businesses = new HashMap<>();

    public static void checkDataFiles() {
        String code = "";
        String pass = "";
        String name = "";
        String categ = "";
        String type = "";

        try (BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    code += parts[0];
                    pass += parts[1];
                    name += parts[2];
                    categ += parts[3];
                    type += parts[4];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (code.equals("")) {
            return;
        }

        loadSpecificCategoryData(code, name, categ, type);
    }

    private static void loadSpecificCategoryData(String code, String name, String categ, String type) {
        switch (categ) {
            case "Retail" -> {
                businesses.put(code, new RetailData(code, name, categ, type));
                RetailData r = (RetailData) businesses.get(code);
                r.loadData();
            }
            case "Food Service" -> {
                businesses.put(code, new FoodData(code, name, categ, type));
                FoodData f = (FoodData) businesses.get(code);
                f.loadData();
            }
            case "Service-Based" -> {
                businesses.put(code, new ServiceData(code, name, categ, type));
                ServiceData s = (ServiceData) businesses.get(code);
                s.loadData();
            }
            default -> System.out.println("Category does not exist");
        }
    }
}
