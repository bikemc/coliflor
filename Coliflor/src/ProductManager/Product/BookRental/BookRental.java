package ProductManager.Product.BookRental;

import ProductManager.CommonalityManager.BookPlace.BookPlace;
import ProductManager.CommonalityManager.BookWork.BookWork;
import RentalSystemManager.*;

import java.util.*;

public class BookRental extends Rental implements BookWork, BookPlace {
    private ArrayList<BookUser> users;
    private ArrayList<BookPublication> publications;
    private ArrayList<Book> products;
    private BookUser currentUser;


    protected ArrayList<BookRentalContract> contracts;

    public static final String PAGE_FILTER = "page";
    public static final String TITLE_FILTER = "title";
    public static final String AUTHOR_FILTER = "author";
    public static final String PUBLICATION_YEAR_FILTER = "publication year";
    public static final String PREVIEW_FILTER = "preview";

    public BookRental(ArrayList<BookUser> users, ArrayList<BookPublication> publications, ArrayList<Book> products, ArrayList<BookRentalContract> contracts) {
        this.users = users;
        this.publications = publications;
        this.products = products;
        this.contracts = contracts;
    }

    public void addFund(double amount){
        if(currentUser!= null){
            currentUser.setFund(((BookUser)currentUser).getFund()+ amount);
        }
    }
    public boolean penaltyPayment(BookPublication publication, Date endDate){
        Date currentDate = new Date();
        int dayDifference= (int)( (currentDate.getTime() - endDate.getTime()) / (1000 * 60 * 60 * 24));
        double amount= publication.getBookRentalContract().getPenaltyPerDay()* dayDifference;
        if(((BookUser)currentUser).getFund() >= amount){
            ((BookUser)currentUser).setFund(((BookUser)currentUser).getFund()- amount);
            return true;
        }
        return false;
    }

    public ArrayList<BookPublication> listMostRented(){
        ArrayList<BookPublication> mostRented= new ArrayList<>();
        for (int i = 0; i < publications.size(); i++) {
            mostRented.add((BookPublication) publications.get(i));
        }
        Collections.sort(mostRented);
        return mostRented;
    }

    @Override
    public String meetingLocation (User user, Product book){
        if(currentUser.getAddress().equals(((Book)book).getAddress()))  {
            return currentUser.getAddress();
        }
        return null;
    }

    @Override
    public ArrayList<Publication> giveRecommendation() {
        Random rand = new Random();
        ArrayList<Publication> recomendationList= new ArrayList<>();
        int randomIndex = rand.nextInt(publications.size());
        for (int i=0; i < randomIndex; i++){
            recomendationList.add(publications.get(rand.nextInt(publications.size())));
        }
        return recomendationList;
    }

    @Override
    public boolean shareInSocialMedia(Publication publication, String socialMedia) {
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

    public boolean rent(User user, Publication publication, Date startDate, Date endDate) {
        if( super.rent(currentUser, publications, publication, startDate, endDate)) {
            ((BookUser) currentUser).setPoint(((BookUser) currentUser).getPoint() + ((Book) publication.getProduct()).getPoint());
            ((BookPublication)publication).setRentNumber(((BookPublication)publication).getRentNumber() + 1);
            return true;
        }
        return false;
    }

    public Date getReturnDate(BookRentalContract rentalContract){
        return ((Contract)rentalContract).getEndDate();

    }
    @Override
    public ArrayList<Publication> filter(String filterType, Object... filterOptions) {
        ArrayList<Publication> searchResult = new ArrayList<>();
        switch (filterType){
            case FILTER_DESCRPTION:
                searchResult =  searchPublication((String)filterOptions[0]);
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


    public boolean login(String username, String password) {
        return super.login(username, password, this.users, this.currentUser);
    }


    public boolean signup(String username, String email, String address, String password, Date birth, String name, long phoneNo) {
        if(super.signup(this.users, this.currentUser, username, email, address, password, birth, name, phoneNo)) {
            BookUser newUser = new BookUser(name,email, address,username, phoneNo, password, birth, null, null, null, null, null, null, 0, null, null,0);
            users.add(newUser);
            currentUser = newUser; // konuşalım grupça
            return true;
        }
        return false;
    }


    public void logout() {
        super.logout(this.currentUser);
    }


    public ArrayList<Publication> searchPublication(String searchKey) {
        return super.searchPublication(searchKey, this.publications);
    }


    public boolean sendMessage(String messageContent) {
        return super.sendMessage(this.currentUser, messageContent);
    }

    public ArrayList<Product> searchProduct(String searchKey) {
        return super.searchProduct(searchKey, this.products);
    }


    public void changeAccountInformation(String name, String password, Date birthDay, long phone, String username) {
        super.changeAccountInformation(this.currentUser, name, password, birthDay, phone, username);
    }

    public boolean request( Product product) {
        return super.request(this.currentUser, product, this.publications);
    }


    public boolean pay( Publication publication, Date startDate, Date endDate) {
        return super.pay(this.currentUser, publication, startDate, endDate);
    }

    @Override
    public boolean checkCreaditCardInformation(long cardNo, String cardName, String cardSurname, int cardVerificationNo, int cardDueDat, int cardDueMonth) {
        return super.checkCreaditCardInformation(cardNo, cardName, cardSurname, cardVerificationNo, cardDueDat, cardDueMonth);
    }

    public ArrayList<BookUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<BookUser> users) {
        this.users = users;
    }

    public ArrayList<BookPublication> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<BookPublication> publications) {
        this.publications = publications;
    }

    public ArrayList<Book> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Book> products) {
        this.products = products;
    }

    public BookUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(BookUser currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<BookRentalContract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<BookRentalContract> contracts) {
        this.contracts = contracts;
    }
}
