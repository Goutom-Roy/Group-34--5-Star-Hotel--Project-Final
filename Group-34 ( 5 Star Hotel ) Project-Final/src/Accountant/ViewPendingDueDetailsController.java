/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import ModelClass.Due;
import ModelClass.Expense;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewPendingDueDetailsController implements Initializable {

    @FXML
    private TableView<Due> ViewPendingDueTableView;
    @FXML
    private TableColumn<Due, String> supplierTableColumn;
    @FXML
    private TableColumn<Due, String> InvoiceNumberTableColumn;
    @FXML
    private TableColumn<Due,LocalDate> InvoiceDateTableColumn;
    @FXML
    private TableColumn<Due,LocalDate> DueDateTableColumn;
    @FXML
    private TableColumn<Due, String> AmountTableColumn;
    @FXML
    private TableColumn<Due, String> StatusTableColumn;
    
    @FXML
    private MenuBar MenuBar;
    @FXML
    private TableColumn<Due, String> PayMethodtableColumn;
    Alert UnselectDue=new Alert(Alert.AlertType.WARNING,"Please Select row from the table");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         supplierTableColumn.setCellValueFactory(new PropertyValueFactory<Due, String>("supplier"));
      InvoiceNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Due, String>("inVoiceNumber"));
        InvoiceDateTableColumn.setCellValueFactory(new PropertyValueFactory<Due,LocalDate>("inVoiceDate"));
       DueDateTableColumn.setCellValueFactory(new PropertyValueFactory<Due,LocalDate>("dueDate"));
        AmountTableColumn.setCellValueFactory(new PropertyValueFactory<Due, String>("amount"));
        StatusTableColumn.setCellValueFactory(new PropertyValueFactory<Due, String>("satus"));
       PayMethodtableColumn.setCellValueFactory(new PropertyValueFactory<Due, String>("paymentMethod"));
        
      ViewPendingDueTableView.setItems(this. getPendingDue());
        // TODO
    }
     public ObservableList<Due>    getPendingDue(){
       ObservableList<Due> PendingDueDetails=FXCollections.observableArrayList(); 
       PendingDueDetails.add(new Due("Power Utility Co","INV-2024-001",LocalDate.of(2024, Month.MARCH, 19),LocalDate.of(2024, Month.APRIL, 23),"31000","Pending","Bank Transfer"));
       PendingDueDetails.add(new Due("Maintenance Inc","INV-2024-001",LocalDate.of(2024, Month.MARCH, 25),LocalDate.of(2024, Month.APRIL, 27),"40000","Pending","Credit Card"));
       PendingDueDetails.add(new Due("Linen Supplies Co","INV-2024-002",LocalDate.of(2024, Month.MARCH, 21),LocalDate.of(2024, Month.APRIL, 30),"10000","Pending","Bank Transfer"));
       PendingDueDetails.add(new Due("Golden Harvest Enterprises","INV-2024-004",LocalDate.of(2024, Month.APRIL, 3),LocalDate.of(2024, Month.MAY, 3),"27000","Pending","Bank Transfer"));
       PendingDueDetails.add(new Due("Nexus Supply Co.","INV-2024-005",LocalDate.of(2024, Month.APRIL, 9),LocalDate.of(2024, Month.APRIL, 21),"53000","Pending","Bank Transferr"));
       
       
       return  PendingDueDetails;
    }
    

    @FXML
    private void payPendingDueButtonOnClick(ActionEvent event) throws IOException {
         Parent sceneParent = FXMLLoader.load(getClass().getResource("PayPendingDue.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage stg = (Stage)MenuBar.getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void viewPastDueDetailsButtonOnClick(ActionEvent event) throws IOException {
         Parent sceneParent = FXMLLoader.load(getClass().getResource("ViewPastDueRecords.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage stg = (Stage)MenuBar.getScene().getWindow();
        stg.setScene(scene);
        stg.show();
        
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
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
    }

    @FXML
    private void viewSelectedDueDetailsButtonOnclick(ActionEvent event) throws IOException {
        Due SelectedDue=ViewPendingDueTableView.getSelectionModel().getSelectedItem();
        if(SelectedDue==null){
            UnselectDue.show();
            return;
        }
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSelectedDueDetails.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene ExpenseDetailsScene = new Scene(parent);
        currentStage.setScene( ExpenseDetailsScene );
        currentStage.show();
      ViewSelectedDueDetailsController controller=loader.getController();
        controller.initData( ViewPendingDueTableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("DueNotificationScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
