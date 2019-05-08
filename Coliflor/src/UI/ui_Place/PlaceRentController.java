package UI.ui_Place;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlaceRentController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_place_details, ui_Place;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backPlaceDetailsPage(ActionEvent event) throws Exception
    {
        ui_place_details = initializeScene("ui_place_details.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_details);
    }



    public void backPlaceMainPage(ActionEvent event) throws Exception
    {
        ui_Place = initializeScene("ui_Place.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Place);
    }
}
