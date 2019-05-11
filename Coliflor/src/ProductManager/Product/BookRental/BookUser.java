package ProductManager.Product.BookRental;

import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookUser extends User {

    private ArrayList<Book> rentedBooks;
    private double fund;
    private List<Book> booksToRead;
    private List<Book> wishList;
    private int point;

    public BookUser(String name, String email, String address, String username, long phoneNumber, String password, Date birthday, ArrayList<Message> messages, ArrayList<Publication> rentalHistory, ArrayList<Publication> searchHistory, ArrayList<Review> reviews, ArrayList<Payment> payments, ArrayList<Book> rentedBooks, double fund, List<Book> booksToRead, List<Book> wishList, int point) {
        super(name, email, address, username, phoneNumber, password, birthday, messages, rentalHistory, searchHistory, reviews, payments);
        this.rentedBooks = rentedBooks;
        this.fund = fund;
        this.booksToRead = booksToRead;
        this.wishList = wishList;
        this.point = point;
    }

    public ArrayList<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(ArrayList<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public List<Book> getBooksToRead() {
        return booksToRead;
    }

    public void setBooksToRead(List<Book> booksToRead) {
        this.booksToRead = booksToRead;
    }

    public List<Book> getWishList() {
        return wishList;
    }

    public void setWishList(List<Book> wishList) {
        this.wishList = wishList;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
