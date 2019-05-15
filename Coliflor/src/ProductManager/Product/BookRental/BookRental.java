package ProductManager.Product.BookRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.BookWork.BookWork;
import RentalSystemManager.*;

import java.util.*;

public class BookRental extends Rental<Book, BookUser, BookPublication, BookRentalContract> implements BookWork, BookPlace {

    public static final String PAGE_FILTER = "page";
    public static final String TITLE_FILTER = "title";
    public static final String AUTHOR_FILTER = "author";
    public static final String PUBLICATION_YEAR_FILTER = "publication year";
    public static final String PREVIEW_FILTER = "preview";

    public BookRental(ArrayList<BookUser> users, ArrayList<BookPublication> publications, ArrayList<Book> products, ArrayList<Payment> payments, ArrayList<BookRentalContract> contracts) {
        super(users, publications, products, payments, contracts);
    }

    public boolean addFund(double amount){
        if(currentUser!= null){
            if(checkCreaditCardInformation(8,null,null,0,0,0)) {
                    currentUser.setFund((currentUser).getFund()+ amount);
                    return true;
                }
            }
        return false;
    }
    public boolean addToWishlist(Book book){
        if(currentUser!= null){
            if(currentUser.getWishList()== null) currentUser.setWishList(new ArrayList<Book>());
                currentUser.getWishList().add(book);
                return true;
        }
        return false;
    }
    public  boolean penaltyPayment(BookPublication publication, Date endDate){
        Date currentDate = new Date();
        int dayDifference= (int)( (currentDate.getTime() - endDate.getTime()) / (1000 * 60 * 60 * 24));
        double amount= ((BookRentalContract)publication.getContract()).getPenaltyPerDay()* dayDifference;
        if((currentUser).getFund() >= amount){
            (currentUser).setFund((currentUser).getFund()- amount);
            return true;
        }
        return false;
    }

    public ArrayList<BookPublication> listMostRented(){
        Collections.sort(publications);
        return publications;
    }
    public Date getReturnDate(BookPublication publication){
        return  ((BookRentalContract)publication.getContract()).getEndDate();
    }
    public BookRentalContract getTurnOverContract(BookPublication publication){
        return ((BookRentalContract)publication.getContract());
    }

    @Override
    public String meetingLocation (Product book){
        if(currentUser != null) {
            if(currentUser.getAddress().equals(((Book)book).getAddress()))  {
                return currentUser.getAddress();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Publication> giveRecommendation() {
        if(currentUser != null) {
            Random rand = new Random();
            ArrayList<Publication> recomendationList = new ArrayList<>();
            int randomIndex = rand.nextInt(publications.size());
            for (int i = 0; i < randomIndex; i++) {
                recomendationList.add(publications.get(rand.nextInt(publications.size())));
            }
            return recomendationList;
        }
        return null;
    }

    @Override
    public boolean shareInSocialMedia(Publication publication, String socialMedia) {
        return true;
    }

    @Override
    public boolean checkAvailability(Publication publication, Date currentDate) {
        for (Publication item: publications){
            if(item.equals(publication)){
                if(!(publication.getProduct().isOnRent()) && item.isCurrentlyAvailable()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean signup(String name, String username, String email,String password, String address, long phoneNo, Date birth) {
        if(super.signup(name, username, email,password, address,phoneNo, birth)) {
            BookUser newUser = new BookUser(name,email, address,username, phoneNo, password, birth, null, null, null, null, null, null, 0, null, null,0);
            users.add(newUser);
            currentUser = newUser; // konuşalım grupça
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(BookPublication publication, Date startDate, Date endDate) {
        if(currentUser != null) {
            if(currentUser.getFund() >= publication.getProduct().getPrice()) {
                if(makeContract( publication,startDate,endDate,1.0, false) != null) {
                    System.out.println("publication "+publication.getTitle());
                    Payment pay = new Payment(currentUser,  publication);
                    if(currentUser.getPayments()== null) currentUser.setPayments(new ArrayList<Payment>());
                        currentUser.getPayments().add(pay);
                        currentUser.setFund(currentUser.getFund()- publication.getProduct().getPrice());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Contract makeContract(Publication publication, Date startDate, Date endDate,Object... contractTypes) {
       BookRentalContract contract= new BookRentalContract(currentUser,publication,startDate,endDate, (double)contractTypes[0],  (boolean)contractTypes[1]);
        return contract;
    }

    @Override
    public boolean rent(BookUser user, BookPublication publication, Date startDate, Date endDate) {
        if( super.rent(user, publication, startDate, endDate)) {
            currentUser.setPoint(currentUser.getPoint() + ((Book) publication.getProduct()).getPoint());
            publication.setRentNumber(publication.getRentNumber()+1);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Book> searchProduct(String searchKey) {
        ArrayList<Book> searchResult = new ArrayList<>();
        for(int i=0; i<publications.size(); i++){
            if(((Book)publications.get(i).getProduct()).getBookTitle().contains(searchKey)){
                searchResult.add(products.get(i));
                if(currentUser.getSearchHistory()== null) currentUser.setSearchHistory(new ArrayList<Publication>());
                currentUser.getSearchHistory().add(publications.get(i));
            }
        }
        return searchResult;
    }

    @Override
    public ArrayList<BookPublication> filter(String filterType, Object... filterOptions) {
        ArrayList<BookPublication> searchResult = new ArrayList<>();
        switch (filterType){
            case FILTER_DESCRPTION:
                searchResult =  super.searchPublication((String)filterOptions[0]);
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
