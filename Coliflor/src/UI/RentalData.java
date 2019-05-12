package UI;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.BookRental.BookRental;
import ProductManager.Product.BookRental.BookUser;
import RentalSystemManager.Publication;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Date;

public class RentalData {

 //   public Book(double price, String description, boolean onRent, List<Review> reviews, int id, String bookTitle, int pageNo, String author, int publicationYear, String address, String preview, int point) {
  //    public BookPublication(Product product, Date publicationDate, boolean currentlyAvailable, int id, int bookNumber) {

    public ArrayList <Book> mainPageBook = new ArrayList<Book>();
    public ArrayList <BookPublication> bookPublication = new ArrayList<BookPublication>();
    public static BookRental bookRental;
    public ArrayList<BookUser> users  =  new ArrayList<BookUser>();



    public RentalData() {


        users.add(new BookUser("Cansu","cansu@email.com","Çayyolu, Ankara", "c",123, "p",  new Date(1997,12,24),null,null,null,null,null,null,0,null,null,0));
        mainPageBook.add(new Book(10, "Orphan Feride spends her school vacation" +
                " at her aunt's home, and falls for her sophisticated older cousin, Kamran.", false, null, 1, "LoveBird", 409, "Reşat Nuri Güntekin", 1922, "Çayyolu", "As a young child, Feride is orphaned and sent to live with her maternal aunt’s family. Her arrival upsets the delicate emotional balance of the household. Her female cousin Necmiye, particularly resents the attention her mother devotes to the new member of their household. Feride also has a combative relationship with her older male cousin Kamran which originates from a mutual attraction and distrust between them.", 10));
        mainPageBook.add(new Book(15, "Les Misérables is a French historical novel by Victor Hugo", false, null, 2, "Les Miserables", 1000, "Victor Hugo", 1862, "Konutkent", "The convict Jean Valjean is released from a French prison after serving nineteen years for stealing a loaf of bread and for subsequent attempts to escape from prison. When Valjean arrives at the town of Digne, no one is willing to give him shelter because he is an ex-convict. Desperate, Valjean knocks on the door of M. Myriel, the kindly bishop of Digne. Myriel treats Valjean with kindness, and Valjean repays the bishop by stealing his silverware. When the police arrest Valjean, Myriel covers for him, claiming that the silverware was a gift.", 20));
        mainPageBook.add(new Book(60, "The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien.", false, null, 3, "Lord of the Rings", 304, "J.R.R. Tolkien",2001,"Çukurambar","The future of civilization rests in the fate of the One Ring, which has been lost for centuries. Powerful forces are unrelenting in their search for it. But fate has placed it in the hands of a young Hobbit named Frodo Baggins (Elijah Wood), who inherits the Ring and steps into legend. A daunting task lies ahead for Frodo when he becomes the Ringbearer - to destroy the One Ring in the fires of Mount Doom where it was forged.", 10));
        mainPageBook.add(new Book(20, "Orphan Feride spends her school vacation" +
                " at her aunt's home, and falls for her sophisticated older cousin, Kamran.", false, null, 4, "Improbable", 409, "Reşat Nuri Güntekin", 1922, "Çayyolu", "As a young child, Feride is orphaned and sent to live with her maternal aunt’s family. Her arrival upsets the delicate emotional balance of the household. Her female cousin Necmiye, particularly resents the attention her mother devotes to the new member of their household. Feride also has a combative relationship with her older male cousin Kamran which originates from a mutual attraction and distrust between them.", 10));
        mainPageBook.add(new Book(25, "Les Misérables is a French historical novel by Victor Hugo", false, null, 5, "Hunger Games", 1000, "Victor Hugo", 1900, "Konutkent", "The convict Jean Valjean is released from a French prison after serving nineteen years for stealing a loaf of bread and for subsequent attempts to escape from prison. When Valjean arrives at the town of Digne, no one is willing to give him shelter because he is an ex-convict. Desperate, Valjean knocks on the door of M. Myriel, the kindly bishop of Digne. Myriel treats Valjean with kindness, and Valjean repays the bishop by stealing his silverware. When the police arrest Valjean, Myriel covers for him, claiming that the silverware was a gift.", 20));
        mainPageBook.add(new Book(30, "The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien.", false, null, 6, "War and Peace", 500, "J.R.R. Tolkien",2005,"Çukurambar","The future of civilization rests in the fate of the One Ring, which has been lost for centuries. Powerful forces are unrelenting in their search for it. But fate has placed it in the hands of a young Hobbit named Frodo Baggins (Elijah Wood), who inherits the Ring and steps into legend. A daunting task lies ahead for Frodo when he becomes the Ringbearer - to destroy the One Ring in the fires of Mount Doom where it was forged.", 10));

        bookPublication.add( new BookPublication(mainPageBook.get(0), mainPageBook.get(0).getBookTitle(),  new Date(), mainPageBook.get(0).isOnRent(), 1, 1));
        bookPublication.add( new BookPublication(mainPageBook.get(1), mainPageBook.get(1).getBookTitle(), new Date(), mainPageBook.get(1).isOnRent(), 2, 2));
        bookPublication.add( new BookPublication(mainPageBook.get(2), mainPageBook.get(2).getBookTitle(), new Date(), mainPageBook.get(2).isOnRent(), 3, 3));
        bookPublication.add( new BookPublication(mainPageBook.get(3), mainPageBook.get(3).getBookTitle(), new Date(), mainPageBook.get(3).isOnRent(), 4, 4));
        bookPublication.add( new BookPublication(mainPageBook.get(4), mainPageBook.get(4).getBookTitle(), new Date(), mainPageBook.get(4).isOnRent(), 5, 5));
        bookPublication.add( new BookPublication(mainPageBook.get(5), mainPageBook.get(5).getBookTitle(), new Date(), mainPageBook.get(5).isOnRent(), 6, 6));
        bookPublication.add( new BookPublication(mainPageBook.get(5), mainPageBook.get(5).getBookTitle(),new Date(), false, 7, 7));
        //users, publications, products, payments, contracts

        bookRental = new BookRental(
            users,
            bookPublication,
            mainPageBook,
            new ArrayList<>(),
            new ArrayList<>()
        );

    }


    public static BookUser returnUser(String username)
    {
        for(int i = 0; i < bookRental.getUsers().size(); i++)
        {
             if(bookRental.getUsers().get(i).getUsername().equals(username))
                 return bookRental.getUsers().get(i);
        }
        return null;
    }


    public static int returnBookID(String username)
    {
        for(int i = 0; i < bookRental.getProducts().size(); i++)
        {
            if(bookRental.getProducts().get(i).getBookTitle().equals(username))
                return bookRental.getProducts().get(i).getId();
        }
        return 0;
    }
}
