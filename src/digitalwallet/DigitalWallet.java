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
        long accNumber;

        User user = new User(con, sc);
        Accounts acc = new Accounts(con, sc);
        AccountManager accM = new AccountManager(con, sc);

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
                    email = user.Login();
                    if (email != null) {
                        System.out.println("");
                        System.out.println("User Loged In");
                        System.out.println("");
                        if (!acc.isExist(email)) {
                            System.out.println("");
                            System.out.println("1. Open a new Account");
                            System.out.println("2. Exit");
                            int ch = sc.nextInt();
                            if (ch == 1) {
                                accNumber = acc.openAccount(email);
                                System.out.println("Account is created Successfully");
                                System.out.println("Your account number is : " + accNumber);
                            } else {
                                break;
                            }

                        }
                        accNumber = acc.getAccountNumber(email);
                        int ch2 = 0;
                        while (ch2 != 5) {
                            System.out.println("1. Withdraw Money");
                            System.out.println("2. Add Money");
                            System.out.println("3. Transfer Money");
                            System.out.println("4. Check Balance");
                            System.out.println("5. LogOut");
                            System.out.print("Choose an option : ");
                            ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1:
                                    accM.withdrawMoney(accNumber);
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("Logging Out");
                                    System.out.println("Thank you for using Digital Wallet");
                                    return;
                                default:
                                    System.out.println("Invalid Choice!!! ");
                                    break;

                            }

                        }

                    } else {
                        System.out.println("Invalid email or password");
                    }
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
