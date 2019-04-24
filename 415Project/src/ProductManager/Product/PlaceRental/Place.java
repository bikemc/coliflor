package ProductManager.Product.PlaceRental;

import RentalSystemManager.Product;
import RentalSystemManager.Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 24.04.2019.
 */
<<<<<<< HEAD
public class Place extends Product {
=======
public class Place extends Product{
>>>>>>> denizsen
    String location, placeName, view3DURL;
    ArrayList<String> services, purpose,
                      transportationOptions, photoURLs;
    int capacity;
    double rating;
    ArrayList<Date> schedule;
    boolean currentAvailability;

<<<<<<< HEAD
    public Place(double price, String description, boolean onRent, List<Review> reviews, String location, String placeName, String view3DURL, ArrayList<String> services, ArrayList<String> purpose, ArrayList<String> transportationOptions, ArrayList<String> photoURLs, int capacity, double rating, ArrayList<Date> schedule, boolean currentAvailability) {
=======
    public Place(double price, String description, boolean onRent,
                 List<Review> reviews, String location, String placeName,
                 String view3DURL, ArrayList<String> services,
                 ArrayList<String> purpose, ArrayList<String> transportationOptions,
                 ArrayList<String> photoURLs, int capacity, double rating,
                 ArrayList<Date> schedule, boolean currentAvailability) {
>>>>>>> denizsen
        super(price, description, onRent, reviews);
        this.location = location;
        this.placeName = placeName;
        this.view3DURL = view3DURL;
        this.services = services;
        this.purpose = purpose;
        this.transportationOptions = transportationOptions;
        this.photoURLs = photoURLs;
        this.capacity = capacity;
        this.rating = rating;
        this.schedule = schedule;
        this.currentAvailability = currentAvailability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getView3DURL() {
        return view3DURL;
    }

    public void setView3DURL(String view3DURL) {
        this.view3DURL = view3DURL;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }

    public ArrayList<String> getPurpose() {
        return purpose;
    }

    public void setPurpose(ArrayList<String> purpose) {
        this.purpose = purpose;
    }

    public ArrayList<String> getTransportationOptions() {
        return transportationOptions;
    }

    public void setTransportationOptions(ArrayList<String> transportationOptions) {
        this.transportationOptions = transportationOptions;
    }

    public ArrayList<String> getPhotoURLs() {
        return photoURLs;
    }

    public void setPhotoURLs(ArrayList<String> photoURLs) {
        this.photoURLs = photoURLs;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public boolean isCurrentAvailability() {
        return currentAvailability;
    }

    public void setCurrentAvailability(boolean currentAvailability) {
        this.currentAvailability = currentAvailability;
    }
}
