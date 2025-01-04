package digitalwallet;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DigitalWallet {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost/digita_wallet";
        final String userName = "root";
        final String password = "29344";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        String email;
        long acc_number;

        User user = new User(con, sc);

        while (true) {
            System.out.println("WELCOME TO DIGITAL WALLET");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    user.userRegistration();
                    System.out.println("");
                    break;
                case 2:
                    user.Login();
                    break;
                case 3:
                    System.out.println("Existing System....");
                    System.out.println("Thank you for using Digital Wallet");
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;

            }

        }

    }

}
