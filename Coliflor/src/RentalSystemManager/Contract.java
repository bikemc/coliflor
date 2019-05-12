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
