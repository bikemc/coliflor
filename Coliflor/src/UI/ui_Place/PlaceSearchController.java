package UI.ui_Place;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PlaceSearchController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Place, ui_place_results;

    @FXML
    private TextField placeType;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backMainPlacePage(ActionEvent event) throws Exception
    {
        ui_Place = initializeScene("ui_Place.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Place);
    }

    public void openPlaceResultPage(ActionEvent event) throws Exception
    {
        try {
            Files.write(Paths.get("../bookname.txt"), placeType.getText().getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_place_results = initializeScene("ui_place_results.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_results);
    }
}
