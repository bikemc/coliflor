package BookRental;

import java.util.ArrayList;
import java.util.List;

public class BookUser {

    private ArrayList<Book> rentedBooks;
    private double fund;
    private List<Book> booksToRead;
    private List<Book> wishList;
    private int point;

    public BookUser(ArrayList<Book> rentedBooks, double fund, List<Book> booksToRead, List<Book> wishList, int point) {
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
