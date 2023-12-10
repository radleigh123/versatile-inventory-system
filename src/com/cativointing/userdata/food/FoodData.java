package com.cativointing.userdata.food;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.cativointing.userdata.BusinessInformation;

public class FoodData extends BusinessInformation {
    private static final Map<Integer, raw> RAWS = new HashMap<>();
    private static final Map<Integer, supplier> SUPPLIERS = new HashMap<>();
    private static final Map<Integer, wip> WIPS = new HashMap<>();

    public FoodData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    public static Map<Integer, raw> getRAWS() {
        return RAWS;
    }

    public static raw getRaw(int ID) {
        return RAWS.get(ID);
    }

    public static void addRaw(raw r) {
        RAWS.put(r.getID(), r);
    }

    public static void removeRaw(int ID) {
        RAWS.remove(ID);
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

    public static Map<Integer, wip> getWIPS() {
        return WIPS;
    }

    public static wip getWip(int ID) {
        return WIPS.get(ID);
    }

    public static void addWip(wip w) {
        WIPS.put(w.getID(), w);
    }

    public static void removeWip(int ID) {
        WIPS.remove(ID);
    }

    public static void loadData() {
        // String file = "src/com/cativointing/userdata/food/raw.txt";
        String file = "foodraw.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    int supp = Integer.parseInt(parts[3]);
                    RAWS.put(ID, new raw(ID, name, quantity, supp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "foodsupplier.txt";
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

        file = "foodwip.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int ID = Integer.parseInt(parts[0]);
                    String product = parts[1];
                    String status = parts[2];
                    WIPS.put(ID, new wip(ID, product, status));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully loaded data");
    }

    public static void saveData() {
        String file = "foodraw.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<Integer, raw> entry : RAWS.entrySet()) {
                writer.println(entry.getValue().getID() + "," 
                        + entry.getValue().getName() + ","
                        + entry.getValue().getQuantity() + ","
                        + entry.getValue().getSupplierID());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "foodsupplier.txt";
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

        file = "foodwip.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<Integer, wip> entry : WIPS.entrySet()) {
                writer.println(entry.getValue().getID() + "," 
                        + entry.getValue().getProduct() + ","
                        + entry.getValue().getStatus());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully saved data");
    }

    @Override
    public String toString() {
        return "FoodData [" + super.toString() + "]";
    }
}
