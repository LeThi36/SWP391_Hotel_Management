package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DBContext {
    protected Connection connection;

    public DBContext() {
        try {
            String username = "sa";
            String password = "12345";
            String url = "jdbc:sqlserver://LAPTOP-TUDJ0JI8;databaseName=SWP_Hotel_Booking";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
