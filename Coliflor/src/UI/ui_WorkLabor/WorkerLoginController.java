
package UI.ui_WorkLabor;

import ProductManager.Product.WorkLaborRental.Employee;
import ProductManager.Product.WorkLaborRental.WorkLaborRental;
import ProductManager.Product.WorkLaborRental.WorkLaborRentalContract;
import ProductManager.Product.WorkLaborRental.WorkLaborUser;
import RentalSystemManager.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class WorkerLoginController {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Worker, ui_MainPage;

    protected ArrayList<WorkLaborUser> users  =  new ArrayList<WorkLaborUser>();
    protected ArrayList<Publication> publications  = new ArrayList<Publication>();;
    protected ArrayList<Employee> products = new ArrayList<Employee>();
    protected ArrayList<Payment> payments= new ArrayList<Payment>();
    protected ArrayList<WorkLaborRentalContract> contracts= new ArrayList<WorkLaborRentalContract>();
    protected ArrayList<Employee> topWorkedList= new ArrayList<Employee>();
    protected Map<String, Employee> workerOfMonth= null;
    protected Rental rental;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginPassword;

    @FXML
    private TextField signupName,signupPassword, signupEmail, signupUsername, signupAddress, signupBirthday, signupPhonenumber;




    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

    public void openWorkerMainPage(ActionEvent event) throws Exception
    {
        //DefaultUser
        users.add(new WorkLaborUser("Cansu","cansu@email.com","Çayyolu, Ankara", "cansuy",123, "p",  new Date(1997,12,24),null,null,null,null,null));
        rental = new WorkLaborRental(users, publications, products, payments,contracts);
        if (rental.login(loginUsername.getText(), loginPassword.getText()))
        {
            ui_Worker = initializeScene("ui_Worker.fxml");
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(ui_Worker);
        }
        else
        {
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(new HBox(300, new Label("    Incorrect Username or Password")), 300,200));
            secondStage.show();
        }

    }

    public void backMainPage(ActionEvent event) throws Exception
    {
        ui_MainPage = initializeScene("../ui_MainPage.fxml");
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(ui_MainPage);
    }


    public void workerSignup(ActionEvent event) throws Exception {

        users.add(new WorkLaborUser(signupName.getText(),signupEmail.getText(),signupAddress.getText(), signupUsername.getText(), parseInt(signupPhonenumber.getText()), signupPassword.getText(),  new Date(1995,12,24),null,null,null,null,null));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(300, new Label("     Successfully Signed-up")), 300,200));
        secondStage.show();
    }



}
