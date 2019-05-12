package UI;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.BookRental.BookRental;
import ProductManager.Product.BookRental.BookUser;
import ProductManager.Product.PlaceRental.Place;
import ProductManager.Product.PlaceRental.PlaceRental;
import ProductManager.Product.PlaceRental.PlaceUser;
import RentalSystemManager.Publication;

import java.util.ArrayList;
import java.util.Date;

public class RentalData {

 //   public Book(double price, String description, boolean onRent, List<Review> reviews, int id, String bookTitle, int pageNo, String author, int publicationYear, String address, String preview, int point) {
  //    public BookPublication(Product product, Date publicationDate, boolean currentlyAvailable, int id, int bookNumber) {

    public ArrayList <Book> mainPageBook = new ArrayList<Book>();
    public ArrayList<Place> mainPagePlace = new ArrayList<Place>();
    public ArrayList <BookPublication> bookPublication = new ArrayList<BookPublication>();
    public ArrayList <Publication> placePublication = new ArrayList<Publication>();
    public static BookRental bookRental;
    public static PlaceRental placeRental;
    public ArrayList<BookUser> users  =  new ArrayList<BookUser>();
    public ArrayList<PlaceUser> placeusers  =  new ArrayList<PlaceUser>();
    public ArrayList<String> offservices1 = new ArrayList<>();
    public ArrayList<String> transportation1 = new ArrayList<>();
    public ArrayList<String> offservices2 = new ArrayList<>();

    public RentalData() {


        users.add(new BookUser("Cansu","cansu@email.com","Çayyolu, Ankara", "c",123, "p",  new Date(1997,12,24),null,null,null,null,null,null,0,null,null,0));
        mainPageBook.add(new Book(10, "Orphan Feride spends her school vacation" +
                " at her aunt's home, and falls for her sophisticated older cousin, Kamran.", false, null, 1, "LoveBird", 409, "Reşat Nuri Güntekin", 1922, "Çayyolu", "As a young child, Feride is orphaned and sent to live with her maternal aunt’s family. Her arrival upsets the delicate emotional balance of the household. Her female cousin Necmiye, particularly resents the attention her mother devotes to the new member of their household. Feride also has a combative relationship with her older male cousin Kamran which originates from a mutual attraction and distrust between them.", 10));
        mainPageBook.add(new Book(15, "Les Misérables is a French historical novel by Victor Hugo", false, null, 2, "Lés Miserables", 1000, "Victor Hugo", 1862, "Konutkent", "The convict Jean Valjean is released from a French prison after serving nineteen years for stealing a loaf of bread and for subsequent attempts to escape from prison. When Valjean arrives at the town of Digne, no one is willing to give him shelter because he is an ex-convict. Desperate, Valjean knocks on the door of M. Myriel, the kindly bishop of Digne. Myriel treats Valjean with kindness, and Valjean repays the bishop by stealing his silverware. When the police arrest Valjean, Myriel covers for him, claiming that the silverware was a gift.", 20));
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

        offservices1.add("live music");
        offservices1.add("food");
        transportation1.add("bus");
        transportation1.add("taxi");
        offservices2.add("food");
        placeusers.add(new PlaceUser("Cansu","cansu@email.com","Çayyolu, Ankara", "c",123, "p",  new Date(1997,12,24),null,null,null,null,null));
        mainPagePlace.add(new Place(200,"happy birthday",false,null,1,"Umitkoy","PParty","", offservices1,null,transportation1,null,1000,7,null,true));
        mainPagePlace.add(new Place(500,"for meetings",false,null,2,"Oran","Meeting","", offservices1,null,transportation1,null,50,5,null,true));
        mainPagePlace.add(new Place(100,"best for baby shower",false,null,3,"Cayyolu","BabyShower","", offservices2,null,transportation1,null,70,6,null,true));
        mainPagePlace.add(new Place(700,"happy wedding",false,null,4,"Tunali","Wedding","", offservices1,null,transportation1,null,5000,9,null,true));
        placePublication.add(new Publication(mainPagePlace.get(0),mainPagePlace.get(0).getPlaceName(),new Date(),mainPagePlace.get(0).isOnRent(),1));
        placePublication.add(new Publication(mainPagePlace.get(1),mainPagePlace.get(1).getPlaceName(),new Date(),mainPagePlace.get(1).isOnRent(),2));
        placePublication.add(new Publication(mainPagePlace.get(2),mainPagePlace.get(2).getPlaceName(),new Date(),mainPagePlace.get(2).isOnRent(),3));
        placePublication.add(new Publication(mainPagePlace.get(3),mainPagePlace.get(3).getPlaceName(),new Date(),mainPagePlace.get(3).isOnRent(),4));

        placeRental = new PlaceRental(
                placeusers,
                placePublication,
                mainPagePlace,
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

    public static PlaceUser returnPlaceUser(String username)
    {
        for(int i = 0; i < placeRental.getUsers().size(); i++)
        {
            if(placeRental.getUsers().get(i).getUsername().equals(username))
                return placeRental.getUsers().get(i);
        }
        return null;
    }
}
