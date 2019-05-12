package UI.ui_WorkLabor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WorkerDetailsController {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker, ui_worker_result, ui_worker_rent;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backWorkerMainPage(ActionEvent event) throws Exception
    {
        ui_Worker = initializeScene("ui_Worker.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker);
    }

    public void backWorkerResultsPage(ActionEvent event) throws Exception
    {
        ui_worker_result = initializeScene("ui_worker_results.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_result);
    }


    public void openWorkerRentPage(ActionEvent event) throws Exception
    {
        ui_worker_rent = initializeScene("ui_worker_rent.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_rent);
    }
}
