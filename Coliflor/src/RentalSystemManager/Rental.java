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


    protected ArrayList<Payment> payments;
    public static final String FILTER_DESCRPTION = "desc";


    public Rental() {

    }

    public boolean login(String username, String password, ArrayList<? extends User> users, User currentUser){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
                currentUser = users.get(i);
                return true;
            }
        }
        return false;
    }

    public boolean signup(ArrayList<? extends User> users, User currentUser, String username, String email, String address, String password, Date birth, String name, long phoneNo){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(username))
                return false;
        }
        return true;
    }

    public void logout(User currentUser){
        if(currentUser != null) {
            currentUser = null;
        }
    }

    public ArrayList<Publication> searchPublication(String searchKey, ArrayList<? extends Publication> publications){ // user gereksiz bence
        ArrayList<Publication> searchResult = new ArrayList<>();
        for(int i=0; i<publications.size(); i++){
            if(publications.get(i).getProduct().getDescription().contains(searchKey)){
                searchResult.add(publications.get(i));
            }
        }
        return searchResult;
    }

    public boolean sendMessage(User currentUser, String messageContent){ // user gereksiz bence
        if(currentUser != null) {
            currentUser.sendMessage(messageContent);
            return true;
        }
        return false;
    }

    public ArrayList<Product> searchProduct(String searchKey, ArrayList<? extends Product> products){
        ArrayList<Product> searchResult = new ArrayList<Product>();
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getDescription().contains(searchKey)){
                searchResult.add(products.get(i));
            }
        }
        return searchResult;
    }

    public boolean rent(User currentUser,ArrayList<? extends Publication> publications, Publication publication,Date startDate, Date endDate){ // paymentı niye döndürüyo paymentı pay de yapıyoz nasıl erişelim
        if(currentUser != null) {
            for (int i = 0; i < publications.size(); i++) {
                if(publications.get(i).equals( publication)) {
                    if (request(currentUser,publications.get(i).getProduct(), publications)){
                        publications.get(i).setCurrentlyAvailable(false);
                        publications.get(i).getProduct().setOnRent(true);
                        if (pay(currentUser,publications.get(i),startDate, endDate)){
                            currentUser.getRentalHistory().add(publications.get(i));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void changeAccountInformation(User currentUser, String name, String password, Date birthDay, long phone, String username){ // username e gerek yok
        if(currentUser != null) {
            currentUser.setName(name);
            currentUser.setPassword(password);
            currentUser.setBirthday(birthDay);
            currentUser.setPhoneNumber(phone);
        }
    }

    public boolean request(User currentUser, Product product,ArrayList<? extends Publication> publications){
        if(currentUser != null) {
            for (int i = 0; i < publications.size(); i++) {
                if(publications.get(i).getProduct().equals( product ) && !(publications.get(i).getProduct().isOnRent()) && (publications.get(i).isCurrentlyAvailable())){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pay(User currentUser, Publication publication, Date startDate, Date endDate){
        // user gereksiz
        if(currentUser != null) {
            if(checkCreaditCardInformation(8,null,null,0,0,0)) {
                if(makeContract(publication,startDate,endDate) != null) {
                    Payment pay = new Payment(currentUser, publication);
                    currentUser.getPayments().add(pay);
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

    @Override
    public ArrayList<Publication> filter(String filterType,Object...  filterOptions) {
        return null;
    }
}
