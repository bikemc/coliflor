package ProductManager.Product.WorkLaborRental;
import RentalSystemManager.Product;
import RentalSystemManager.Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Product {
    private int age, experiencedYears;
    private ArrayList<String> occupation;
    private String address, employeeName;
    private double rating;
    private ArrayList<Date> schedule;

    public Employee(double price, String description, boolean onRent, List<Review> reviews, int age, int experiencedYears, ArrayList<String> occupation, String address, String employeeName, double rating, ArrayList<Date> schedule) {
        super(price, description, onRent, reviews);
        this.age = age;
        this.experiencedYears = experiencedYears;
        this.occupation = occupation;
        this.address = address;
        this.employeeName = employeeName;
        this.rating = rating;
        this.schedule = schedule;
    }

}
