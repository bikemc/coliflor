package UI.ui_Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookResultsController {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book, ui_book_search, ui_book_details;

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

    public void backBookSearchPage(ActionEvent event) throws Exception
    {
        ui_book_search = initializeScene("ui_book_search.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_search);
    }

    public void openBookDetailsPage(ActionEvent event) throws Exception
    {
        ui_book_details = initializeScene("ui_book_details.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_details);
    }
}
