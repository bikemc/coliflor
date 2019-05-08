package UI.ui_Place;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlaceResultsController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Place, ui_place_search, ui_place_details;

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
}
