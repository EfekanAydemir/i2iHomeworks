import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    static String userName ;
    static String password ;
    static String dbUrl ;

    public DbHelper(String _userName,String _password, String _dbUrl){
        this.userName = _userName;
        this.password = _password;
        this.dbUrl = _dbUrl;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

}
