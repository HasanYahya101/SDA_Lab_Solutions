import java.util.Scanner;

abstract class OrderTemplate {
    public final void calculateTotalCost() {
        double totalPrice = calculateTotalPrice();
        totalPrice = applyDiscount(totalPrice);
        totalPrice = addTaxes(totalPrice);
        System.out.println("Total Cost: $" + totalPrice);
    }

    protected abstract double calculateTotalPrice();

    protected abstract double applyDiscount(double totalPrice);

    protected abstract double addTaxes(double totalPrice);
}

class OnlineOrder extends OrderTemplate {
    @Override
    protected double calculateTotalPrice() {
        // Calculate total price including shipping costs
        double totalPrice = 0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total price: ");
        totalPrice = sc.nextDouble();
        while (totalPrice < 0) {
            System.out.println("Please enter a positive price: ");
            totalPrice = sc.nextDouble();
        }
        // close scanner
        sc.close();
        return totalPrice;
    }

    @Override
    protected double applyDiscount(double totalPrice) {
        double discount;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the discount percentage: ");
        discount = sc.nextDouble();
        while (discount < 0) {
            System.out.println("Please enter a positive discount: ");
            discount = sc.nextDouble();
        }
        totalPrice -= totalPrice * discount / 100;
        sc.close();
        return totalPrice;
    }

    @Override
    protected double addTaxes(double totalPrice) {
        double tax;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the tax percentage: ");
        tax = sc.nextDouble();
        while (tax < 0) {
            System.out.println("Please enter a positive tax: ");
            tax = sc.nextDouble();
        }
        totalPrice += totalPrice * tax / 100;
        sc.close();
        return totalPrice;
    }
}

class InStoreOrder extends OrderTemplate {
    @Override
    protected double calculateTotalPrice() {
        // Calculate total price without shipping costs
        double totalPrice = 0.0;
        // Add logic to calculate total price for in-store order
        return totalPrice;
    }

    @Override
    protected double applyDiscount(double totalPrice) {
        int discounts;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the discount amount: ");
        discounts = sc.nextInt();
        while (discounts < 0) {
            System.out.println("Please enter a positive discount: ");
            discounts = sc.nextInt();
        }
        totalPrice -= discounts;
        // close scanner
        sc.close();
        return totalPrice;
    }

    @Override
    protected double addTaxes(double totalPrice) {
        int add_amount;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to add as taxes: ");
        add_amount = sc.nextInt();
        while (add_amount < 0) {
            System.out.println("Please enter a positive amount: ");
            add_amount = sc.nextInt();
        }
        totalPrice += add_amount;
        // close scanner
        sc.close();
        return totalPrice;
    }
}

public class l227971_Lab11_q1 {
    public static void main(String[] args) {
        OrderTemplate onlineOrder = new OnlineOrder();
        onlineOrder.calculateTotalCost();

        OrderTemplate inStoreOrder = new InStoreOrder();
        inStoreOrder.calculateTotalCost();
    }
}