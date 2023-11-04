package userlogin.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import userlogin.login.userdata.StartSQL;

import java.util.HashMap;

public class UserCredentials {

    private static Map<String, String> creds;
    private final static String fileName = "creds.txt";

    private static String username;
    private String password;

    public UserCredentials() {
        // Stops dbs from loading multiple times
        if (creds == null || creds.isEmpty()) {
            creds = new HashMap<>();
            loadDb();
        }

        // check if an additional account is added
        if (creds.size() < StartSQL.getNumberAccounts()) {
            creds = new HashMap<>();
            loadDb();
        }
    }

    private void loadDb() {
        StartSQL.setDb();

        MongoDatabase database = StartSQL.getDb();
        MongoCollection<Document> logins = database.getCollection("clients");
        MongoCursor<Document> cursor = logins.find().iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                username = doc.getString("username");
                password = doc.getString("password");

                addCreds(username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

        saveCreds(fileName);
        System.out.println(creds);
    }

    // Store into Map - OPTIONAL OR NOT NEEDED?
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
