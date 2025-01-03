package digitalwallet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class User {

    Connection con;
    Scanner sc;

    User(Connection con, Scanner sc) throws SQLException {
        this.con = con;
        this.sc = sc;
        userMenu();
    }

    public void userMenu() throws SQLException {

        System.out.println("1. User Registration");
        System.out.println("2. User Login");
        System.out.println("3. Exit");

        System.out.print("Choose an option : ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                userRegistration(con, sc);
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                return;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }

    public void userRegistration(Connection con, Scanner sc) throws SQLException {

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        while (!email.contains("@")) { // Basic email validation
            System.out.print("Invalid email. Please enter a valid email: ");
            email = sc.nextLine();
        }

        if (isValid(con,email)) {
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            while (password.length() < 6) { // Basic password validation
                System.out.print("Password must be at least 6 characters. Try again: ");
                password = sc.nextLine();
            }

            PreparedStatement ps = con.prepareStatement("INSERT INTO user (name,email,password) VALUES(?,?,?);");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            int r = ps.executeUpdate();
            if (r > 0) {
                System.out.println("Registration Successfully");
            } else {
                System.out.println("Failed to Registration!!! Try Again");
            }
        }else{
            System.out.println("User with this email already exist");
        }

    }
    
    public boolean isValid(Connection con, String email) throws SQLException{
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM user WHERE email ='"+email+"'");
        if(rs.next()){
            return false;
        }
        
        return true;
    }

}
