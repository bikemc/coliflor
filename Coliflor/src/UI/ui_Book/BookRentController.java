package UI.ui_Book;

import ProductManager.Product.BookRental.BookPublication;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Date;

public class BookRentController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    private Scene ui_book_details, ui_Book;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backBookDetailsPage(ActionEvent event) throws Exception
    {
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }



    public void backBookMainPage(ActionEvent event) throws Exception
    {
        ui_Book = initializeScene("ui_Book.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Book);
    }

    public void pay(ActionEvent event) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_book_details.fxml"));
        Parent root = (Parent)loader.load();

        Label label1;
        BookDetailsController bookDetailsController = loader.getController();
        bookDetailsController.publication = RentalData.bookRental.getPublications().get(0);
        if(RentalData.bookRental.pay((BookPublication) bookDetailsController.publication ,new Date(),  new Date(System.currentTimeMillis() - (15 * DAY_IN_MS)))){
           label1 = new Label("Payment is successfull");
           RentalData.bookRental.rent(RentalData.bookRental.currentUser,(BookPublication) bookDetailsController.publication,new Date(),new Date(System.currentTimeMillis()));
        }
        else{
            label1 = new Label("Payment is unsuccessfull");
        }
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, label1), 300,200));
        secondStage.show();
    }


}
