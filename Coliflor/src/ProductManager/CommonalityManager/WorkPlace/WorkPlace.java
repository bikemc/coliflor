package ProductManager.CommonalityManager.WorkPlace;

import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public interface WorkPlace {
    public ArrayList<Publication> listPositivelyRated();
    public ArrayList<Publication> listNegativelyRated();
    public ArrayList<Date> checkSchedule(Publication publication);
    public boolean payDeposit(User user, Publication publication);
}
