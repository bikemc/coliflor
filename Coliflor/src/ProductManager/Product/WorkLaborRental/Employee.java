package ProductManager.Product.WorkLaborRental;
import RentalSystemManager.Product;
import RentalSystemManager.Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Product implements Comparable<Product>{
    private int age, experiencedYears;
    private ArrayList<String> occupation;
    private String address, employeeName;
    private double rating;
    private ArrayList<Date> schedule;

    public Employee(double price, String description, boolean onRent, List<Review> reviews, int id, int age, int experiencedYears, ArrayList<String> occupation, String address, String employeeName, double rating, ArrayList<Date> schedule) {
        super(price, description, onRent, reviews, id);
        this.age = age;
        this.experiencedYears = experiencedYears;
        this.occupation = occupation;
        this.address = address;
        this.employeeName = employeeName;
        this.rating = rating;
        this.schedule = schedule;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperiencedYears() {
        return experiencedYears;
    }

    public void setExperiencedYears(int experiencedYears) {
        this.experiencedYears = experiencedYears;
    }

    public ArrayList<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(ArrayList<String> occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Date> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Date> schedule) {
        this.schedule = schedule;
    }
    @Override
    public int compareTo(Product o) {
        return (int)(this.rating - ((Employee)o).getRating());
    }
}
