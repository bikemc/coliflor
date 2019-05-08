package UI.ui_Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBookController {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_BookSearch;
    private Scene ui_book_login_signup, ui_book_account;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openBookSearch(ActionEvent event) throws Exception {
        ui_BookSearch = initializeScene("ui_book_search.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_BookSearch);
    }

    public void bookLogout(ActionEvent event) throws Exception {
        ui_book_login_signup = initializeScene("ui_book_login_signup.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_login_signup);
    }

    public void openBookAccountPage(ActionEvent event) throws Exception {
        ui_book_account = initializeScene("ui_book_account.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_account);
    }
}
