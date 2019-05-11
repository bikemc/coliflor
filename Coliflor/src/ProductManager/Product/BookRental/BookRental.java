package ProductManager.Product.BookRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.BookWork.BookWork;
import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BookRental extends Rental implements BookWork, BookPlace {

    public static final String PAGE_FILTER = "page";
    public static final String TITLE_FILTER = "title";
    public static final String AUTHOR_FILTER = "author";
    public static final String PUBLICATION_YEAR_FILTER = "publication year";
    public static final String PREVIEW_FILTER = "preview";

    public BookRental(ArrayList<User> users, ArrayList<Publication> publications, ArrayList<Payment> payments, ArrayList<Contract> contracts) {
        super(users, publications, payments, contracts);
    }
    public static void addFund(BookUser user, double amount){
        user.setFund(((BookUser)currentUser).getFund()+ amount);
    }
    public static boolean penaltyPayment(BookUser user, BookPublication publication, Date endDate){
        Date currentDate = new Date();
        int dayDifference= (int)( (currentDate.getTime() - endDate.getTime()) / (1000 * 60 * 60 * 24));
        double amount= publication.getBookRentalContract().getPenaltyPerDay()* dayDifference;
        if(((BookUser)currentUser).getFund() >= amount){
            ((BookUser)currentUser).setFund(((BookUser)currentUser).getFund()- amount);
            return true;
        }
        return false;
    }

    public static List<Book> listMostRented(){
        // rent sayılarını tutmuyoruz
        return null;
    }

    @Override
    public String meetingLocation (User user, Product book){
        if(currentUser.getAddress().equals(((Book)book).getAddress()))  {
            return currentUser.getAddress();
        }
        return null;
    }

    @Override
    public ArrayList<Publication> giveRecommendation(User user) {
        Random rand = new Random();
        ArrayList<Publication> recomendationList= new ArrayList<>();
        int randomIndex = rand.nextInt(publications.size());
        for (int i=0; i < randomIndex; i++){
            recomendationList.add(publications.get(rand.nextInt(publications.size())));
        }
        return recomendationList;
    }

    @Override
    public boolean shareInSocialMedia(User user, Publication publication, String socialMedia) {
        return true;
    }

    @Override
    public boolean checkAvailability(Publication publication, Date currentDate) {
        if(publication.getProduct().isOnRent()){
            return false;
        }
        return true;
    }

    @Override
    public Contract makeContract(Publication publication, Date startDate, Date endDate,Object... contractTypes) {
       BookRentalContract contract= new BookRentalContract(currentUser,publication,startDate,endDate, (double)contractTypes[0],  (boolean)contractTypes[1]);
        return contract;
    }

    @Override
    public boolean rent(User user, Publication publication, Date startDate, Date endDate) {
        if( super.rent(user, publication, startDate, endDate)) {
            ((BookUser) currentUser).setPoint(((BookUser) currentUser).getPoint() + ((Book) publication.getProduct()).getPoint());
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Publication> filter(String filterType, Object... filterOptions) {
        ArrayList<Publication> searchResult = new ArrayList<>();
        switch (filterType){
            case FILTER_DESCRPTION:
                searchResult =  super.searchPublication((String)filterOptions[0], "");
                break;
            case PAGE_FILTER:
                int lowerBound = (int)filterOptions[0];
                int upperBound = (int)filterOptions[1];
                for (int i = 0; i < publications.size(); i++){
                   if(((Book)publications.get(i).getProduct()).getPageNo() > lowerBound && ((Book)publications.get(i).getProduct()).getPageNo() < upperBound) {
                       searchResult.add(publications.get(i));
                   }
                }
                break;
            case TITLE_FILTER:
                for(int i=0; i<publications.size(); i++){
                    if(((Book)publications.get(i).getProduct()).getBookTitle().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case AUTHOR_FILTER:
                for(int i=0; i<publications.size(); i++){
                    if(((Book)publications.get(i).getProduct()).getAuthor().equals((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case PUBLICATION_YEAR_FILTER:
                for(int i=0; i<publications.size(); i++){
                    if(((Book)publications.get(i).getProduct()).getPublicationYear()== (int)filterOptions[0]){
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case PREVIEW_FILTER:
                for(int i=0; i<publications.size(); i++){
                    if(((Book)publications.get(i).getProduct()).getPreview().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;

        }
        return searchResult;
    }
}
