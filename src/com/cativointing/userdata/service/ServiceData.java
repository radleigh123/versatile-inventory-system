package com.cativointing.userdata.service;

import com.cativointing.userdata.BusinessInformation;
import com.cativointing.userdata.CustomerData;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;

public class ServiceData extends BusinessInformation {

    private static final Map<Integer, schedule> SCHEDULES = new HashMap<>();
    private static final Map<Integer, CustomerData> CUSTOMERS = new HashMap<>();
    
    private static final List<schedule> DONE_SCHEDULES = new ArrayList<>();

    public static List<schedule> tempSchedules = new ArrayList<>();

    public ServiceData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    public static Map<Integer, schedule> getSCHEDULES() {
        return SCHEDULES;
    }

    public static schedule getSchedule(int ID) {
        return SCHEDULES.get(ID);
    }

    public static void addSchedule(schedule s) {
        SCHEDULES.put(s.getID(), s);
    }

    public static void removeSchedule(int ID) {
        SCHEDULES.remove(ID);
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

    public static List<schedule> getDONE_SCHEDULES() {
        return DONE_SCHEDULES;
    }

    public static schedule getDoneSchedule(int ID) {
        return DONE_SCHEDULES.get(ID);
    }

    public static void addDoneSchedule(schedule s) {
        DONE_SCHEDULES.add(s);
    }

    public static void loadData() {
        // String file = "src/com/cativointing/userdata/service/customer.txt";
        String file = "servicecustomer.txt";
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

        if (tempSchedules == null) tempSchedules = new ArrayList<>();

        file = "serviceschedule.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String date = parts[2];
                    tempSchedules.add(new schedule(ID, name, date));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "servicereport.txt";
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int ID = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String date = parts[2];
                    DONE_SCHEDULES.add(new schedule(ID, name, date));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully loaded data.");
    }

    public static void saveData() {
        String file = "servicecustomer.txt";
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

        file = "serviceschedule.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (schedule s : tempSchedules) {
                writer.println(s.getID() + "," 
                        + s.getName() + "," 
                        + s.getDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = "servicereport.txt";
        try (PrintWriter writer = new PrintWriter(file)) {
            for (schedule s : DONE_SCHEDULES) {
                writer.println(s.getID() + "," 
                        + s.getName() + "," 
                        + s.getDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully saved data.");

    }

    @Override
    public String toString() {
        return "ServiceData [" + super.toString() + "]";
    }
}
