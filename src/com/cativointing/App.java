package com.cativointing;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.cativointing.login.Login;

import javax.swing.UnsupportedLookAndFeelException;

public class App {

    public static void main(String[] args) {
        System.out.println("APP START");

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatMacLightLaf());
            System.out.println("Successfully loaded FlatMacLightLaf theme.");
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

        // Close when program exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Successfully closed the program");
        }));

        System.out.println("APP END");
    }
}
