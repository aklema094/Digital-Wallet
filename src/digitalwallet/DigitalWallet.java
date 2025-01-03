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
        
        User user = new User(con, sc);
        
        System.exit(0);
        
    }
    
}
