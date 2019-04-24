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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnRent() {
        return onRent;
    }

    public void setOnRent(boolean onRent) {
        this.onRent = onRent;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
