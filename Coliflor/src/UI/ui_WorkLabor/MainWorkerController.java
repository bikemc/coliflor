package UI.ui_WorkLabor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWorkerController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker_Search;
    private Scene ui_Worker_login_signup, ui_Worker_account;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openWorkerSearch(ActionEvent event) throws Exception {
        ui_Worker_Search = initializeScene("ui_Worker_search.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker_Search);
    }

    public void WorkerLogout(ActionEvent event) throws Exception {
        ui_Worker_login_signup = initializeScene("ui_Worker_login_signup.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker_login_signup);
    }

    public void openWorkerAccountPage(ActionEvent event) throws Exception {
        ui_Worker_account = initializeScene("ui_Worker_account.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker_account);
    }
}
