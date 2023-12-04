package userdata.retail;

import java.util.HashMap;
import java.util.Map;

import userdata.BusinessInformation;

public class RetailData extends BusinessInformation {
    public static Map<Integer, product> products = new HashMap<>();
    public static Map<Integer, supplier> suppliers = new HashMap<>();
    public static Map<Integer, customer> customers = new HashMap<>();

    public static Map<Integer, product> deleteProducts = new HashMap<>();
    public static Map<Integer, supplier> deleteSuppliers = new HashMap<>();
    public static Map<Integer, customer> deleteCustomers = new HashMap<>();

    public RetailData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    public static Map<Integer, product> getProducts() {
        return products;
    }

    public static product getProduct(int ID) {
        return products.get(ID);
    }

    public static void addProduct(product p) {
        products.put(p.getID(), p);
    }

    public static void removeProduct(int ID) {
        products.remove(ID);
    }

    public static Map<Integer, supplier> getSuppliers() {
        return suppliers;
    }

    public static supplier getSupplier(int ID) {
        return suppliers.get(ID);
    }

    public static void addSupplier(supplier s) {
        suppliers.put(s.getID(), s);
    }

    public static void removeSupplier(int ID) {
        suppliers.remove(ID);
    }

    public static Map<Integer, customer> getCustomers() {
        return customers;
    }

    public static customer getCustomer(int ID) {
        return customers.get(ID);
    }

    public static void addCustomer(customer c) {
        customers.put(c.getID(), c);
    }

    public static void removeCustomer(int ID) {
        customers.remove(ID);
    }

    @Override
    public String toString() {
        return "RetailData [" + super.toString() + "]";
    }

}
