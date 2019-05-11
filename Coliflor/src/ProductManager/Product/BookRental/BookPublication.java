package ProductManager.Product.BookRental;

import RentalSystemManager.Product;
import RentalSystemManager.Publication;

import java.util.Date;

public class BookPublication extends Publication implements Comparable<Publication> {
    private int bookNumber;
    private int rentNumber;
    private BookRentalContract bookRentalContract;

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

    public BookRentalContract getBookRentalContract() {
        return bookRentalContract;
    }

    public void setBookRentalContract(BookRentalContract bookRentalContract) {
        this.bookRentalContract = bookRentalContract;
    }

    public int getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(int rentNumber) {
        this.rentNumber = rentNumber;
    }
    public int compareTo(Publication o) {
        return (int)(this.rentNumber- ((BookPublication)o).getRentNumber());
    }
}

