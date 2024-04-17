I did this in VSCode instead of Netbeans. Also, this code is used for the connection:

public class l227971_Lab08_q3 {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SDA_Lab;integratedSecurity=true;encrypt=false;";
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            System.out.println("Connected to the database");
        } catch (SQLException e) {
               System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
