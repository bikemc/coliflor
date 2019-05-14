package UI.ui_WorkLabor;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.WorkLaborRental.Employee;
import RentalSystemManager.Publication;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class WorkerDetailsController implements Initializable {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker, ui_worker_result, ui_worker_rent;

    private  int savedBookID;
    private  String savedBookID2;
    private RentalData bookData, workerPublicationData;

    @FXML
    private Text workerOccupation, workerPrice,workerCity,workerName,workerExperience,workerAge;
    @FXML
    private ImageView workerImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Publication> pubs = RentalData.workerRental.getPublications();
        BufferedReader Buff = null;
        try {
            Buff = new BufferedReader(new FileReader("../bookname.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            savedBookID2 =  Buff.readLine();
            System.out.println("id2"+savedBookID2);
            if(isStringInt( savedBookID2)) //????
                savedBookID =  parseInt(savedBookID2);
            else
                savedBookID = RentalData.returnWorkerID(savedBookID2); //??????????????
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("saved"+savedBookID);
        workerOccupation.setText(((Employee)pubs.get(savedBookID-1).getProduct()).getOccupation().get(0)+"");
        workerPrice.setText(((Employee)pubs.get(savedBookID-1).getProduct()).getPrice() + "TL");
        workerCity.setText((((Employee) pubs.get(savedBookID-1).getProduct()).getAddress()));
        workerName.setText((((Employee) pubs.get(savedBookID-1).getProduct()).getEmployeeName()));
        workerExperience.setText((((Employee) pubs.get(savedBookID-1).getProduct()).getExperiencedYears())+"");
        workerAge.setText((((Employee) pubs.get(savedBookID-1).getProduct()).getAge())+"");

        //nameBook.setText(bookPublicationData.mainPageBook.get(savedBookID-1).getBookTitle());
        if(savedBookID == 1)
            workerImage.setImage(new Image("UI/Images/math.jpg"));
        else if(savedBookID == 2)
            workerImage.setImage(new Image("UI/Images/nanny.jpg"));
        else if(savedBookID == 3)
            workerImage.setImage(new Image("UI/Images/math2.jpg"));

    }

    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void backWorkerMainPage(ActionEvent event) throws Exception
    {
        ui_Worker = initializeScene("ui_Worker.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_Worker);
    }

    public void backWorkerResultsPage(ActionEvent event) throws Exception
    {
        ui_worker_result = initializeScene("ui_worker_results.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_result);
    }


    public void openWorkerRentPage(ActionEvent event) throws Exception
    {
        ui_worker_rent = initializeScene("ui_worker_rent.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_rent);
    }

    public void viewReviews(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Reviews")), 300,200));
        secondStage.show();
    }

    public void offerDiscount(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    offer discount")), 300,200));
        secondStage.show();
    }

    public void compare(ActionEvent event) throws Exception
    {
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("    Compare")), 300,200));
        secondStage.show();
    }


}
