package ProductManager.Product.PlaceRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import RentalSystemManager.Filter;
import RentalSystemManager.Publication;
import RentalSystemManager.Rental;
import RentalSystemManager.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class PlaceRental extends Rental implements BookPlace, WorkPlace, Filter{

    public String getWeatherCondition(Place place, Date rentalDate){

        return null;
    }

    @Override
    public void shareInSocialMedia(User user, Publication publication, String socialMedia) {

    }

    @Override
    public boolean checkCurrentAvailability(Publication publication, Date currentDate) {
        return false;
    }

    @Override
    public ArrayList<Publication> listPositivelyRated() {
        return null;
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

    @Override
    public ArrayList<Publication> filter(String filterType, String filterOptions) {
        return null;
    }
}
