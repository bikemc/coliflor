package UI.ui_Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BookRentController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
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
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Rented")), 300,200));
        secondStage.show();
    }


}
