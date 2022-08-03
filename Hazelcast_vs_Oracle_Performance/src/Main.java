import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Hazelcast hazelcast = new Hazelcast();
        OracleDB oracleDB = new OracleDB();

        System.out.println("ORACLE TIME PERFORMANCE BELOW ");
        System.out.println("-------------------------------");
        oracleDB.createTable();
        oracleDB.insert20kOracle();
        oracleDB.insert100kOracle();
        oracleDB.get20kOracle();
        oracleDB.get100kOracle();
        oracleDB.dropTable();

        System.out.println("HAZELCAST TIME PERFORMANCE BELOW ");
        System.out.println("-------------------------------");
        hazelcast.insert20kHazel();
        hazelcast.insert100kHazel();
        hazelcast.get20kHazel();
        hazelcast.get100kHazel();



    }
}
