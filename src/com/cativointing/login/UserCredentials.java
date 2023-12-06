package com.cativointing.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import java.util.HashMap;

public class UserCredentials {

    public final static String CREDSFILE = "creds.txt";
    private static final Map<String, String> CREDS = new HashMap<>();
    public static String username;
    
    public static void checkCredsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(CREDSFILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    username = parts[0];
                    String hashedPassword = parts[1];
                    CREDS.put(username, hashedPassword);
                }
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

    // TODO: Depreciated, to be removed in the future
    /* Store into Map - OPTIONAL OR NOT NEEDED?
    private void loadCreds(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String hashedPassword = parts[1];
                    creds.put(username, hashedPassword);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
    
    // TODO: Depreciated, to be removed in the future
    /**
     * Iterates through the Map and saves the credentials to a file
     */
    public static void saveCREDS() {
        try (PrintWriter writer = new PrintWriter(CREDSFILE)) {
            for (Map.Entry<String, String> entry : CREDS.entrySet()) {
                // username:password
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }
        
        System.out.println("Written credentials to file");
    }

    public static void addCREDS(String user, String password) {
        CREDS.put(user, password);
        
        System.out.println("Added credentials to the map: " + CREDS);
    }

    public static boolean verify(String user, String password) {
        if (user.equals("") || password.equals("")) {
            return false;
        }

        if (!CREDS.containsKey(user)) {
            return false;
        }

        return CREDS.get(user).equals(password);
    }

}
