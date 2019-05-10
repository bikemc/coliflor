package ProductManager.Product.PlaceRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class PlaceRental extends Rental implements BookPlace, WorkPlace{

    public PlaceRental(ArrayList<User> users, ArrayList<Publication> publications, ArrayList<Payment> payments, ArrayList<Contract> contracts) {
        super(users, publications, payments, contracts);
    }

    public String getWeatherCondition(Place place, Date rentalDate){
        String[] weathers = {"Rainy", "Stormy", "Sunny", "Cloudy", "Windy", "Sand-storms", "Sand-storms", "Hurricanes"};
        int rand = (int)(Math.random() * 10);
        return weathers[rand];
    }

    public static final String PLACE_FILTER_LOCATION = "location";
    public static final String PLACE_FILTER_SERVICES = "services";
    public static final String PLACE_FILTER_PURPOSES = "purposes";
    public static final String PLACE_FILTER_TRASPORTATION = "transportation";

    @Override
    public ArrayList<Publication> filter(String filterType, Object... filterOptions) {

        ArrayList<Publication> searchResult = new ArrayList<Publication>();
        switch (filterType){
            case FILTER_DESCRPTION:
                searchResult =  super.searchPublication((String)filterOptions[0], "");
            break;

            case PLACE_FILTER_LOCATION:
                for(int i=0; i<publications.size(); i++){
                    if(((Place)publications.get(i).getProduct()).getLocation().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
             break;
            case PLACE_FILTER_SERVICES:
                for(int i=0; i<publications.size(); i++){
                    if(((Place)publications.get(i).getProduct()).getServices().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case PLACE_FILTER_PURPOSES:
                for(int i=0; i<publications.size(); i++){
                    if(((Place)publications.get(i).getProduct()).getPurpose().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
            case PLACE_FILTER_TRASPORTATION:
                for(int i=0; i<publications.size(); i++){
                    if(((Place)publications.get(i).getProduct()).getTransportationOptions().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            default:
                break;
        }
        return searchResult;
        }

        /*
        * location, placeName, view3DURL;
    ArrayList<String> services, purpose,
                      transportationOptions*/



    @Override
    public void shareInSocialMedia(User user, Publication publication, String socialMedia) {

    }

    @Override
    public ArrayList<Publication> listPositivelyRated() {
        return null;
    }

    @Override
    public boolean checkCurrentAvailability(Publication publication, Date currentDate) {
        return false;
    }

    @Override
    public ArrayList<Publication> listNegativelyRated() {
        return null;
    }

    @Override
    public ArrayList<Date> checkSchedule(Publication publication) {
        return null;
    }

    @Override
    public boolean payDeposit(User user, Publication publication) {
        return false;
    }



}
