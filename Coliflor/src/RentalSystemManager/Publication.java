package RentalSystemManager;

import java.util.Date;

public class Publication {
    private Product product;
    private Date publicationDate;
    private String title;
    private boolean currentlyAvailable;
    int id;

    public Publication(Product product, Date publicationDate, boolean currentlyAvailable, int id) {
        this.product = product;
        this.publicationDate = publicationDate;
        this.currentlyAvailable = currentlyAvailable;
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isCurrentlyAvailable() {
        return currentlyAvailable;
    }

    public void setCurrentlyAvailable(boolean currentlyAvailable) {
        this.currentlyAvailable = currentlyAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Publication publication){
        return this.id == publication.getId();
    }

}
