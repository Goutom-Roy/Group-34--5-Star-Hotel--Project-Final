/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import ModelClass.Due;
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
public class TaxDetailsController implements Initializable {

    @FXML
    private TableColumn<Tax,LocalDate> DueDateTableColumn;
    @FXML
    private TableColumn<Tax,String> StatusTableColumn;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private TableView<Tax> DueTaxTable;
    @FXML
    private TableColumn<Tax,String> TaxIdTableColumn;
    @FXML
    private TableColumn<Tax,String> TaxTypeTableColumn;
    @FXML
    private TableColumn<Tax,String> AmountTableColumn;
    Alert UnselectTax=new Alert(Alert.AlertType.WARNING,"Please Select row from the table");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         TaxIdTableColumn.setCellValueFactory(new PropertyValueFactory<Tax, String>("taxId"));
      TaxTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Tax, String>("taxType"));
        
       DueDateTableColumn.setCellValueFactory(new PropertyValueFactory<Tax,LocalDate>("dueDate"));
        AmountTableColumn.setCellValueFactory(new PropertyValueFactory<Tax, String>("amount"));
        StatusTableColumn.setCellValueFactory(new PropertyValueFactory<Tax, String>("status"));
       
        
      DueTaxTable.setItems(this. getTax());
        // TODO
    }
     public ObservableList<Tax>    getTax(){
       ObservableList<Tax> TaxDetailsList=FXCollections.observableArrayList(); 
       TaxDetailsList.add(new Tax("TX001","Income Tax",LocalDate.of(2024, Month.APRIL, 23),"100000","Pending"));
       TaxDetailsList.add(new Tax("TX002","Property Tax",LocalDate.of(2024, Month.MAY, 7),"10000","Pending"));
       TaxDetailsList.add(new Tax("TX003","Sales Tax",LocalDate.of(2024, Month.JUNE, 17),"55000","Pending"));
       TaxDetailsList.add(new Tax("TX004","Value Added Tax",LocalDate.of(2024, Month.APRIL, 30),"75000","Pending"));
       TaxDetailsList.add(new Tax("TX005","Local Tax",LocalDate.of(2024, Month.MARCH, 17),"49000","Not Paid"));
       TaxDetailsList.add(new Tax("TX006","Occupancy Tax",LocalDate.of(2024, Month.MARCH, 10),"63000","Not Paid"));
       TaxDetailsList.add(new Tax("TX007","Luxury Tax",LocalDate.of(2024, Month.MARCH, 9),"40000","Not Paid"));
    
       
       return   TaxDetailsList;
    }
        // TODO
        

    @FXML
    private void payTaxButtonOnClick(ActionEvent event) throws IOException {
           Parent back=FXMLLoader.load(getClass().getResource("PayTax.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
    }

    @FXML
    private void viewPastTaxRecordsButtonOnClick(ActionEvent event) throws IOException {
          Parent back=FXMLLoader.load(getClass().getResource("PastTaxRecords.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
           Parent back=FXMLLoader.load(getClass().getResource("DueTaxNotification.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
    }

    @FXML
    private void viewSelectedTaxDetailsButtonOnclick(ActionEvent event) throws IOException {
        Tax Selectedtax=DueTaxTable.getSelectionModel().getSelectedItem();
        if(Selectedtax==null){
             UnselectTax.show();
            return;
        }
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSelectedTaxDetails.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene ExpenseDetailsScene = new Scene(parent);
        currentStage.setScene( ExpenseDetailsScene );
        currentStage.show();
      ViewSelectedTaxDetailsController controller=loader.getController();
        controller.initData( DueTaxTable.getSelectionModel().getSelectedItem());
    }
    
}
