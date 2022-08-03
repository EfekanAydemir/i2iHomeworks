import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    static String userName = "system";
    static String password = "oracle";
    static String dbUrl = "jdbc:oracle:thin:@localhost:49161:xe";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

}
