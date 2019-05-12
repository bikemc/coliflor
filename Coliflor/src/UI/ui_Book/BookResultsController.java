package UI.ui_Book;

import ProductManager.Product.BookRental.Book;
import ProductManager.Product.BookRental.BookPublication;
import ProductManager.Product.BookRental.BookRental;
import RentalSystemManager.Publication;
import RentalSystemManager.Rental;
import UI.RentalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.image.Image;
import static java.lang.Integer.parseInt;

public class BookResultsController implements Initializable {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_Book, ui_book_search, ui_book_details;
    private ArrayList<BookPublication> searchedPublications;

    private String searchKey;
    BookRental rental;
    RentalData data;

    @FXML
    private Text resultName;
    @FXML
    private ImageView resultImage;

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
            System.out.println(searchKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //data = new RentalData();
        //rental = new BookRental(null, data.bookPublication, null,null, null);
        System.out.println(RentalData.bookRental == null);
        ArrayList<BookPublication> p = RentalData.bookRental.searchPublication(searchKey);

        //for (BookPublication p:searchedPublications) System.out.println(((Book)p.getProduct()).getBookTitle());

       // System.out.println("Size: " + p.size());
        resultName.setText(((Book)p.get(0).getProduct()).getBookTitle());
        if(((Book)p.get(0).getProduct()).getId() == 1)
            resultImage.setImage(new Image("UI/Images/calıkusu.jpg"));
        else if(((Book)p.get(0).getProduct()).getId() == 2)
            resultImage.setImage(new Image("UI/Images/sefiller.jpg"));
        else if(((Book)p.get(0).getProduct()).getId() ==  3)
            resultImage.setImage(new Image("UI/Images/lordofrings.jpg"));
        else if(((Book)p.get(0).getProduct()).getId() == 4)
            resultImage.setImage(new Image("UI/Images/imprpb.jpg"));
        else if(((Book)p.get(0).getProduct()).getId() == 5)
            resultImage.setImage(new Image("UI/Images/hungergames.jpg"));
        else if(((Book)p.get(0).getProduct()).getId() == 6)
            resultImage.setImage(new Image("UI/Images/warandpeace.jpg"));


    }

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
