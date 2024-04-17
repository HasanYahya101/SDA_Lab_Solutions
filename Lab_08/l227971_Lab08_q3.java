import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// User class
abstract class User {
    protected String username;
    protected String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Abstract method for login
    public abstract boolean login(String username, String password);
}

// Student class
class Student extends User {
    // Constructor
    public Student(String username, String password) {
        super(username, password);
    }

    // Override login method
    @Override
    public boolean login(String username, String password) {
        // Authentication logic for students (e.g., checking against a student database)
        try (Connection connection = DriverManager.getConnection(getConnectionUrl());
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Student WHERE username=? AND password=?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getConnectionUrl() {
        return "jdbc:sqlserver://localhost:1433;databaseName=SDA_Lab;integratedSecurity=true;encrypt=false;";
    }
}

// Teacher class
class Teacher extends User {
    // Constructor
    public Teacher(String username, String password) {
        super(username, password);
    }

    // Override login method
    @Override
    public boolean login(String username, String password) {
        // Authentication logic for teachers (e.g., checking against a teacher database)
        try (Connection connection = DriverManager.getConnection(getConnectionUrl());
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Teacher WHERE username=? AND password=?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getConnectionUrl() {
        return "jdbc:sqlserver://localhost:1433;databaseName=SDA_Lab;integratedSecurity=true;encrypt=false;";
    }
}

// Singleton Database class
class Database {
    private static Database instance;

    // Private constructor to prevent instantiation from outside the class
    private Database() {
        // Load SQL Server JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to get the sole instance of the Database class
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Method to connect to the database
    private String getConnectionUrl() {
        return "jdbc:sqlserver://localhost:1433;databaseName=SDA_Lab;integratedSecurity=true;encrypt=false;";
    }
}

// Driver class for testing
public class l227971_Lab08_q3 {
    public static void main(String[] args) {
        // Test Database singleton
        Database database = Database.getInstance();

        // Test Student class
        Student student = new Student("student123", "password");
        boolean studentLoggedIn = student.login("student123", "password");
        System.out.println("Student logged in: " + studentLoggedIn);

        // Test Teacher class
        Teacher teacher = new Teacher("teacher456", "password");
        boolean teacherLoggedIn = teacher.login("teacher456", "password");
        System.out.println("Teacher logged in: " + teacherLoggedIn);
    }
}