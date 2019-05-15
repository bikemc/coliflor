package UI.ui_Place;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.PlaceRental.Place;
import RentalSystemManager.Publication;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPlaceController implements Initializable{
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_PlaceSearch;
    private Scene ui_place_login_signup, ui_place_account, ui_place_details;

    @FXML
    private Text firstName, firstPrice, secondName, secondPrice, thirdName, thirdPrice, forthName, forthPrice;

    @FXML
    private ImageView meeting, birthday, wedding, babyshower;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Publication> pubs = RentalData.placeRental.getPublications();
        firstName.setText(((Place)(pubs.get(0).getProduct())).getPlaceName());
        secondName.setText(((Place)(pubs.get(1).getProduct())).getPlaceName());
        thirdName.setText(((Place)(pubs.get(2).getProduct())).getPlaceName());
        forthName.setText(((Place)(pubs.get(3).getProduct())).getPlaceName());

        firstPrice.setText(pubs.get(0).getProduct().getPrice() + "TL");
        secondPrice.setText(pubs.get(1).getProduct().getPrice() + "TL");
        thirdPrice.setText(pubs.get(2).getProduct().getPrice() + "TL");
        forthPrice.setText(pubs.get(3).getProduct().getPrice() + "TL");

    }


    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openNegativelyRatedList(ActionEvent event){
        Stage secondStage = new Stage();
        secondStage.setTitle("Negatively Rated List");
        secondStage.setResizable(false);
        VBox vbox =new VBox(15);

        ArrayList<Place> negativelyRated = RentalData.placeRental.listNegativelyRated();

        for (int i = 0; i < negativelyRated.size(); i++){
            System.out.println(negativelyRated.get(i).getPlaceName());
            Label placeName = new Label(negativelyRated.get(i).getPlaceName());
            placeName.setFont(new Font(25));
            // vbox.getChildren().add(title);

            Label rating = new Label(String.valueOf((int)negativelyRated.get(i).getRating()));
            //title.setFont(new Font(25));
            VBox v = new VBox();
            v.getChildren().addAll(placeName, rating);
            vbox.getChildren().add(v);
        }

        secondStage.setScene(new Scene(vbox, 300,500));
        secondStage.show();
    }

    public void openPositivelyRatedList(ActionEvent event){
        Stage secondStage = new Stage();
        secondStage.setTitle("Positively Rated List");
        secondStage.setResizable(false);
        VBox vbox =new VBox(15);

        ArrayList<Place> negativelyRated = RentalData.placeRental.listPositivelyRated();

        for (int i = 0; i < negativelyRated.size(); i++){
            System.out.println(negativelyRated.get(i).getPlaceName());
            Label placeName = new Label(negativelyRated.get(i).getPlaceName());
            placeName.setFont(new Font(25));
            // vbox.getChildren().add(title);

            Label rating = new Label(String.valueOf((int)negativelyRated.get(i).getRating()));
            //title.setFont(new Font(25));
            VBox v = new VBox();
            v.getChildren().addAll(placeName, rating);
            vbox.getChildren().add(v);
        }

        secondStage.setScene(new Scene(vbox, 300,500));
        secondStage.show();
    }

    public void openPlaceSearch(ActionEvent event) throws Exception {
        ui_PlaceSearch = initializeScene("ui_place_search.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_PlaceSearch);
    }

    public void placeLogout(ActionEvent event) throws Exception {
        ui_place_login_signup = initializeScene("ui_place_login_signup.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_login_signup);
    }

    public void openPlaceAccountPage(ActionEvent event) throws Exception {
        ui_place_account = initializeScene("ui_place_account.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_account);
    }
   /* public void goDetailsOfPlace1() throws Exception
    {
        try {

            Files.write(Paths.get("../bookname.txt"), "1".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_place_details = initializeScene("ui_place_details.fxml");
        Stage primaryStage = (Stage)((Node)birthday).getScene().getWindow();
        primaryStage.setScene(ui_place_details);
    }
    */

    public void goDetailsOfPlace1() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_place_details.fxml"));
            PlaceDetailsController.publication = RentalData.placeRental.getPublications().get(0);

            PlaceDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.placeRental.getPublications().get(0) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }

    }


    public void goDetailsOfPlace2() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_place_details.fxml"));
            PlaceDetailsController.publication = RentalData.placeRental.getPublications().get(1);

            PlaceDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.placeRental.getPublications().get(1) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }

    }

    public void goDetailsOfPlace3() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_place_details.fxml"));
            PlaceDetailsController.publication = RentalData.placeRental.getPublications().get(2);

            PlaceDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.placeRental.getPublications().get(2) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }

    }

    public void goDetailsOfPlace4() throws Exception
    {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_place_details.fxml"));
            PlaceDetailsController.publication = RentalData.placeRental.getPublications().get(3);

            PlaceDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.placeRental.getPublications().get(3) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }

    }

}
