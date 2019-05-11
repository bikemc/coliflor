package UI.ui_Book;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class BookLoginController {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book, ui_MainPage;

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openBookMainPage(ActionEvent event) throws Exception
    {
        ui_Book = initializeScene("ui_Book.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Book);
    }

    public void backMainPage(ActionEvent event) throws Exception
    {
        ui_MainPage = initializeScene("../ui_MainPage.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_MainPage);
    }

    public void bookSignUp(ActionEvent event) throws Exception {
      /*  new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                //dialog.initOwner(primaryStage);
                dialog.initModality(Modality.NONE);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("This is a Dialog"));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }

        };*/
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Hello")), 300,200));
        secondStage.show();
    }
}
