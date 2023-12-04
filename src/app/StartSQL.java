package app;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import userdata.BusinessInformation;
import userdata.Businesses;
import userdata.food.FoodData;
import userdata.retail.RetailData;
import userdata.retail.customer;
import userdata.retail.product;
import userdata.retail.supplier;
import userdata.service.ServiceData;

import java.util.Map;
import java.util.HashMap;

public class StartSQL {
    private final static String CON = "mongodb+srv://admin:123@cluster0.owqmodj.mongodb.net/?retryWrites=true&w=majority";
    private static MongoClient client;
    private static MongoDatabase loginDB; // login database
    private static MongoDatabase clientDB;

    private static Map<String, Boolean> clientDatabases = new HashMap<>();
    public static int currentNumberAccounts = 0;
    public static String clientCode;

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

    public static void setLoginDB() {
        loginDB = client.getDatabase("login_info");
    }

    public static MongoDatabase getLoginDB() {
        return loginDB;
    }

    /** Returns number of clients in the login_info database
     * @return an int representing the number of clients
     */
    public static int getNumberAccounts() {
        return currentNumberAccounts;
    }

    public static void updateNumberAccounts() {
        currentNumberAccounts = (int) loginDB.getCollection("clients").countDocuments();
    }

    public static void createRetailCollection(String clientCode) {
        StartSQL.clientDB = client.getDatabase(clientCode);

        clientDB.createCollection("products");
        clientDB.createCollection("suppliers");
        clientDB.createCollection("customers");
    }

    /**
     * If setup is successful, this method is called. Updates the client code database
     * @param clientCode {@code String}
     * @param password {@code String}
     * @param businessName {@code String}
     * @param businessCategory {@code String}
     * @param businessType {@code String}
     */
    public static void addClientDb(String clientCode, String password, String businessName, String businessCategory,
            String businessType) {
        MongoCollection<Document> acc = client.getDatabase(clientCode).getCollection("account");

        if (acc.countDocuments() == 0) {
            Document doc = new Document("username", clientCode)
                    .append("password", password)
                    .append("title", businessName)
                    .append("category", businessCategory)
                    .append("type", businessType);

            acc.insertOne(doc);

            StartSQL.updateNumberAccounts();
            System.out.println("client code database loaded: "
                    + "username:" + clientCode
                    + ", password:" + password
                    + ", title:" + businessName
                    + ", category:" + businessCategory
                    + ", type:" + businessType);
        }
    }

    /**
     * Adds the credentials to the login_info database
     * @param username (client code) {@code String}
     * @param password {@code String}
     */
    public static void addCredentialsToLogin(String username, String password) {
        Document doc = new Document("username", username).append("password", password);

        loginDB.getCollection("clients").insertOne(doc);

        System.out.println("Added credentials to login_info database: "
                + "username:" + username
                + ", password:" + password);
    }

    /**
     * Store existing clients to the map
     * @apiNote {@code clientDatabases.put(String, Boolean)} stores the client code and a boolean to determine if client has been setup
     */
    public static void loadClientDatabases() {
        boolean isCollectionEmpty = false;

        // Checks specific code (this determines if it is a client database)
        for (String name : client.listDatabaseNames()) {
            if (name.matches("^[0-9]{3}-[A-Z]{3}$")) {
                isCollectionEmpty = client.getDatabase(name).getCollection("account").countDocuments() == 0;
                clientDatabases.put(name, isCollectionEmpty);
            }

            if (name.matches("^[0-9]{3}-[A-Z]{3}$") && isCollectionEmpty == false) {
                String clientCode = client.getDatabase(name)
                        .getCollection("account").find().first()
                        .getString("username");
                String businessTitle = client.getDatabase(name)
                        .getCollection("account").find().first()
                        .getString("title");
                String businessCategory = client.getDatabase(name)
                        .getCollection("account").find().first()
                        .getString("category");
                String businessType = client.getDatabase(name)
                        .getCollection("account").find().first()
                        .getString("type");

                switch (businessCategory) {
                    case "Retail":
                        Businesses.businesses.put(clientCode,
                                new RetailData(
                                        clientCode,
                                        businessTitle,
                                        businessCategory,
                                        businessType));
                        break;
                    case "Food Service":
                        Businesses.businesses.put(clientCode,
                                new FoodData(
                                        clientCode,
                                        businessTitle,
                                        businessCategory,
                                        businessType));
                        break;
                    case "Service-Based":
                        Businesses.businesses.put(clientCode,
                                new ServiceData(
                                        clientCode,
                                        businessTitle,
                                        businessCategory,
                                        businessType));
                        break;
                    default:
                        System.out.println("ERROR: username's category does not exist");
                        break;
                }
            }
        }

        System.out.println("clientDatabases:" + clientDatabases);
        System.out.println("businesses:" + Businesses.businesses);
    }

