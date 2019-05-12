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
import javafx.scene.image.Image;
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

    public Publication publication;

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

        bookPublicationData = new RentalData();
        ArrayList<BookPublication> pubs = RentalData.bookRental.getPublications();
        // summaryText.setText(publication.getProduct().getDescription());
        BufferedReader Buff = null;
        try {
            Buff = new BufferedReader(new FileReader("../bookname.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            savedBookID2 =  Buff.readLine();
            System.out.println(savedBookID2);
            if(isStringInt(savedBookID2)) //????
               savedBookID =  parseInt(savedBookID2);
            else
                savedBookID = RentalData.returnBookID(savedBookID2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        nameBook.setText(((Book)pubs.get(savedBookID).getProduct()).getBookTitle());
        priceBook.setText(pubs.get(savedBookID).getProduct().getPrice() + "TL");
        summaryBook.setText(pubs.get(savedBookID).getProduct().getDescription());

        if(savedBookID == 1)
             bookImage.setImage(new Image("UI/Images/calıkusu.jpg"));
        else if(savedBookID == 2)
            bookImage.setImage(new Image("UI/Images/sefiller.jpg"));
        else if(savedBookID == 3)
            bookImage.setImage(new Image("UI/Images/lordofrings.jpg"));
        else if(savedBookID == 4)
            bookImage.setImage(new Image("UI/Images/imprpb.jpg"));
        else if(savedBookID == 5)
            bookImage.setImage(new Image("UI/Images/hungergames.jpg"));
        else if(savedBookID == 6)
            bookImage.setImage(new Image("UI/Images/warandpeace.jpg"));
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


}
