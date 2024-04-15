/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import ModelClass.CustomerIssue;
import ModelClass.Tax;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CustomerIssueController implements Initializable {

    @FXML
    private TableView<CustomerIssue> CustomerIssueDetailsTable;
    @FXML
    private TableColumn<CustomerIssue,String> CustomerIsTableCo;
    @FXML
    private TableColumn<CustomerIssue,String> CustomerNameTableCo;
    @FXML
    private TableColumn<CustomerIssue,String> ContactInformationTableCo;
    @FXML
    private TableColumn<CustomerIssue,String> IssueTypeTableCo;
    @FXML
    private TableColumn<CustomerIssue,String> DescriptionTableCo;
    @FXML
    private TableColumn<CustomerIssue,String> StatusTableCo;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private TableColumn<CustomerIssue,LocalDate> SubmittedDateTableCo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         CustomerIsTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,String>("customerId"));
       CustomerNameTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,String>("customerName"));
        
      
        ContactInformationTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,String>("customerContactInfo"));
       IssueTypeTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,String>("IssueType"));
         DescriptionTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,String>("description"));
       StatusTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,String>("status"));
          SubmittedDateTableCo.setCellValueFactory(new PropertyValueFactory<CustomerIssue,LocalDate>("submittedDate"));
     CustomerIssueDetailsTable.setItems(this.getCustomerIssue());
       
        // TODO
    }
      public ObservableList<CustomerIssue>    getCustomerIssue(){
       ObservableList<CustomerIssue> IssueList=FXCollections.observableArrayList(); 
        IssueList.add(new CustomerIssue("37346","Ms Fatema Khatun","fatemakhatun2039@gmail.com","Technical Issue","Unable to Place an online order","Not Resolved",LocalDate.of(2024, Month.APRIL, 3)));
        IssueList.add(new CustomerIssue("37389","Ms Jannatul Khatun","jannat1927@gmail.com","Product Issue","Hair Found in salad","Not Resolved",LocalDate.of(2024, Month.APRIL, 9)));
        IssueList.add(new CustomerIssue("25347","Mr Rahman Khan","rahimkhan7383@gmail.com","Incorrect Order","Receive Wrong pizza topings","Not Resolved",LocalDate.of(2024, Month.APRIL, 10)));
        IssueList.add(new CustomerIssue("94876","Mr Shahadat Chowdury","shahadat9586@gmail.com","Order Cancalletion","Change in planes,requested resarvation cancel","Not Resolved",LocalDate.of(2024, Month.APRIL, 10)));
        //IssueList.add(new CustomerIssue("13093","Mr Shahin Rahman","fatemakhatun2039@gmail.com","Technical Issue","Change in planes,requested resarvation cancel","Not Resolved",LocalDate.of(2024, Month.APRIL, 03)));
        return  IssueList;
      }
    @FXML
    private void solveCustomerIssuesButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("SolveCustomerIssue.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Logout Successfully");
        alert.setContentText("Do you want to Logout ? If not then click Cancel");
        
        if(alert.showAndWait().get()==ButtonType.OK){
        Parent singup=FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
    }
    
}
