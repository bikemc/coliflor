package UI.ui_Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookDetailsController {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book, ui_book_result, ui_book_rent;

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

    public void backBookResultsPage(ActionEvent event) throws Exception
    {
        ui_book_result = initializeScene("ui_book_results.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_result);
    }


    public void openBookRentPage(ActionEvent event) throws Exception
    {
        ui_book_rent = initializeScene("ui_book_rent.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_rent);
    }
}
