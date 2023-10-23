package app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UnsupportedLookAndFeelException;
import login.login;

public class App {

    public static void main(String[] args) {
        System.out.println("PROGRAM STARTING...");

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });

        System.out.println("PROGRAM TERMINATED...");
    }
}
