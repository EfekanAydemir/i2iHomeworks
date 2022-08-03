import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleDB {

    static Connection connection = null;
    static DbHelper dbHelper = new DbHelper();
    static PreparedStatement statement = null;

    public static void createTable() throws SQLException {
        connection = dbHelper.getConnection();
        String sql ="CREATE TABLE NUMBERS (numbers1 int)";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Table is created.");
    }

    public  static void dropTable() throws SQLException {
        connection = dbHelper.getConnection();
        String sql = "DROP TABLE NUMBERS";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Table is dropped.");
    }

    public static void insert20kOracle() throws SQLException {
        connection = dbHelper.getConnection();
        String sql = "INSERT INTO NUMBERS (numbers1) VALUES (?)";
        statement = connection.prepareStatement(sql);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            int randomNumber = (int) Math.ceil(Math.random() * 10);
            statement.setInt(1, randomNumber);
            statement.executeUpdate();
        }
        long finishtTime = System.currentTimeMillis();
        long totalTime = (finishtTime - startTime);
        System.out.println("Total time for Oracle 20.000 data insert = " + totalTime + "ms");

    }

    public static void insert100kOracle() throws SQLException {
        connection = dbHelper.getConnection();
        String sql = "INSERT INTO NUMBERS (numbers1) VALUES (?)";
        statement = connection.prepareStatement(sql);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = (int) Math.ceil(Math.random() * 10);
            statement.setInt(1, randomNumber);
            statement.executeUpdate();
        }
        long finishtTime = System.currentTimeMillis();
        long totalTime = (finishtTime - startTime);
        System.out.println("Total time for Oracle 100.000 data insert = " + totalTime + "ms");
    }

    public static void get20kOracle() throws SQLException {
        long startTime = System.currentTimeMillis();
        connection = dbHelper.getConnection();
        String sql = "SELECT * FROM NUMBERS WHERE rownum <=20000";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime-startTime;
        System.out.println("Total time for Oracle 20.000 data select : "+ totalTime+"ms");
    }

    public static void get100kOracle() throws SQLException {
        long startTime = System.currentTimeMillis();
        connection = dbHelper.getConnection();
        String sql = "SELECT * FROM NUMBERS WHERE rownum <=100000";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime-startTime;
        System.out.println("Total time for Oracle 100.000 data select : "+ totalTime+"ms");
    }
}
