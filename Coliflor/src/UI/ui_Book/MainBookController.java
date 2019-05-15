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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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


    @FXML
    private Text firstName, firstPrice, secondName, secondPrice, thirdName, thirdPrice, forthName, forthPrice, fifthName, fifthPrice, sixthName, sixthPrice;


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

/*
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
*/

    public void goDetailsOfBook1() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            BookDetailsController.publication = RentalData.bookRental.getPublications().get(0);

            BookDetailsController bookDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.bookRental.getPublications().get(0) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }

    }

    public void goDetailsOfBook2() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            BookDetailsController.publication = RentalData.bookRental.getPublications().get(1);

            BookDetailsController bookDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.bookRental.getPublications().get(1) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void goDetailsOfBook3() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            BookDetailsController.publication = RentalData.bookRental.getPublications().get(2);

            BookDetailsController bookDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.bookRental.getPublications().get(2) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void goDetailsOfBook4() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            BookDetailsController.publication = RentalData.bookRental.getPublications().get(3);

            BookDetailsController bookDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.bookRental.getPublications().get(3) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void goDetailsOfBook5() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            BookDetailsController.publication = RentalData.bookRental.getPublications().get(4);

            BookDetailsController bookDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.bookRental.getPublications().get(4) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void goDetailsOfBook6() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
            BookDetailsController.publication = RentalData.bookRental.getPublications().get(5);

            BookDetailsController bookDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.bookRental.getPublications().get(5) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void listMostRentedBooks(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setTitle("Most Rented List");
        secondStage.setResizable(false);
        VBox vbox =new VBox(15);
        ArrayList<BookPublication> mostRentedBooks = RentalData.bookRental.listMostRented();

        for (int i = 0; i < mostRentedBooks.size(); i++){
            System.out.println(mostRentedBooks.get(i).getTitle());
            Label title = new Label(mostRentedBooks.get(i).getTitle());
            title.setFont(new Font(25));
            // vbox.getChildren().add(title);

            Label author = new Label(((Book)mostRentedBooks.get(i).getProduct()).getAuthor());
            Label rentNo= new Label("Rent count: "+mostRentedBooks.get(i).getRentNumber());
            //title.setFont(new Font(25));
            VBox v = new VBox();
            v.getChildren().addAll(title, author,rentNo);
            vbox.getChildren().add(v);
        }

        secondStage.setScene(new Scene(vbox, 300,500));
        secondStage.show();
    }

}
