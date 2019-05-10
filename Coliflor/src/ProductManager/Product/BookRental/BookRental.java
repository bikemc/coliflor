package ProductManager.Product.BookRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.BookWork.BookWork;
import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookRental extends Rental implements BookWork, BookPlace {

    public BookRental(ArrayList<User> users, ArrayList<Publication> publications, ArrayList<Payment> payments, ArrayList<Contract> contracts) {
        super(users, publications, payments, contracts);
    }

    public static void addFund(BookUser user, double amount){
        user.setFund(user.getFund()+ amount);
    }
    public static boolean penaltyPayment(BookUser user, BookPublication publication){

        return true;
    }
    public static List<Book> listMostRented(){
        // rent sayılarını tutmuyoruz
        return null;
    }

    @Override
    public ArrayList<Publication> giveRecommendation(User user) {
        return null;
    }

    @Override
    public void shareInSocialMedia(User user, Publication publication, String socialMedia) {

    }

    @Override
    public boolean checkCurrentAvailability(Publication publication, Date currentDate) {
        if(publication.getProduct().isOnRent()){
            return false;
        }
        return true;
    }

    public static final String PAGE_FILTER = "ajsdkasjdkl";
    public static final String TITLE_FILTER = "dsfsdfajsdkasjdkl";



    @Override
    public ArrayList<Publication> filter(String filterType, Object... filterOptions) {
        ArrayList<Publication> searchResult = new ArrayList<>();
        switch (filterType){
            case FILTER_DESCRPTION:
                searchResult =  super.searchPublication((String)filterOptions[0], "");
                break;
            case PAGE_FILTER:
                int lowerBound = (int)filterOptions[0];
                break;
            case TITLE_FILTER:
                break;

        }

        return searchResult;
    }
}
