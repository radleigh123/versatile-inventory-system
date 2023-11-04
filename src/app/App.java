package app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mongodb.client.MongoClient;

import userlogin.login.login;

import javax.swing.UnsupportedLookAndFeelException;

public class App {

    public static void main(String[] args) {
        System.out.println("APP START..");

        MongoClient client = StartSQL.conClient();
        StartSQL.loadClientDatabases();

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatMacLightLaf());
            System.out.println("Successfully loaded FlatMacLightLaf theme.");
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });

        // Close when program exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            client.close();
            System.out.println("MongoClient closed.");
        }));

        System.out.println("APP END..");
    }
}
