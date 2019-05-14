package UI.ui_Book;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import UI.RentalData;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainBookController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_BookSearch;
    private Scene ui_book_login_signup, ui_book_account;
    private RentalData bookData, bookPublicationData;
    private Scene ui_book_details;


    private String currentUsername;
    @FXML
    private Text firstName, firstPrice, secondName, secondPrice, thirdName, thirdPrice, forthName, forthPrice, fifthName, fifthPrice, sixthName, sixthPrice;

    @FXML
    private Text currentUser;

    @FXML
    private ImageView calikusu, sefiller,yuzuklerinefendisi, olasiliksiz, aclikoyunlari, savasvebaris;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<BookPublication> pubs = RentalData.bookRental.getPublications();
        firstName.setText(((Book)(pubs.get(0).getProduct())).getBookTitle());
        secondName.setText(((Book)(pubs.get(1).getProduct())).getBookTitle());
        thirdName.setText(((Book)(pubs.get(2).getProduct())).getBookTitle());
        forthName.setText(((Book)(pubs.get(3).getProduct())).getBookTitle());
        fifthName.setText(((Book)(pubs.get(4).getProduct())).getBookTitle());
        sixthName.setText(((Book)(pubs.get(5).getProduct())).getBookTitle());

        firstPrice.setText(pubs.get(0).getProduct().getPrice() + "TL");
        secondPrice.setText(pubs.get(1).getProduct().getPrice() + "TL");
        thirdPrice.setText(pubs.get(2).getProduct().getPrice() + "TL");
        forthPrice.setText(pubs.get(3).getProduct().getPrice() + "TL");
        fifthPrice.setText(pubs.get(4).getProduct().getPrice() + "TL");
        sixthPrice.setText(pubs.get(5).getProduct().getPrice() + "TL");
    }


    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openBookSearch(ActionEvent event) throws Exception {
        ui_BookSearch = initializeScene("ui_book_search.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_BookSearch);
    }

    public void bookLogout(ActionEvent event) throws Exception {
        ui_book_login_signup = initializeScene("ui_book_login_signup.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_login_signup);
    }

    public void openBookAccountPage(ActionEvent event) throws Exception {
        ui_book_account = initializeScene("ui_book_account.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_account);
    }

    public void setCurrentUserName() throws IOException {
        BufferedReader Buff = new BufferedReader(new FileReader("../logs.txt"));
        String text = Buff.readLine();
        currentUsername = text;

    }

    public void goDetailsOfBook1() throws Exception
    {
        try {

            Files.write(Paths.get("../bookname.txt"), "1".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)calikusu).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }

   /*
    public void goDetailsOfBook1() throws Exception
    {
        System.out.println("Hello");

        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            Parent root = (Parent)loader.load();


            BookDetailsController bookDetailsController = loader.getController();
            bookDetailsController.publication = RentalData.bookRental.getPublications().get(0);
            System.out.println("hello");
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
           // Files.write(Paths.get("../bookname.txt"), "1".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }

    }*/

    public void goDetailsOfBook2() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "2".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)sefiller).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }

    public void goDetailsOfBook3() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "3".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)yuzuklerinefendisi).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }

    public void goDetailsOfBook4() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "4".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)olasiliksiz).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }

    public void goDetailsOfBook5() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "5".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)aclikoyunlari).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }

    public void goDetailsOfBook6() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "6".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)savasvebaris).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }

    public void listMostRentedBooks(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Most Rented List")), 300,200));
        secondStage.show();
    }


}
