package RentalSystemManager;

import java.util.Date;

public class Offer {
    private Publication publication;
    private Date startDate;
    private Date endDate;
    private User user;

    public Offer(Publication publication, Date startDate, Date endDate, User user) {
        this.publication = publication;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }
}
