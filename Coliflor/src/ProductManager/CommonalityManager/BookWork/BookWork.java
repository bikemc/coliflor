package ProductManager.CommonalityManager.BookWork;

import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.util.ArrayList;

public interface BookWork {
    public ArrayList<Publication> giveRecommendation(User user);
}
