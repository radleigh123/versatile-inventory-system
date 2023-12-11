package com.cativointing.userdata.retail;

import java.util.HashMap;
import java.util.Map;

import com.cativointing.userdata.BusinessInformation;
import com.cativointing.userdata.CustomerData;

import java.io.IOException;
import java.io.PrintWriter;

public class RetailData extends BusinessInformation {

    private static final Map<Integer, product> PRODUCTS = new HashMap<>();
    private static final Map<Integer, supplier> SUPPLIERS = new HashMap<>();
    private static final Map<Integer, CustomerData> CUSTOMERS = new HashMap<>();

    public RetailData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    public static Map<Integer, product> getPRODUCTS() {
        return PRODUCTS;
    }

    public static product getProduct(int ID) {
        return PRODUCTS.get(ID);
    }

    public static void addProduct(product p) {
        PRODUCTS.put(p.getID(), p);
    }

    public static void removeProduct(int ID) {
        PRODUCTS.remove(ID);
    }

    public static Map<Integer, supplier> getSUPPLIERS() {
        return SUPPLIERS;
    }

    public static supplier getSupplier(int ID) {
        return SUPPLIERS.get(ID);
    }

    public static void addSupplier(supplier s) {
        SUPPLIERS.put(s.getID(), s);
    }

    public static void removeSupplier(int ID) {
        SUPPLIERS.remove(ID);
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
        String file = "retailproduct.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<Integer, product> entry : PRODUCTS.entrySet()) {
                writer.println(entry.getValue().getID() + "," 
                        + entry.getValue().getName() + "," 
                        + entry.getValue().getCategory() + "," 
                        + entry.getValue().getQuantity() + "," 
                        + entry.getValue().getSupp() + "," 
                        + entry.getValue().getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        file = "retailsupplier.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<Integer, supplier> entry : SUPPLIERS.entrySet()) {
                writer.println(entry.getValue().getID() + "," 
                        + entry.getValue().getName() + "," 
                        + entry.getValue().getContact() + "," 
                        + entry.getValue().getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        file = "retailcustomer.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<Integer, CustomerData> entry : CUSTOMERS.entrySet()) {
                writer.println(entry.getValue().getID() + "," 
                        + entry.getValue().getName() + "," 
                        + entry.getValue().getContact() + "," 
                        + entry.getValue().getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully saved data");
    }

    public void loadData() {
        String file = "retailproduct.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String category = parts[2];
                    String quantity = parts[3];
                    int supp = Integer.parseInt(parts[4]);
                    double price = Double.parseDouble(parts[5]);
                    PRODUCTS.put(ID, new product(ID, name, category, quantity, supp, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "retailsupplier.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int contact = Integer.parseInt(parts[2]);
                    String email = parts[3];
                    SUPPLIERS.put(ID, new supplier(ID, name, contact, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "retailcustomer.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int contact = Integer.parseInt(parts[2]);
                    String email = parts[3];
                    CUSTOMERS.put(ID, new CustomerData(ID, name, contact, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully loaded data");
    }

    @Override
    public String toString() {
        return "RetailData [" + super.toString() + "]";
    }

}
