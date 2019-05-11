package ProductManager.Product.WorkLaborRental;

import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;

public class WorkLaborUser extends User {
    
    public WorkLaborUser(String name, String email, String address, String username, long phoneNumber, String password, Date birthday, ArrayList<Message> messages, ArrayList<Publication> rentalHistory, ArrayList<Publication> searchHistory, ArrayList<Review> reviews, ArrayList<Payment> payments) {
        super(name, email, address, username, phoneNumber, password, birthday, messages, rentalHistory, searchHistory, reviews, payments);
    }

}
