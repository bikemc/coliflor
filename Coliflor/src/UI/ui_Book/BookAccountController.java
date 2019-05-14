package UI.ui_Book;

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

import static java.lang.Integer.parseInt;

public class BookAccountController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book;
    private String username;

    @FXML
    private Text userName, userSurname, userPhone, userEmail, userAddress;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backBookMainPage(ActionEvent event) throws Exception
    {
        ui_Book = initializeScene("ui_Book.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Book);
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
        RentalData data = new RentalData();
        BookUser user = RentalData.returnUser(username);
        userName.setText(user.getName());
        userSurname.setText(user.getUsername());
        userPhone.setText(user.getPhoneNumber()+"");
        userEmail.setText(user.getEmail());
        userAddress.setText(user.getAddress());
    }

    public void checkFunds(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Fund")), 300,200));
        secondStage.show();
    }

    public void settings(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Settings")), 300,200));
        secondStage.show();
    }

    public void messageWithCompany(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Message with Company")), 300,200));
        secondStage.show();
    }



}
