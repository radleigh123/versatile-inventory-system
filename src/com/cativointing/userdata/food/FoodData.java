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
    private static final Map<String, Integer> FINISH = new HashMap<>();

    public static Map<Integer, raw> tempRaw = new HashMap<>();

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

    public static Map<String, Integer> getFINISH() {
        return FINISH;
    }

    public static int getFinish(String name) {
        return FINISH.get(name);
    }

    public static void addFinish(String name, Integer qty) {
        FINISH.put(name, qty);
    }

    public static void removeFinish(String name) {
        FINISH.remove(name);
    }

    public static void loadData() {
        String file = "foodraw.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String quantity = parts[2];
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
                if (parts.length == 4) {
                    int ID = Integer.parseInt(parts[0]);
                    String product = parts[1];
                    String status = parts[2];
                    String quantity = parts[3];
                    WIPS.put(ID, new wip(ID, product, status, quantity));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "foodtmpraw.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String quantity = parts[2];
                    int supp = Integer.parseInt(parts[3]);
                    tempRaw.put(ID, new raw(ID, name, quantity, supp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "foodfinish.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int qty = Integer.parseInt(parts[1]);
                    FINISH.put(name, qty);
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
                        + entry.getValue().getStatus() + ", "
                        + entry.getValue().getQuantity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "foodtmpraw.txt";
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

        file = "foodfinish.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<String, Integer> entry : FINISH.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
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
