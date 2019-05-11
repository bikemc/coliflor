package RentalSystemManager;

import java.util.List;

public abstract class Product {
    private String title;
    private double price;
    private String description;
    private boolean onRent;
    private List<Review> reviews;
    protected int id;

    public Product(double price, String description, boolean onRent, List<Review> reviews, int id) {
        this.price = price;
        this.description = description;
        this.onRent = onRent;
        this.reviews = reviews;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Product p){
        return this.id == p.getId();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
