package PlaceRental;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class Place {
    String location, placeName, view3DURL;
    ArrayList<String> services, purpose,
                      transportationOptions, photoURLs;
    int capacity;
    double rating;
    ArrayList<Date> schedule;
    boolean currentAvailability;

    public Place(String location, String placeName, String view3DURL,
                 ArrayList<String> services, ArrayList<String> purpose,
                 ArrayList<String> transportationOptions, ArrayList<String> photoURLs,
                 int capacity, double rating, ArrayList<Date> schedule,
                 boolean currentAvailability) {
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
}
