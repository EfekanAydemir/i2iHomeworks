import java.sql.SQLException;

public class Main {
    private static VoltDb voltDb = new VoltDb();
    private static OracleDb oracleDb = new OracleDb();

    public static void main(String[] args) throws SQLException {

        System.out.println("VOLTDB TIME PERFORMANCE BELOW ");
        System.out.println("-------------------------------");
        voltDb.createTable();
        voltDb.insert100kVoltDb();
        voltDb.get100kVoltDb();
        voltDb.dropTable();


        System.out.println("ORACLE TIME PERFORMANCE BELOW ");
        System.out.println("-------------------------------");
        oracleDb.createTable();
        oracleDb.insert100kOracle();
        oracleDb.get100kOracle();
        oracleDb.dropTable();

    }
}
