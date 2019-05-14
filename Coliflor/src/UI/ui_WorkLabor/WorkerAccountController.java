package UI.ui_WorkLabor;

import ProductManager.Product.BookRental.BookUser;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WorkerAccountController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker,ui_worker_accountsettings;
    private String username;

    @FXML
    private Text userName, userSurname, userPhone, userEmail, userAddress;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BufferedReader Buff = null;
        try {
            Buff = new BufferedReader(new FileReader("../logs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            username = ( Buff.readLine());
            System.out.println(username);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userName.setText(RentalData.workerRental.currentUser.getName());
        userSurname.setText(RentalData.workerRental.currentUser.getUsername());
        userPhone.setText( Long.toString(RentalData.workerRental.currentUser.getPhoneNumber()));
        userEmail.setText(RentalData.workerRental.currentUser.getEmail());
        userAddress.setText(RentalData.workerRental.currentUser.getAddress());
    }

    public void messageWithCompany(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Message With Company")), 300,200));
        secondStage.show();

    }

    public void settings(ActionEvent event) throws Exception
    {
        /*Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("     Settings")), 300,200));
        secondStage.show();*/
        ui_worker_accountsettings = initializeScene("ui_worker_account_settings.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_accountsettings);
    }
}
