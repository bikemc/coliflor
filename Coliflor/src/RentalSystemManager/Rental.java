package RentalSystemManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by pc on 24.04.2019.
 */
public class Rental<ProductT extends Product, UserT extends User, PublicationT extends Publication, ContractT extends Contract> implements Filter {

    protected ArrayList<UserT> users;
    protected ArrayList<PublicationT> publications;
    protected ArrayList<ProductT> products;
    protected ArrayList<Payment> payments;
    protected ArrayList<ContractT> contracts;
    public UserT currentUser = null;
    public static final String FILTER_DESCRPTION = "desc";


    public Rental(ArrayList<UserT> users, ArrayList<PublicationT> publications, ArrayList<ProductT> products, ArrayList<Payment> payments, ArrayList<ContractT> contracts) {
        this.users = users;
        this.products = products;
        this.publications = publications;
        this.payments = payments;
        this.contracts = contracts;
   }

    public UserT getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserT currentUser) {
        this.currentUser = currentUser;
    }

    public boolean login(String username, String password){
        for(int i=0; i<users.size(); i++){
            if((users.get(i)).getUsername().equals(username) && (users.get(i)).getPassword().equals(password)){
                currentUser = users.get(i);
                return true;
            }
        }
        return false;
    }

    public boolean signup(String username, String email, String address, String password, Date birth, String name, long phoneNo){
        for(int i=0; i<users.size(); i++){
            if((users.get(i)).getUsername().equals(username))
                return false;
        }

        return true;
    }

    public void logout(UserT user){
        if(currentUser != null) {
            currentUser = null;
        }
    }

    public ArrayList<PublicationT> searchPublication(String searchKey){
        ArrayList<PublicationT> searchResult = new ArrayList<>();
        for(int i=0; i<publications.size(); i++){

            if((publications.get(i)).getProduct().getDescription().contains(searchKey)){
                searchResult.add(publications.get(i));
            }
        }
        return searchResult;
    }

    public boolean sendMessage(String messageContent){
        if(currentUser != null) {
            currentUser.sendMessage(messageContent);
            return true;
        }
        return false;
    }

    public ArrayList<ProductT> searchProduct(String searchKey, String username){
        ArrayList<ProductT> searchResult = new ArrayList<>();
        for(int i=0; i<products.size(); i++){
            if((products.get(i)).getDescription().contains(searchKey)){
                searchResult.add(products.get(i));
            }
        }
        return searchResult;
    }

    public boolean rent(UserT user, PublicationT publication,Date startDate, Date endDate){ // paymentı niye döndürüyo paymentı pay de yapıyoz nasıl erişelim
        if(currentUser != null) {
            for (int i = 0; i < publications.size(); i++) {
                if(publications.get(i).equals( publication)) {
                    if (request((publications.get(i)).getProduct())){
                        (publications.get(i)).setCurrentlyAvailable(false);
                        (publications.get(i)).getProduct().setOnRent(true);
                        if (pay(publications.get(i),startDate, endDate)){
                            currentUser.getRentalHistory().add( publications.get(i));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void changeAccountInformation(String name, String password, Date birthDay, long phone){
        if(currentUser != null) {
            currentUser.setName(name);
            currentUser.setPassword(password);
            currentUser.setBirthday(birthDay);
            currentUser.setPhoneNumber(phone);
        }
    }

    public boolean request(Product product){
        if(currentUser != null) {
            for (int i = 0; i < publications.size(); i++) {
                if((publications.get(i)).getProduct().equals( product ) && !((publications.get(i)).getProduct().isOnRent()) && ((publications.get(i)).isCurrentlyAvailable())){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pay(PublicationT publication, Date startDate, Date endDate){
        // user gereksiz
        if(currentUser != null) {
            if(checkCreaditCardInformation(8,null,null,0,0,0)) {
                if(makeContract( publication,startDate,endDate) != null) {
                    Payment pay = new Payment(currentUser,  publication);
                    (currentUser).getPayments().add(pay);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCreaditCardInformation(long cardNo, String cardName, String cardSurname, int cardVerificationNo, int cardDueDat, int cardDueMonth){
        return new Random().nextBoolean();
    }

    public Contract makeContract(Publication publication,Date startDate, Date endDate, Object... contractTypes) {
        return null;
    }
    // getters and setters
    public ArrayList<UserT> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserT> users) {
        this.users = users;
    }

    public ArrayList<PublicationT> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<PublicationT> publications) {
        this.publications = publications;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<ContractT> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<ContractT> contracts) {
        this.contracts = contracts;
    }



    @Override
    public ArrayList<PublicationT> filter(String filterType,Object...  filterOptions) {
        return null;
    }
}