    public static void loadRetailClientDatabase(String clientCode) {
        MongoDatabase db = client.getDatabase(clientCode);
        MongoCollection<Document> products = db.getCollection("products");
        MongoCollection<Document> suppliers = db.getCollection("suppliers");
        MongoCollection<Document> customers = db.getCollection("customers");

        for (Document doc : suppliers.find()) {
            int ID = doc.getInteger("ID");
            String name = doc.getString("name");
            int contact = doc.getInteger("contact");
            String email = doc.getString("email");

            RetailData.addSupplier(new supplier(ID, name, contact, email));
        }

        for (Document doc : customers.find()) {
            int ID = doc.getInteger("ID");
            String name = doc.getString("name");
            int contact = doc.getInteger("contact");
            String email = doc.getString("email");

            RetailData.addCustomer(new customer(ID, name, contact, email));
        }

        // last to load since it requires the suppliers collection to be loaded
        for (Document doc : products.find()) {
            int ID = doc.getInteger("ID");
            String name = doc.getString("name");
            String category = doc.getString("category");
            int quantity = doc.getInteger("quantity");
            int supplier = doc.getInteger("supplier");
            double price = doc.getDouble("price");

            RetailData.addProduct(new product(ID, name, category, quantity, supplier, price));
        }

    }

    // TODO: Add method to load food client database
    // TODO: Add method to load service client database

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

    public static void saveRetailToDataBase(BusinessInformation b) {
        RetailData r = (RetailData) b;
        String clientCode = r.getID();

        MongoCollection<Document> products = client.getDatabase(clientCode).getCollection("products");
        MongoCollection<Document> suppliers = client.getDatabase(clientCode).getCollection("suppliers");
        MongoCollection<Document> customers = client.getDatabase(clientCode).getCollection("customers");

        deleteProductDocuments(products);
        deleteSupplierDocuments(suppliers);
        deleteCustomerDocuments(customers);

        saveOrUpdateProducts(products);
        saveOrUpdateSuppliers(suppliers);
        saveOrUpdateCustomers(customers);

        System.out.println("Saved retail data to database");
    }

    private static void saveOrUpdateProducts(MongoCollection<Document> productsCol) {
        for (Integer id : RetailData.getProducts().keySet()) {
            product p = RetailData.getProduct(id);

            Document query = new Document("ID", p.getID());
            Document updateDoc = new Document("$set",
                    new Document("ID", p.getID())
                            .append("name", p.getName())
                            .append("category", p.getCategory())
                            .append("quantity", p.getQuantity())
                            .append("supplier", p.getSupp())
                            .append("price", p.getPrice()));

            if (productsCol.countDocuments(query) > 0) {
                productsCol.updateOne(query, updateDoc);
                System.out.println("product updated");
            } else {
                productsCol.insertOne(new Document("ID", p.getID())
                        .append("name", p.getName())
                        .append("category", p.getCategory())
                        .append("quantity", p.getQuantity())
                        .append("supplier", p.getSupp())
                        .append("price", p.getPrice()));
                System.out.println("product added");
            }
        }
    }

    private static void saveOrUpdateSuppliers(MongoCollection<Document> suppliersCol) {
        for (Integer id : RetailData.getSuppliers().keySet()) {
            supplier s = RetailData.getSupplier(id);

            Document query = new Document("ID", s.getID());
            Document updateDoc = new Document("$set",
                    new Document("ID", s.getID())
                            .append("name", s.getName())
                            .append("contact", s.getContact())
                            .append("email", s.getEmail()));

            if (suppliersCol.countDocuments(query) > 0) {
                suppliersCol.updateOne(query, updateDoc);
                System.out.println("supplier updated");
            } else {
                suppliersCol.insertOne(new Document("ID", s.getID())
                        .append("name", s.getName())
                        .append("contact", s.getContact())
                        .append("email", s.getEmail()));
                System.out.println("supplier added");
            }
        }
    }

    private static void saveOrUpdateCustomers(MongoCollection<Document> customersCol) {
        for (Integer id : RetailData.getCustomers().keySet()) {
            customer c = RetailData.getCustomer(id);

            Document query = new Document("ID", c.getID());
            Document updateDoc = new Document("$set",
                    new Document("ID", c.getID())
                            .append("name", c.getName())
                            .append("contact", c.getContact())
                            .append("email", c.getEmail()));

            if (customersCol.countDocuments(query) > 0) {
                customersCol.updateOne(query, updateDoc);
                System.out.println("customer updated");
            } else {
                customersCol.insertOne(new Document("ID", c.getID())
                        .append("name", c.getName())
                        .append("contact", c.getContact())
                        .append("email", c.getEmail()));
                System.out.println("customer added");
            }
        }
    }

    private static void deleteProductDocuments(MongoCollection<Document> col) {
        for (Integer id : RetailData.deleteProducts.keySet()) {
            System.out.println("Deleted: " + RetailData.deleteProducts.get(id));

            col.deleteOne(Filters.eq("ID", id));
            RetailData.deleteProducts.remove(id);
            // System.out.println(RetailData.deleteProducts);
        }
    }

    private static void deleteSupplierDocuments(MongoCollection<Document> col) {
        for (Integer id : RetailData.deleteSuppliers.keySet()) {
            System.out.println("Deleted: " + RetailData.deleteSuppliers.get(id));

            col.deleteOne(Filters.eq("ID", id));
            RetailData.deleteSuppliers.remove(id);
            // System.out.println(RetailData.deleteSuppliers);
        }
    }

    private static void deleteCustomerDocuments(MongoCollection<Document> col) {
        for (Integer id : RetailData.deleteCustomers.keySet()) {
            System.out.println("Deleted: " + RetailData.deleteCustomers.get(id));

            col.deleteOne(Filters.eq("ID", id));
            RetailData.deleteCustomers.remove(id);
            // System.out.println(RetailData.deleteCustomers);
        }
    }

}
