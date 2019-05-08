package UI.ui_Place;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPlaceController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_PlaceSearch;
    private Scene ui_place_login_signup, ui_place_account;

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
}
