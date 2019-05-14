package UI.ui_WorkLabor;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.WorkLaborRental.Employee;
import RentalSystemManager.Publication;
import UI.RentalData;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWorkerController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker_Search;
    private Scene ui_Worker_login_signup, ui_Worker_account,ui_worker_details;
    private Scene ui_place_details;
    private RentalData x;

    @FXML
    private Text firstName, firstPrice, secondName, secondPrice, thirdName, thirdPrice;


    @FXML
    private ImageView firstEmployee, secondEmployee, thirdEmployee;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //bookData = new RentalData();
        //bookPublicationData = new RentalData();
        ArrayList<Publication> pubs = RentalData.workerRental.getPublications();
        firstName.setText(((Employee)(pubs.get(0).getProduct())).getEmployeeName());
        secondName.setText(((Employee)(pubs.get(1).getProduct())).getEmployeeName());
        thirdName.setText(((Employee)(pubs.get(2).getProduct())).getEmployeeName());
        firstPrice.setText(pubs.get(0).getProduct().getPrice() + "TL");
        secondPrice.setText(pubs.get(1).getProduct().getPrice() + "TL");
        thirdPrice.setText(pubs.get(2).getProduct().getPrice() + "TL");

    }

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openWorkerSearch(ActionEvent event) throws Exception {
        ui_Worker_Search = initializeScene("ui_Worker_search.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker_Search);
    }

    public void WorkerLogout(ActionEvent event) throws Exception {
        ui_Worker_login_signup = initializeScene("ui_Worker_login_signup.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker_login_signup);
    }

    public void openWorkerAccountPage(ActionEvent event) throws Exception {
        ui_Worker_account = initializeScene("ui_Worker_account.fxml");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker_account);
    }

    public void goDetailsOfEmployee1() throws Exception {
        try {

            Files.write(Paths.get("../bookname.txt"), "1".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_worker_details = initializeScene("ui_worker_details.fxml");
        Stage primaryStage = (Stage)((Node)firstEmployee).getScene().getWindow();
        primaryStage.setScene(ui_worker_details);
    }

    public void goDetailsOfEmployee2() throws Exception {
        try {

            Files.write(Paths.get("../bookname.txt"), "2".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_worker_details = initializeScene("ui_worker_details.fxml");
        Stage primaryStage = (Stage)((Node)secondEmployee).getScene().getWindow();
        primaryStage.setScene(ui_worker_details);
    }

    public void goDetailsOfEmployee3() throws Exception {
        try {

            Files.write(Paths.get("../bookname.txt"), "3".getBytes());

        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        ui_worker_details = initializeScene("ui_worker_details.fxml");
        Stage primaryStage = (Stage)((Node)thirdEmployee).getScene().getWindow();
        primaryStage.setScene(ui_worker_details);
    }

    public void topWorkers(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Top Workers")), 300,200));
        secondStage.show();
    }

    public void workerOfMonth(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Worker of Month")), 300,200));
        secondStage.show();
    }
}
