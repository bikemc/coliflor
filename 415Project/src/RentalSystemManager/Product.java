package RentalSystemManager;

import java.util.List;

public abstract class Product {
    private double price;
    private String description;
    private boolean onRent;
    private List<Review> reviews;

    public Product(double price, String description, boolean onRent, List<Review> reviews) {
        this.price = price;
        this.description = description;
        this.onRent = onRent;
        this.reviews = reviews;
    }
    
}
