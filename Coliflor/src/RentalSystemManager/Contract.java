package RentalSystemManager;
import java.util.Date;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
}
