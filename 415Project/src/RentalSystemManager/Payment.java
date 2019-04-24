package RentalSystemManager;

public class Payment {
    private User user;
    private Publication publication;

    public Payment(User user, Publication publication) {
        this.user = user;
        this.publication = publication;
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



}
