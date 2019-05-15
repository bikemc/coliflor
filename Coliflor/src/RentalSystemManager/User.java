package RentalSystemManager;
import java.io.Serializable;
import java.util.*;


public class User implements Serializable {

    //Variables
    private String name;
    private String email;
    private String address;
    private String username;
    private long phoneNumber;
    private String password;
    private Date birthday;

    private ArrayList<Message> messages;
    private ArrayList<Publication> rentalHistory;
    private ArrayList<Publication> searchHistory;
    private ArrayList<Review> reviews;
    private ArrayList<Payment> payments;

    //Constructor
    public User(String name, String email, String address, String username, long phoneNumber, String password, Date birthday, ArrayList<Message> messages, ArrayList<Publication> rentalHistory, ArrayList<Publication> searchHistory, ArrayList<Review> reviews, ArrayList<Payment> payments) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.birthday = birthday;
        this.messages = messages;
        this.rentalHistory = rentalHistory;
        this.searchHistory = searchHistory;
        this.reviews = reviews;
        this.payments = payments;
    }

    public <T extends User> T createUser(Object... t) {

        return null;
    }


    //Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Publication> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(ArrayList<Publication> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public ArrayList<Publication> getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(ArrayList<Publication> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public void sendMessage(String messageContent)
    {
        if (messages == null) messages = new ArrayList<>();
        Date currentDate = new Date();
        Message newMessage = new Message(currentDate, this, messageContent);
        messages.add(newMessage);
    }
}
