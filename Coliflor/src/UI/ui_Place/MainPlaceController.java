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
import javafx.scene.image.ImageView;
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
    public void goDetailsOfPlace1() throws Exception
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
    public void goDetailsOfPlace2() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "2".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_place_details = initializeScene("ui_place_details.fxml");
        Stage primaryStage = (Stage)((Node)meeting).getScene().getWindow();
        primaryStage.setScene(ui_place_details);
    }

    public void goDetailsOfPlace3() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "3".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_place_details = initializeScene("ui_place_details.fxml");
        Stage primaryStage = (Stage)((Node)babyshower).getScene().getWindow();
        primaryStage.setScene(ui_place_details);
    }

    public void goDetailsOfPlace4() throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), "4".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_place_details = initializeScene("ui_place_details.fxml");
        Stage primaryStage = (Stage)((Node)wedding).getScene().getWindow();
        primaryStage.setScene(ui_place_details);
    }

}
