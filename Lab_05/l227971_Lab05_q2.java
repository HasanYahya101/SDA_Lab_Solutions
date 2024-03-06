import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Abstract class representing a generic library item
abstract class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Abstract method to display item details
    public abstract void displayDetails();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

// Subclass representing a Book
class Book extends LibraryItem {
    private int numberOfPages;

    public Book(String title, String author, int publicationYear, int numberOfPages) {
        super(title, author, publicationYear);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Number of Pages: " + numberOfPages);
    }
}

// Subclass representing a Magazine
class Magazine extends LibraryItem {
    private String issue;

    public Magazine(String title, String author, int publicationYear, String issue) {
        super(title, author, publicationYear);
        this.issue = issue;
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Issue: " + issue);
    }
}

// Subclass representing a DVD
class DVD extends LibraryItem {
    private String director;

    public DVD(String title, String director, int publicationYear) {
        super(title, "", publicationYear); // No author for DVDs
        this.director = director;
    }

    @Override
    public void displayDetails() {
        System.out.println("DVD Title: " + getTitle());
        System.out.println("Director: " + director);
        System.out.println("Publication Year: " + getPublicationYear());
    }
}

// Interface for fine calculation
interface FineCalculator {
    double calculateFine(LocalDate dueDate, LocalDate returnDate);
}

// Standard fine calculator implementation
class StandardFineCalculator implements FineCalculator {
    private static final double STANDARD_FINE_RATE = 0.50; // I choose this at random

    @Override
    public double calculateFine(LocalDate dueDate, LocalDate returnDate) {
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        if (daysLate <= 0) {
            return 0;
        }
        return daysLate * STANDARD_FINE_RATE;
    }
}

// Reduced fine calculator implementation
class ReducedFineCalculator implements FineCalculator {
    private static final double REDUCED_FINE_RATE = 0.25; // Reduced fine rate per day

    @Override
    public double calculateFine(LocalDate dueDate, LocalDate returnDate) {
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        if (daysLate <= 0) {
            return 0;
        }
        return daysLate * REDUCED_FINE_RATE;
    }
}

public class l227971_Lab05_q2 {
    public static void main(String[] args) {
        // Hardcoding the Example main
        Book book = new Book("Intro to Java", "Hasan Yahya (Me)", 2022, 100);
        Magazine magazine = new Magazine("C++ Coding", "Wasee Rehman", 2023, "March");
        DVD dvd = new DVD("Random", "Random", 2024);

        book.displayDetails();
        System.out.println();

        magazine.displayDetails();
        System.out.println();

        dvd.displayDetails();
        System.out.println();

        // Example of fine calculation
        StandardFineCalculator standardFineCalculator = new StandardFineCalculator();
        ReducedFineCalculator reducedFineCalculator = new ReducedFineCalculator();

        LocalDate dueDate = LocalDate.of(2024, 3, 1);
        LocalDate returnDate = LocalDate.of(2024, 3, 10);

        double standardFine = standardFineCalculator.calculateFine(dueDate, returnDate);
        double reducedFine = reducedFineCalculator.calculateFine(dueDate, returnDate);

        System.out.println("Standard Fine: $" + standardFine);
        System.out.println("Reduced Fine: $" + reducedFine);
    }
}
