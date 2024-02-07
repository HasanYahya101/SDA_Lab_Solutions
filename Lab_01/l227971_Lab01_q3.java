import java.util.ArrayList;
import java.util.List;

// Base class Employee
abstract class Employee {
    protected String name;
    protected int employee_id;

    // Constructor
    public Employee(String name, int employee_id) {
        this.name = name;
        this.employee_id = employee_id;
    }

    // Abstract method to calculate salary
    public abstract float calculate_salary();
}

// Derived class HourlyEmployee
class HourlyEmployee extends Employee {
    private float hourly_rate;
    private float hours_worked;

    // Constructor
    public HourlyEmployee(String name, int employee_id, float hourly_rate, float hours_worked) {
        super(name, employee_id);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
    }

    // Override calculate_salary method
    @Override
    public float calculate_salary() {
        return hourly_rate * hours_worked;
    }
}

// Derived class SalariedEmployee
class SalariedEmployee extends Employee {
    private float monthly_salary;

    // Constructor
    public SalariedEmployee(String name, int employee_id, float monthly_salary) {
        super(name, employee_id);
        this.monthly_salary = monthly_salary;
    }

    // Override calculate_salary method
    @Override
    public float calculate_salary() {
        return monthly_salary;
    }
}

// Derived class CommissionedEmployee
class CommissionedEmployee extends Employee {
    private float base_salary;
    private float commission_rate;
    private float sales_amount;

    // Constructor
    public CommissionedEmployee(String name, int employee_id, float base_salary, float commission_rate,
            float sales_amount) {
        super(name, employee_id);
        this.base_salary = base_salary;
        this.commission_rate = commission_rate;
        this.sales_amount = sales_amount;
    }

    // Override calculate_salary method
    @Override
    public float calculate_salary() {
        return base_salary + (commission_rate * sales_amount);
    }
}

public class l227971_Lab01_q3 {
    // Function to display employee information
    public static void display_employee_information(List<Employee> employees) {
        System.out.println("Employee Information:");
        for (Employee emp : employees) {
            System.out.println("Name: " + emp.name);
            System.out.println("ID: " + emp.employee_id);
            System.out.println("Monthly Salary: $" + emp.calculate_salary());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating instances of each type of employee
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Hasan", 101, 15.50f, 160);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Yahya", 102, 3000);
        CommissionedEmployee commissionedEmployee = new CommissionedEmployee("Commisioned Person", 103, 2000, 0.1f,
                50000);

        // Adding employees to a list
        List<Employee> employees = new ArrayList<>();
        employees.add(hourlyEmployee);
        employees.add(salariedEmployee);
        employees.add(commissionedEmployee);

        // Calling display_employee_information function
        display_employee_information(employees);
    }
}
