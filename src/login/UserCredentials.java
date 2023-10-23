package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

public class UserCredentials {

    private Map<String, String> creds;
    private String fileName;

    public UserCredentials() {
        creds = new HashMap<>();
        fileName = "creds.txt";

        loadCreds(fileName);
    }

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
    }

    public void saveCreds(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Map.Entry<String, String> entry : creds.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCreds(String user, String password) {
        creds.put(user, password);
    }

    public boolean verify(String user, String password) {
        if (user == null || password == null) {
            return false;
        }

        if (user.isBlank() || password.isBlank()) {
            return false;
        }

        if (creds.containsKey(user)) {
            if (creds.get(user).equals(password)) {
                return true;
            }
        }

        return false;
    }

}
