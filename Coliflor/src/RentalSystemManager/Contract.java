package RentalSystemManager;
import java.util.Date;

import java.util.Date;

<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> parent of 67a9b08... merge
public abstract class Contract {
    private User user;
    private Publication publication;
    private Date startDate;
    private Date endDate;

    public Contract(User user, Publication publication, Date startDate, Date endDate) {
        this.user = user;
        this.publication = publication;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
