package userlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import app.StartSQL;

import java.util.HashMap;

public class UserCredentials {

    private final static String fileName = "creds.txt";
    private static Map<String, String> creds;
    private static String username;

    private String password;

    public UserCredentials() {
        // Stops `loadDB()` method from being called multiple times
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

    /**
     * Gets the credentials from the database, and stores them into a Map
     */
    private void loadDb() {
        MongoDatabase database = StartSQL.getLoginDB();
        MongoCollection<Document> logins = database.getCollection("clients");
        MongoCursor<Document> cursor = logins.find().iterator();
        StartSQL.updateNumberAccounts();

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

    /**
     * Iterates through the Map and saves the credentials to a file
     * @param filename {@code String}
     */
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
