package ProductManager.Product.PlaceRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class PlaceRental extends Rental<Place, PlaceUser, Publication, PlaceRentalContract>  implements BookPlace, WorkPlace{

    public PlaceRental(ArrayList<PlaceUser> users, ArrayList<Publication> publications, ArrayList<Place> products, ArrayList<Payment> payments, ArrayList<PlaceRentalContract> contracts) {
        super(users, publications, products, payments, contracts);
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
                searchResult =  super.searchPublication((String)filterOptions[0]);
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

    @Override
    public boolean shareInSocialMedia(Publication publication, String socialMedia) {
        return true;
    }

    @Override
    public ArrayList<Product> listPositivelyRated() {
        ArrayList<Place> positivelyRated = new ArrayList<>();
        ArrayList<Product> positivelyRatedProduct = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            positivelyRated.add((Place) products.get(i));
        }
        Collections.sort(positivelyRated);
        for (int i = 0; i < positivelyRated.size(); i++) {
            positivelyRatedProduct.add((Product)positivelyRated.get(i));
        }
        return positivelyRatedProduct;
    }

    @Override
    public boolean checkAvailability(Publication publication, Date date) {
        ArrayList<Date> schedule=((Place)publication.getProduct()).getSchedule();
        for(int i=0; i<schedule.size(); i++){
            if(schedule.get(i).equals(date)){
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Product> listNegativelyRated() {
        ArrayList<Place> negativelyRated = new ArrayList<>();
        ArrayList<Product>  negativelyRatedProduct = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            negativelyRated.add((Place) products.get(i));
        }
        Collections.sort( negativelyRated);
        Collections.reverse( negativelyRated);
        for (int i = 0; i <  negativelyRated.size(); i++) {
            negativelyRatedProduct.add((Product) negativelyRated.get(i));
        }
        return  negativelyRatedProduct;
    }

    @Override
    public ArrayList<Date> checkSchedule(Publication publication) {
        return ((Place)publication.getProduct()).getSchedule() ;
    }

    @Override
    public boolean payDeposit(User user, Publication publication) {
        if(currentUser != null) {
            if(checkCreaditCardInformation(8,null,null,0,0,0)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Contract makeContract(Publication publication,Date startDate, Date endDate, Object... contractTypes) {

        PlaceRentalContract contract= new PlaceRentalContract(currentUser,publication, startDate,endDate,(int)contractTypes[0]);
        return contract;
    }
}
