package RentalSystemManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by pc on 24.04.2019.
 */
public class Rental implements Filter {

    protected ArrayList<User> users;
    protected ArrayList<Publication> publications;
    protected ArrayList<Product> products;
    protected ArrayList<Payment> payments;
    protected ArrayList<Contract> contracts;
    public static User currentUser = null;


    public Rental(ArrayList<User> users, ArrayList<Publication> publications, ArrayList<Payment> payments, ArrayList<Contract> contracts) {
        this.users = users;
        this.publications = publications;
        this.payments = payments;
        this.contracts = contracts;
   }

    public boolean login(String username, String password){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)){
                currentUser = users.get(i);
                return true;
            }
        }
        return false;
    }

    public boolean signup(String username, String email, String address, String password, Date birth, String name, long phoneNo){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getName().equals(username))
                return false;
        }
        User newUser = new User(name,email,address,username,phoneNo,password,birth,null,null,null,null,null);
        users.add(newUser);
        currentUser = newUser; // konuşalım grupça
        return true;
    }

    public void logout(User user){
        if(currentUser != null) {
            currentUser = null;
        }
    }

    public ArrayList<Publication> searchPublication(String searchKey, String userName){ // user gereksiz bence
        ArrayList<Publication> searchResult = new ArrayList<>();
        for(int i=0; i<publications.size(); i++){
            if(publications.get(i).getProduct().getDescription().contains(searchKey)){
                searchResult.add(publications.get(i));
            }
        }
        return searchResult;
    }

    public boolean sendMessage(User user, String messageContent){ // user gereksiz bence
        if(currentUser != null) {
            currentUser.sendMessage(messageContent);
            return true;
        }
        return false;
    }

    public ArrayList<Product> searchProduct(String searchKey, String username){
        ArrayList<Product> searchResult = new ArrayList<Product>();
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getDescription().contains(searchKey)){
                searchResult.add(products.get(i));
            }
        }
        return searchResult;
    }

    public boolean rent(User user, Publication publication){ // paymentı niye döndürüyo paymentı pay de yapıyoz nasıl erişelim
        if(currentUser != null) {
            for (int i = 0; i < publications.size(); i++) {
                if(publications.get(i).equals( publication)) {
                    if (request(currentUser,publications.get(i).getProduct())){
                        publications.get(i).setCurrentlyAvailable(false);
                        publications.get(i).getProduct().setOnRent(true);
                        if (pay(currentUser,publications.get(i))){
                            currentUser.getRentalHistory().add(publications.get(i));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void changeAccountInformation(String name, String password, Date birthDay, long phone, String username){ // username e gerek yok
        if(currentUser != null) {
            currentUser.setName(name);
            currentUser.setPassword(password);
            currentUser.setBirthday(birthDay);
            currentUser.setPhoneNumber(phone);
        }
    }

    public boolean request(User user, Product product){
        if(currentUser != null) {
            for (int i = 0; i < publications.size(); i++) {
                if(publications.get(i).getProduct().equals( product ) && !(publications.get(i).getProduct().isOnRent()) && (publications.get(i).isCurrentlyAvailable())){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pay(User user, Publication publication){
        // user gereksiz
        if(currentUser != null) {
            if(checkCreaditCardInformation(8,null,null,0,0,0)) {
                Payment pay = new Payment(currentUser, publication);
                currentUser.getPayments().add(pay);
                return true;
            }
        }
        return false;
    }

    public boolean checkCreaditCardInformation(long cardNo, String carName, String cardSurname, int cardVerificationNo, int cardDueDat, int cardDueMonth){
        return new Random().nextBoolean();
    }

    // getters and setters
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public static final String FILTER_DESCRPTION = "desc";

    @Override
    public ArrayList<Publication> filter(String filterType,Object...  filterOptions) {


        return null;
    }
}
