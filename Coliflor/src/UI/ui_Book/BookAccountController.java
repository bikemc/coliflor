package UI.ui_Book;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookUser;
import RentalSystemManager.Rental;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class BookAccountController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book,ui_Book_accountsettings;
    private String username;

    @FXML
    private Text userName, userSurname, userPhone, userEmail, userAddress, userPoints;

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

        System.out.println(RentalData.bookRental.currentUser.getUsername());
        // BookUser user = RentalData.returnUser(username);
        userName.setText(RentalData.bookRental.currentUser.getUsername());
        userSurname.setText(RentalData.bookRental.currentUser.getName());
        userPhone.setText( Long.toString(RentalData.bookRental.currentUser.getPhoneNumber()));
        userEmail.setText(RentalData.bookRental.currentUser.getEmail());
        userAddress.setText(RentalData.bookRental.currentUser.getAddress());
        userPoints.setText(Integer.toString(RentalData.bookRental.currentUser.getPoint()));
    }

    public void checkFunds(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("Current Fund is: "+ RentalData.bookRental.currentUser.getFund())), 300,200));
        secondStage.show();
    }
    public void seeWishList(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setTitle("WishList");
        secondStage.setResizable(false);
        VBox vbox =new VBox(15);
        ArrayList<Book> wish = RentalData.bookRental.currentUser.getWishList();

        for (int i = 0; i < wish.size(); i++){
            System.out.println(wish.get(i).getBookTitle());
            Label title = new Label(wish.get(i).getBookTitle());
            title.setFont(new Font(25));
            // vbox.getChildren().add(title);

            Label author = new Label((wish.get(i).getAuthor()));
            //title.setFont(new Font(25));
            VBox v = new VBox();
            v.getChildren().addAll(title, author);
            vbox.getChildren().add(v);
        }

        secondStage.setScene(new Scene(vbox, 300,500));
        secondStage.show();
    }
    public void addFunds(ActionEvent event) throws Exception
    {
        VBox vbox =new VBox(15);
        Stage secondStage = new Stage();
        Label label1 = new Label("Add Amount:");
        TextField textField = new TextField ();
        Button submit = new Button("Submit");
        vbox.getChildren().add(label1);
        vbox.getChildren().add(textField);
        vbox.getChildren().add(submit);
        secondStage.setScene(new Scene(vbox));

        secondStage.show();
        submit.setOnAction(event1 -> {
            RentalData.bookRental.addFund(parseInt(textField.getText()));
            secondStage.close();
        });
    }
    public void settings(ActionEvent event) throws Exception
    {
       /* Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Settings")), 300,200));
        secondStage.show();*/
        ui_Book_accountsettings = initializeScene("ui_book_account_settings.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Book_accountsettings);
    }
    public void messageWithCompany(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Message with Company")), 300,200));
        secondStage.show();
    }



}
