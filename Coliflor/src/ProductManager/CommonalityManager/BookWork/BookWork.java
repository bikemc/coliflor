package ProductManager.CommonalityManager.BookWork;

import RentalSystemManager.Product;
import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.util.ArrayList;

public interface BookWork {
    public ArrayList<Publication> giveRecommendation();
    public String meetingLocation (Product p);
}
