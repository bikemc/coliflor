package RentalSystemManager;

import java.util.Date;

public class Publication {
    private Product product;
    private Date publicationDate;
    private boolean currentlyAvailable;
    int id;

    public Publication(Product product, Date publicationDate, boolean currentlyAvailable, int id) {
        this.product = product;
        this.publicationDate = publicationDate;
        this.currentlyAvailable = currentlyAvailable;
        this.id = id;
    }
}
