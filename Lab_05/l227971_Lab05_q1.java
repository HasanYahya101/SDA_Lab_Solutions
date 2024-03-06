import java.util.ArrayList;
import java.util.List;

// Product class representing a product available for purchase
class Product {
    private String name;
    private double price;
    private int availability;

    // Constructor
    public Product(String name, double price, int availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}

// ShoppingCart class responsible for managing the user's shopping cart
class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void removeProduct(Product product) {
        cartItems.remove(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : cartItems) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
    }
}

// OrderProcessor class responsible for processing orders placed by users
class OrderProcessor {

    public boolean validateOrder(ShoppingCart cart) {
        return true;
    }

    public void updateProductAvailability(ShoppingCart cart) {
        // Update product availability
        for (Product product : cart.getCartItems()) {
            product.setAvailability(product.getAvailability() - 1);
        }
    }

    public void generateOrderReceipt(ShoppingCart cart) {
        System.out.println("Order Receipt:");
        for (Product product : cart.getCartItems()) {
            System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice());
        }
        System.out.println("Total Price: " + cart.calculateTotalPrice());
    }
}

public class l227971_Lab05_q1 {
    public static void main(String[] args) {
        // Creating some products
        Product product1 = new Product("Java Book", 10.0, 5);
        Product product2 = new Product("Fast Nuces Student Book", 1000.0, 10);

        // Creating a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Adding products to the cart
        cart.addProduct(product1);
        cart.addProduct(product2);

        // Creating an order processor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Validating and processing the order
        if (orderProcessor.validateOrder(cart)) {
            cart.placeOrder();
            orderProcessor.updateProductAvailability(cart);
            orderProcessor.generateOrderReceipt(cart);
        } else {
            System.out.println("Order validation failed. Please try again.");
        }
    }
}
