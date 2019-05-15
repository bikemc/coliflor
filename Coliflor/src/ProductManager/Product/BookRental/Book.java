package ProductManager.Product.BookRental;

import RentalSystemManager.Product;
import RentalSystemManager.Review;

import java.util.ArrayList;
import java.util.List;

public class Book extends Product {
    private String bookTitle;
    private int pageNo;
    private String author;
    private int publicationYear;
    private String address;
    private String preview;
    private int point;
    private String imageURL;

    enum GENRES{
        NOVEL, SCIENCEFICTION, DRAMA, ACTION, BIOGRAPHY, COMICS
    }

    public Book(double price, String description, boolean onRent, ArrayList<Review> reviews, int id, String bookTitle, int pageNo, String author, int publicationYear, String address, String preview, int point) {
        super(price, description, onRent, reviews, id);
        this.bookTitle = bookTitle;
        this.pageNo = pageNo;
        this.author = author;
        this.publicationYear = publicationYear;
        this.address = address;
        this.preview = preview;
        this.point = point;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
