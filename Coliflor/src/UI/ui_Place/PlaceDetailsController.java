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
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class PlaceDetailsController implements Initializable{
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Place, ui_place_results, ui_place_rent;

    public static Publication publication;

    @FXML
    private Text namePlace, pricePlace, placeLocation, capacityPlace, services, transportation;
    @FXML
    private javafx.scene.image.ImageView placeImage;
    private  int savedPlaceID;
    private  String savedPlaceID2;
    private RentalData placePublicationData;


    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(publication == null);

        namePlace.setText(publication.getTitle());
        pricePlace.setText(publication.getProduct().getPrice() + "TL");
        capacityPlace.setText(((Place) publication.getProduct()).getCapacity() + "");
        placeLocation.setText(((Place) publication.getProduct()).getLocation());
        String offserv = "";
        for(int i=0; i<((Place) publication.getProduct()).getServices().size(); i++)
            offserv += ((Place) publication.getProduct()).getServices().get(i) + "\n";
        services.setText(offserv);
        String trans = "";
        for(int i=0; i<((Place) publication.getProduct()).getTransportationOptions().size(); i++)
            trans += ((Place) publication.getProduct()).getTransportationOptions().get(i) + "\n";
        transportation.setText(trans);

        if(savedPlaceID == 1)
            placeImage.setImage(new Image("UI/Images/birthday.jpg"));
        else if(savedPlaceID == 2)
            placeImage.setImage(new Image("UI/Images/meeting.jpg"));
        else if(savedPlaceID == 3)
            placeImage.setImage(new Image("UI/Images/babyshower.jpg"));
        else if(savedPlaceID == 4)
            placeImage.setImage(new Image("UI/Images/wedding.jpg"));


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

    public void backPlaceMainPage(ActionEvent event) throws Exception
    {
        ui_Place = initializeScene("ui_Place.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Place);
    }

    public void backPlaceResultsPage(ActionEvent event) throws Exception
    {
        ui_place_results = initializeScene("ui_place_results.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_results);
    }


    public void openPlaceRentPage(ActionEvent event) throws Exception
    {
        ui_place_rent = initializeScene("ui_place_rent.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_rent);
    }

    public void viewReviews(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Reviews")), 300,200));
        secondStage.show();
    }

    public void shareSocialMedia(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Shared on Social Media")), 300,200));
        secondStage.show();
    }
    public void show3D(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("   3D")), 300,200));
        secondStage.show();
    }
    public void checkWheather(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Sunny")), 300,200));
        secondStage.show();
    }
}
