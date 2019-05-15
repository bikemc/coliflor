package UI.ui_WorkLabor;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.PlaceRental.Place;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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

        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_worker_details.fxml"));
            WorkerDetailsController.publication = RentalData.workerRental.getPublications().get(0);

            WorkerDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.workerRental.getPublications().get(0) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }


    }

    public void goDetailsOfEmployee2() throws Exception {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_worker_details.fxml"));
            WorkerDetailsController.publication = RentalData.workerRental.getPublications().get(1);

            WorkerDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.workerRental.getPublications().get(1) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void goDetailsOfEmployee3() throws Exception {
        System.out.println("hello");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui_worker_details.fxml"));
            WorkerDetailsController.publication = RentalData.workerRental.getPublications().get(2);

            WorkerDetailsController placeDetailsController= loader.getController();
            Parent root = (Parent)loader.load();
            System.out.println( " dfsgfsdgdg "+ RentalData.workerRental.getPublications().get(2) == null);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,WIDTH, HEIGHT));
            stage.show();
            // Files.write(Paths.get("../bookname.txt"), "1".getBytes());


        }catch (Exception e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public void topWorkers(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setTitle("Top Workers");
        secondStage.setResizable(false);
        VBox vbox =new VBox(10);

        ArrayList<Employee> topWorkedList = RentalData.workerRental.getTopWorkedList();

        for (int i = 0; i < topWorkedList.size(); i++){
            System.out.println(topWorkedList.get(i).getEmployeeName());
            Label workerName = new Label(topWorkedList.get(i).getEmployeeName());
            workerName.setFont(new Font(25));
            // vbox.getChildren().add(title);

            Label rating = new Label(String.valueOf(topWorkedList.get(i).getRating()));
            //title.setFont(new Font(25));
            VBox v = new VBox();
            v.getChildren().addAll(workerName, rating);
            vbox.getChildren().add(v);
        }

        secondStage.setScene(new Scene(vbox, 300,300));
        secondStage.show();
    }

    public void workerOfMonth(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setTitle("Worker of the Month");
        secondStage.setResizable(false);
        VBox vbox =new VBox(15);

        Employee workerOfTheMonth = RentalData.workerRental.getWorkerOfTheMonth();
        Label  label = new Label(workerOfTheMonth.getEmployeeName());
        label.setFont(new Font(25));
        Label l = new Label(String.valueOf((int)workerOfTheMonth.getRating()));
        vbox.getChildren().addAll(label, l);

        secondStage.setScene(new Scene(vbox, 300,100));
        secondStage.show();
    }
}
