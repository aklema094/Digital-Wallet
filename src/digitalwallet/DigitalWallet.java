
package digitalwallet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DigitalWallet {
    

    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        
        final String url = "jdbc:mysql://localhost/digita_wallet";
        final String userName = "root";
        final String password = "29344";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        System.exit(0);
    }
    
}
