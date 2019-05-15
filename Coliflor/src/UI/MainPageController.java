package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainPageController extends Application {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_MainPage;
    private Scene ui_book_login_signup;
    private Scene ui_place_login_signup;
    private Scene ui_worker_login_signup;
    public RentalData rentalData= new RentalData();
    public static  void main(String []args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ui_MainPage = initializeScene("ui_MainPage.fxml");
        primaryStage.setScene(ui_MainPage);
        primaryStage.show();
    }

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openBookRentalSystem(ActionEvent event)  throws Exception
    {
        ui_book_login_signup = initializeScene("ui_Book/ui_book_login_signup.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_book_login_signup);
    }

    public void openPlaceRentalSystem(ActionEvent event)  throws Exception
    {
        ui_place_login_signup = initializeScene("ui_Place/ui_place_login_signup.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_place_login_signup);
    }

    public void openWorkerRentalSystem(ActionEvent event)  throws Exception
    {
        ui_worker_login_signup = initializeScene("ui_WorkLabor/ui_worker_login_signup.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_login_signup);
    }
}