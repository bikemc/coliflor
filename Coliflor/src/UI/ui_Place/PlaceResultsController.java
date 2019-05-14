package UI.ui_Place;

import ProductManager.Product.PlaceRental.Place;
import ProductManager.Product.WorkLaborRental.Employee;
import RentalSystemManager.Publication;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlaceResultsController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Place, ui_place_search, ui_place_details;
    private String searchKey;
    RentalData data;

    @FXML
    private ImageView resultImage;

    @FXML
    private Text resultName;


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

    public void backPlaceSearchPage(ActionEvent event) throws Exception
    {
        ui_place_search = initializeScene("ui_place_search.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_search);
    }

    public void openPlaceDetailsPage(ActionEvent event) throws Exception
    {
        ui_place_details = initializeScene("ui_place_details.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_details);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BufferedReader Buff = null;
        try {
            Buff = new BufferedReader(new FileReader("../bookname.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            searchKey = ( Buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Publication> p = RentalData.placeRental.searchPublication(searchKey);

        //for (BookPublication p:searchedPublications) System.out.println(((Book)p.getProduct()).getBookTitle());

        System.out.println(p);
        resultName.setText(((Place)p.get(0).getProduct()).getPlaceName() +" Price:" + ((Place)p.get(0).getProduct()).getPrice() + "TL");
        if((p.get(0)).getId() == 1)
            resultImage.setImage(new Image("UI/Images/birthday.jpg"));
        if((p.get(0)).getId() == 3)
            resultImage.setImage(new Image("UI/Images/babyshower.jpg"));
        if((p.get(0)).getId() == 2)
            resultImage.setImage(new Image("UI/Images/meeting.jpg"));
        if((p.get(0)).getId() == 4)
            resultImage.setImage(new Image("UI/Images/wedding.jpg"));
    }
}
