/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import ModelClass.Due;
import ModelClass.Food;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewPastDueRecordsController implements Initializable {

    @FXML
    private TableView<Due> ViewPastDueTableRecord;
    @FXML
    private TableColumn<Due,String> supplierTableColumn;
    @FXML
    private TableColumn<Due,String> InvoiceNumberTableColumn;
    @FXML
    private TableColumn<Due,LocalDate> InvoiceDateTableColumn;
    @FXML
    private TableColumn<Due,LocalDate> DueDateTableColumn;
    @FXML
    private TableColumn<Due,String> AmountTableColumn;
    @FXML
    private TableColumn<Due,String> StatusTableColumn;
    @FXML
    private TableColumn<Due,String> PayMethodtableColumn;
    @FXML
    private MenuBar MenuBar;
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
        
      ViewPastDueTableRecord.setItems(this.  getPastDueRecord());
       ViewPastDueTableRecord.setEditable(true);
       supplierTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      InvoiceNumberTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //InvoiceDateTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //DueDateTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        AmountTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        StatusTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
         ViewPastDueTableRecord.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

         try {
            
       
        FileReader f= new FileReader("DuePayments.bin");
        
        BufferedReader reader = new BufferedReader(f);
        
            String line;
            while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] fields = line.split(";");
            String supplier = fields[0];
            String invoiceNumber = fields[1];
            LocalDate invoiceDate = LocalDate.parse(fields[2]);
            LocalDate dueDate = LocalDate.parse(fields[3]);
            String amount = fields[4];
            String status = fields[5];
            String payMethod = fields[6];
//            LocalDate date = LocalDate.parse(fields[2]);
//            String location =fields[3];
          Due d=new Due(supplier,invoiceNumber,invoiceDate,dueDate,amount,status,payMethod);
           ViewPastDueTableRecord.getItems().add(d);
          

        }
         } catch (Exception e) {
        }
        // TODO
    }
     public ObservableList<Due>    getPastDueRecord(){
       ObservableList<Due> PastDueDetails=FXCollections.observableArrayList(); 
       PastDueDetails.add(new Due("Power Utility Co","INV-2024-001",LocalDate.of(2024, Month.MARCH, 19),LocalDate.of(2024, Month.APRIL, 23),"31000","Paid","Bank Transfer"));
       PastDueDetails.add(new Due("Maintenance Inc","INV-2024-001",LocalDate.of(2024, Month.MARCH, 25),LocalDate.of(2024, Month.APRIL, 27),"40000","Paid","Credit Card"));
       PastDueDetails.add(new Due("Linen Supplies Co","INV-2024-002",LocalDate.of(2024, Month.MARCH, 21),LocalDate.of(2024, Month.APRIL, 30),"10000","Paid","Bank Transfer"));
       PastDueDetails.add(new Due("Golden Harvest Enterprises","INV-2024-004",LocalDate.of(2024, Month.APRIL, 3),LocalDate.of(2024, Month.MAY, 3),"27000","Paid","Bank Transfer"));
       PastDueDetails.add(new Due("Nexus Supply Co.","INV-2024-005",LocalDate.of(2024, Month.APRIL, 9),LocalDate.of(2024, Month.APRIL, 21),"53000","Paid","Bank Transferr"));
       
       
       return  PastDueDetails;
    }
    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
            Parent back=FXMLLoader.load(getClass().getResource("ViewPendingDueDetails.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
        
        
    }

    @FXML
    private void closeButtonOnClick(ActionEvent event) {
       
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
         Due SelectedDue=ViewPastDueTableRecord.getSelectionModel().getSelectedItem();
        if(SelectedDue==null){
            UnselectDue.show();
            return;
        }
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSelectedPastDueRecords.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene ExpenseDetailsScene = new Scene(parent);
        currentStage.setScene( ExpenseDetailsScene );
        currentStage.show();
      ViewSelectedPastDueRecordsController controller=loader.getController();
        controller.initData(  ViewPastDueTableRecord.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void supplierTableColumnOnEdit(CellEditEvent event) {
        
    }

    @FXML
    private void inVoiceNumberTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void inVoiceDateTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void dueDateTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void amountTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void statusTableColumnOnEdit(CellEditEvent event) {
       Due SelectedDue=ViewPastDueTableRecord.getSelectionModel().getSelectedItem();
       SelectedDue.setSatus(event.getNewValue().toString());
    }

    @FXML
    private void paymethodTableColumnOnedit(CellEditEvent event) {
    }
    
}
