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
        String nameText, passwordText, birthDayText, phoneText;
        if (!name.getText().toString().equals("")){
            nameText = name.getText().toString();
        }
        else{
            nameText = RentalData.bookRental.currentUser.getName();
        }

        if (!password.getText().toString().equals("")){
            passwordText = password.getText().toString();
        }
        else{
            passwordText = RentalData.workerRental.currentUser.getPassword();
        }

        if (!birthday.getText().toString().equals("")){
            birthDayText = birthday.getText().toString();
        }
        else{
            birthDayText = RentalData.workerRental.currentUser.getBirthday().toString();
        }

        if (!phone.getText().toString().equals("")){
            phoneText = phone.getText().toString();
        }
        else{
            phoneText = RentalData.workerRental.currentUser.getPhoneNumber() + "";
        }

        RentalData.workerRental.changeAccountInformation(nameText,passwordText,new Date(5,6,4),Long.parseLong(phoneText));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Changes are saved")), 300,200));
        secondStage.show();
    }
}
