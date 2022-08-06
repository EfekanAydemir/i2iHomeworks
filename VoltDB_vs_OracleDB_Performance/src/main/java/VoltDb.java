import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoltDb {


    private static DbHelper dbHelper = new DbHelper("system", "voltDb", "jdbc:voltdb://localhost:49162");
    private static Subscriber subscriber = new Subscriber();
    private static Connection connection;
    private static PreparedStatement statement = null;

    static {
        try {
            connection = dbHelper.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insert100kVoltDb() throws SQLException {
        String sql = "INSERT INTO SUBSCRIBERS (telNo, packageName, usage, remainingUsage)" +
                "values(?,?,?,?)";
        statement = connection.prepareStatement(sql);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int remainingUsage = 5000 - (subscriber.randomUsage());
            statement.setString(1, subscriber.randomTelNo());
            statement.setString(2, subscriber.getPackageName());
            statement.setInt(3, subscriber.randomUsage());
            statement.setInt(4, remainingUsage);
            statement.executeUpdate();
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("100k data inserted to VoltDB : " + totalTime + "ms");
    }

    public static void get100kVoltDb() throws SQLException {
        long startTime = System.currentTimeMillis();
        String sql = "SELECT TOP 100000 * FROM SUBSCRIBERS";
        statement = connection.prepareStatement(sql);
        statement.execute();
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("100k data selected from VoltDB " + totalTime + "ms");
    }

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE Subscribers " +
                "(telNo varchar(15), packageName varchar(35), usage int, remainingUsage int)";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Table is created.");
    }

    public static void dropTable() throws SQLException {
        String sql = "DROP TABLE subscribers";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Table is deleted.");
    }

}
