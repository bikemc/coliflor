package ProductManager.Product.PlaceRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import ProductManager.Product.WorkLaborRental.WorkLaborRental;
import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class PlaceRental extends Rental<Place, PlaceUser, Publication, PlaceRentalContract>  implements BookPlace, WorkPlace<Place>{

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
    public boolean signup(String username, String email, String address, String password, Date birth, String name, long phoneNo) {
        if(super.signup(username, email, address, password, birth, name, phoneNo)) {
            PlaceUser newUser = new PlaceUser(name,email, address,username, phoneNo, password, birth, null, null, null, null, null);
            users.add(newUser);
            currentUser = newUser; // konuşalım grupça
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Place> listPositivelyRated() {
        ArrayList<Place> positivelyRated = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            positivelyRated.add((Place) products.get(i));
        }
        Collections.sort(positivelyRated);
        return positivelyRated;
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
    public ArrayList<Place> listNegativelyRated() {
        ArrayList<Place> negativelyRated = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            negativelyRated.add((Place) products.get(i));
        }
        Collections.sort( negativelyRated);
        Collections.reverse( negativelyRated);
        return  negativelyRated;
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
    public ArrayList<Place> searchProduct(String searchKey) {
        ArrayList<Place> searchResult = new ArrayList<>();
        for(int i=0; i<publications.size(); i++){
            if(((Place)publications.get(i).getProduct()).getPlaceName().contains(searchKey)){
                searchResult.add(products.get(i));
                if(currentUser.getSearchHistory()== null) currentUser.setSearchHistory(new ArrayList<Publication>());
                currentUser.getSearchHistory().add(publications.get(i));
            }
        }
        return searchResult;
    }


    @Override
    public Contract makeContract(Publication publication,Date startDate, Date endDate, Object... contractTypes) {

        PlaceRentalContract contract= new PlaceRentalContract(currentUser,publication, startDate,endDate,(int)contractTypes[0]);
        return contract;
    }
}
