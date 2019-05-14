package UI.ui_WorkLabor;

import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Date;

import static java.lang.Integer.parseInt;

public class WorkerAccountSettingsController {

    @FXML
    private TextField name, password, birthday, phone;

    private Scene ui_Worker;
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;


    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backtoMenu(ActionEvent event) throws Exception
    {
        ui_Worker = initializeScene("ui_Worker.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker);
    }

    public void save(ActionEvent event) throws Exception
    {
        RentalData.workerRental.changeAccountInformation(name.getText(),password.getText(),new Date(5,6,4),parseInt(phone.getText()));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Changes are saved")), 300,200));
        secondStage.show();
    }
}
