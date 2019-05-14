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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WorkerResultsController implements Initializable {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker, ui_worker_search, ui_worker_details;

    private String searchKey;
    RentalData data;

    @FXML
    private ImageView resultImage;

    @FXML
    private Text resultName;

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

    public void backWorkerSearchPage(ActionEvent event) throws Exception
    {
        ui_worker_search = initializeScene("ui_worker_search.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_search);
    }

    public void openWorkerDetailsPage(ActionEvent event) throws Exception
    {
        ui_worker_details = initializeScene("ui_worker_details.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_worker_details);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BufferedReader Buff = null;
        try {
            Buff = new BufferedReader(new FileReader("../bookname.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            searchKey = ( Buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Publication> p = RentalData.workerRental.searchPublication(searchKey);

        //for (BookPublication p:searchedPublications) System.out.println(((Book)p.getProduct()).getBookTitle());

        System.out.println(p);
        resultName.setText(((Employee)p.get(0).getProduct()).getEmployeeName() +" Price:" + ((Employee)p.get(0).getProduct()).getPrice() + "TL");
        if((p.get(0)).getId() == 1)
            resultImage.setImage(new Image("UI/Images/math.jpg"));
        if((p.get(0)).getId() == 3)
            resultImage.setImage(new Image("UI/Images/math2.jpg"));
        if((p.get(0)).getId() == 2)
            resultImage.setImage(new Image("UI/Images/nanny.jpg"));

    }
}
