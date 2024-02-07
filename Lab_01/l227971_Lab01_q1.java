public class l227971_Lab01_q1 {
    public static void main(String[] args) {
        // Example usage
        Student student = new Student("Hasan Yahya", 20, "Software Engineering", "None of your Buisness!");
        student.showDetails();
    }
}

class Student {
    // Private variables
    private String name;
    private int age;
    private String degree;
    // public variables
    public String nationality;

    // Constructor
    public Student(String name, int age, String degree, String nationality) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.nationality = nationality;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDegree() {
        return degree;
    }

    public String getNationality() {
        return nationality;
    }

    // Public method to show student details
    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Degree: " + degree);
        System.out.println("Nationality: " + nationality);
    }
}
