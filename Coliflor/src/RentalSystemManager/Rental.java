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

    public Rental(ArrayList<User> users, ArrayList<Publication> publications, ArrayList<Payment> payments, ArrayList<Contract> contracts) {
        this.users = users;
        this.publications = publications;
        this.payments = payments;
        this.contracts = contracts;
    }

    public boolean login(String username, String password){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)){
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
}
