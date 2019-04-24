package ProductManager.Product.WorkLaborRental;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private int age, experiencedYears;
    private ArrayList<String> occupation;
    private String address, employeeName;
    private double rating;
    private ArrayList<Date> schedule;

    public Employee(int age, int experiencedYears, ArrayList<String> occupation, String address, String employeeName, double rating, ArrayList<Date> schedule) {
        this.age = age;
        this.experiencedYears = experiencedYears;
        this.occupation = occupation;
        this.address = address;
        this.employeeName = employeeName;
        this.rating = rating;
        this.schedule = schedule;
    }
}
