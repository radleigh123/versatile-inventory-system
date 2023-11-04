package app;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Map;
import java.util.HashMap;

public class StartSQL {
    private final static String CON = "mongodb+srv://admin:123@cluster0.owqmodj.mongodb.net/?retryWrites=true&w=majority";
    private static MongoClient client;
    private static MongoDatabase db; // login database
    private static MongoDatabase clientDb;

    private static Map<String, Boolean> clientDatabases = new HashMap<>();

    public static MongoClient conClient() {
        try {
            client = MongoClients.create(CON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Connected to client");

        return client;
    }

    public static MongoClient getClient() {
        return client;
    }

    public static void setDb() {
        StartSQL.db = client.getDatabase("login_info");
    }

    public static MongoDatabase getDb() {
        return db;
    }

    /**
     * Once setup is complete, this method is called to update the client code database
     * @param clientCode {@code String}
     * @param password {@code String}
     */
    public static void loadClientDb(String clientCode, String password, String businessName, String businessType) {
        StartSQL.clientDb = client.getDatabase(clientCode);

        MongoCollection<Document> acc = clientDb.getCollection("account");

        if (acc.countDocuments() == 0) {
            Document doc = new Document("username", clientCode)
                    .append("password", password)
                    .append("businessName", businessName)
                    .append("businessType", businessType);

            acc.insertOne(doc);

            System.out.println("client code database loaded: "
                    + "username:" + clientCode
                    + ", password:" + password
                    + ", name:" + businessName
                    + ", type:" + businessType);
        }
    }

    /**
     * Adds the credentials to the login_info database
     * @param username (client code) {@code String}
     * @param password {@code String}
     */
    public static void addCredentialsToLogin(String username, String password) {
        Document doc = new Document("username", username)
                .append("password", password);

        db.getCollection("clients").insertOne(doc);

        System.out.println(
                "Added credentials to login_info database: " + "username:" + username + ", password:" + password);
    }

    public static MongoDatabase getClientDb() {
        return clientDb;
    }

    /**
     * Store existing clients to the map
     */
    public static void loadClientDatabases() {
        for (String name : client.listDatabaseNames()) {
            if (name.matches("^[0-9]{3}-[A-Z]{3}$")) {
                boolean isCollectionEmpty = client.getDatabase(name).getCollection("account").countDocuments() == 0;
                clientDatabases.put(name, isCollectionEmpty);
            }
        }
        System.out.println(clientDatabases);
    }

    /**
     * Checks if the client code is already in the cluster
     * @param clientCode {@code String}
     * @return {@code true} If the database is found and is empty
     */
    public static boolean isClientCodeDuplicate(String clientCode) {
        for (Map.Entry<String, Boolean> entry : clientDatabases.entrySet()) {
            if (entry.getKey().equals(clientCode) && entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the client code database is in client
     * @param clientCode string
     * @return {@code true} if the client code is found and the collection ("account") is empty
     * @deprecated Use {@link #isClientCodeDuplicate(String)} instead
     */
    public static boolean checkClientCode(String clientCode) {
        for (String name : client.listDatabaseNames()) {
            if (name.equals(clientCode) &&
                    client.getDatabase(clientCode).getCollection("account").countDocuments() == 0) {
                return true;
            }
        }

        return false;
    }

    /** Returns number of clients in the login_info database
     * @return an int representing the number of clients
     */
    public static int getNumberAccounts() {
        return (int) db.getCollection("clients").countDocuments();
    }

}
