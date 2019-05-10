package ProductManager.Product.BookRental;

import RentalSystemManager.Product;
import RentalSystemManager.Publication;

import java.util.Date;

public class BookPublication extends Publication {
    private int bookNumber;

    public BookPublication(Product product, Date publicationDate, boolean currentlyAvailable, int id, int bookNumber) {
        super(product, publicationDate, currentlyAvailable, id);
        this.bookNumber = bookNumber;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public Product getProduct() {
        return super.getProduct();
    }

    @Override
    public void setProduct(Product product) {
        super.setProduct(product);
    }
}

