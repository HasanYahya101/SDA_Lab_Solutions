import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

class App {
    // create connection to microsoft sql server with integrated authentication
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TestDB;integratedSecurity=true;");
            System.out.println("Connected to SQL Server");
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL Server");
            e.printStackTrace();
        }
        return conn;
    }

    // execute query
    public static void query(Connection conn, String query) {
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Error executing query");
            e.printStackTrace();
        }
    }

    // close connection
    public static void close(Connection conn) {
        try {
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Error closing connection");
            e.printStackTrace();
        }
    }

    // test connection main
    public static void main(String[] args) {
        Connection conn = connect();
        query(conn, "SELECT * FROM sys.databases");
        close(conn);
    }
}