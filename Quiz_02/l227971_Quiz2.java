import java.util.List;
import java.util.ArrayList;

interface Employee {
    String getName();
    String getRole();
    void displayDetails();
}

class Individual implements Employee {
    private String name;
    private String role;

    public Individual(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void displayDetails() {
        System.out.println("Displaying details for Individual Contributor: ");
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
    }
}

class Manager implements Employee {
    private String name;
    private String role;
    private List<Employee> employees;

    public Manager(String name, String role) {
        this.name = name;
        this.role = role;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Employees managed by manager:");
        for (Employee employee : employees) {
            System.out.println("---------------------------------");
            employee.displayDetails();
            System.out.println("---------------------------------");
        }
    }
}

public class l227971_Quiz2 {
    public static void main(String[] args) {
        Employee hasan = new IndividualContributor("Hasan", "Developer");
        Employee rehan = new IndividualContributor("Rehan", "Animator");

        Manager wasee = new Manager("Wasee Rehman", "Manager");
        wasee.addEmployee(hasan);
        wasee.addEmployee(rehan);

        Employee ali = new IndividualContributor("Ali Imran", "Developer");
        Employee abdullah = new IndividualContributor("Abdullah Khalid", "Designer");

        Manager huzaifa = new Manager("Huzaifa Kashif", "Manager");
        huzaifa.addEmployee(ali);
        huzaifa.addEmployee(abdullah);
        huzaifa.addEmployee(rehan);

        huzaifa.displayDetails();
    }
}