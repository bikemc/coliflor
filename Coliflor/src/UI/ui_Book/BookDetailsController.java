package UI.ui_Book;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import RentalSystemManager.Publication;
import RentalSystemManager.Rental;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class BookDetailsController implements Initializable {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book, ui_book_result, ui_book_rent;

    public static Publication publication;

    @FXML
    private Text nameBook, priceBook, summaryBook;
    @FXML
    private javafx.scene.image.ImageView bookImage;

    @FXML
    private Text summaryText;

    private  int savedBookID;
    private  String savedBookID2;
    private RentalData bookData, bookPublicationData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("sss " + savedBookID);
        nameBook.setText(((Book)publication.getProduct()).getBookTitle());
        priceBook.setText(publication.getProduct().getPrice() + "TL");
        summaryBook.setText(publication.getProduct().getDescription());
        //nameBook.setText(bookPublicationData.mainPageBook.get(savedBookID-1).getBookTitle());

        if(savedBookID == 1)
             ((Book) publication.getProduct()).setImageURL("UI/Images/calıkusu.jpg");
        else if(savedBookID == 2)
            ((Book) publication.getProduct()).setImageURL("UI/Images/sefiller.jpg");
        else if(savedBookID == 3)
            ((Book) publication.getProduct()).setImageURL("UI/Images/lordofrings.jpg");
        else if(savedBookID == 4)
            ((Book) publication.getProduct()).setImageURL("UI/Images/imrpb.jpg");
        else if(savedBookID == 5)
            ((Book) publication.getProduct()).setImageURL("UI/Images/hungergames.jpg");
        else if(savedBookID == 6)
            ((Book) publication.getProduct()).setImageURL("UI/Images/warandpeace.jpg");
    }

    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backBookMainPage(ActionEvent event) throws Exception
    {
        ui_Book = initializeScene("ui_Book.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Book);
    }

    public void backBookResultsPage(ActionEvent event) throws Exception
    {
        ui_book_result = initializeScene("ui_book_results.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_result);
    }


    public void openBookRentPage(ActionEvent event) throws Exception
    {
        ui_book_rent = initializeScene("ui_book_rent.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_rent);
    }

    public void viewReviews(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Reviews")), 300,200));
        secondStage.show();
    }
    public void turnOverContract(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
        Parent root = (Parent)loader.load();

        Label label1;
        BookDetailsController bookDetailsController = loader.getController();
        bookDetailsController.publication = RentalData.bookRental.getPublications().get(0);
        secondStage.setScene(new Scene(new HBox(300, new Label("    Turn Over Contract")), 300,200));
        secondStage.show();
    }

    public void addtoWishlist(ActionEvent event) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
        Parent root = (Parent)loader.load();

        Label label1;
        BookDetailsController bookDetailsController = loader.getController();
        bookDetailsController.publication = RentalData.bookRental.getPublications().get(0);
        Stage secondStage = new Stage();
        RentalData.bookRental.addToWishlist((Book)bookDetailsController.publication.getProduct());
        secondStage.setScene(new Scene(new HBox(300, new Label(RentalData.bookRental.getPublications().get(0).getTitle()+ "    Added to the wishlist")), 300,200));
        secondStage.show();
    }
    public void shareSocialMedia(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Shared on Social Media")), 300,200));
        secondStage.show();
    }





}
