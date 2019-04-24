package ProductManager.Product.PlaceRental;

import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class PlaceUser extends User{

    public PlaceUser(String name, String email, String address, String username, long phoneNumber, String password, Date birthday, ArrayList<Message> messages, ArrayList<Publication> rentalHistory, ArrayList<Publication> searchHistory, ArrayList<Review> reviews, ArrayList<Payment> payments) {
        super(name, email, address, username, phoneNumber, password, birthday, messages, rentalHistory, searchHistory, reviews, payments);
    }


}
