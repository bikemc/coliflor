package UI.ui_Place;

import ProductManager.Product.BookRental.BookUser;
import ProductManager.Product.PlaceRental.Place;
import ProductManager.Product.PlaceRental.PlaceRental;
import ProductManager.Product.PlaceRental.PlaceRentalContract;
import ProductManager.Product.PlaceRental.PlaceUser;
import RentalSystemManager.*;
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class PlaceLoginController {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Place, ui_MainPage;

    protected ArrayList<PlaceUser> users  =  new ArrayList<PlaceUser>();
    protected ArrayList<Publication> publications  = new ArrayList<Publication>();;
    protected ArrayList<Place> products = new ArrayList<Place>();
    protected ArrayList<Payment> payments= new ArrayList<Payment>();
    protected ArrayList<PlaceRentalContract> contracts= new ArrayList<PlaceRentalContract>();
    protected PlaceRental rental;
    protected RentalData rentalData;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginPassword;

    @FXML
    private TextField signupName,signupPassword, signupEmail, signupUsername, signupAddress, signupBirthday, signupPhonenumber;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openPlaceMainPage(ActionEvent event) throws Exception
    {
        if(rentalData==null)
             rentalData = new RentalData();
        //Default User
        //  users.add(new BookUser("Cansu","cansu@email.com","Çayyolu, Ankara", "cansuy",123, "p",  new Date(1997,12,24),null,null,null,null,null,null,0,null,null,0));
        //rental = new BookRental(rentalData.users, publications, products, payments, contracts);

        if (RentalData.placeRental.login(loginUsername.getText(), loginPassword.getText()))
        {
            //MainBookController bookCont = new MainBookController();
            //bookCont.setCurrentUser(loginUsername.getText());
            saveUsername();
            ui_Place = initializeScene("ui_Place.fxml");
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(ui_Place);
        }
        else
        {
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(new HBox(300, new Label("    Incorrect Username or Password")), 300,200));
            secondStage.show();
        }

    }

    public void backMainPage(ActionEvent event) throws Exception
    {
        ui_MainPage = initializeScene("../ui_MainPage.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_MainPage);
    }


    public void placeSignup(ActionEvent event) throws Exception {

        rentalData = new RentalData();
        RentalData.placeRental.getUsers().add(new PlaceUser(signupName.getText(),signupEmail.getText(),signupAddress.getText(), signupUsername.getText(), parseInt(signupPhonenumber.getText()), signupPassword.getText(),  new Date(1995,12,24),null,null,null,null,null));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Successfully Signed-up")), 300,200));
        secondStage.show();
    }


    public void saveUsername()
    {
        try {
            Files.write(Paths.get("../logs.txt"), loginUsername.getText().getBytes());
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }



}
