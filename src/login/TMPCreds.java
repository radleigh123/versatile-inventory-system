package login;

import java.util.Scanner;

public class TMPCreds {
    public static void main(String[] args) {
        UserCredentials user = new UserCredentials();
        Scanner scan = new Scanner(System.in);
        String file = "creds.txt";

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();

            user.addCreds(username, password);
        }

        user.saveCreds(file);

        scan.close();
    }
}
