package RentalSystemManager;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class Rental {

    private ArrayList<User> users;
    private ArrayList<Publication> publications;
    private ArrayList<Payment> payments;
    private ArrayList<Contract> contracts;

    public boolean login(String username, String password){
        return true;
    }

    public boolean signup(String username, String password, String name, long phoneNo){
        return true;
    }

    public void logout(User user){

    }

    public ArrayList<Publication> searchPublication(String searchKey, String userName){
        return null;
    }

    public void sendMessage(User user, String messageContent){

    }

    public ArrayList<Product> searchProduct(String searchKey, String username){
        return null;
    }

    public Payment rent(User user, Publication publication){
        return null;
    }

    public void changeAccountInformation(String name, String password, Date birthDay, long phone, String username){

    }

    public void request(User user, Product product){

    }

    public boolean pay(User user, Publication publication){
        return true;
    }

    public boolean checkCreaditCardInformation(long cardNo, String carName, String cardSurname, int cardVerificationNo, int cardDueDat, int cardDueMonth){
        return false;
    }
}
