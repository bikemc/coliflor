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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
