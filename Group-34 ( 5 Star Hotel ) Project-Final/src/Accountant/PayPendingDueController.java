/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import ModelClass.Due;
import ModelClass.Expense;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PayPendingDueController implements Initializable {

    @FXML
    private ComboBox<String> SupplierNameComboBox;
    @FXML
    private TextField InvoiceNumberTextField;
    @FXML
    private TextField InvoiceDateTextField;
    @FXML
    private TextField DueDateTextField;
    @FXML
    private TextField AmountTextField;
    private ComboBox<String> PaymentmethodComboBox;
    @FXML
    private MenuBar MenuBar;
     Alert unfilledTextField=new Alert(Alert.AlertType.WARNING,"Please enter everything");
     Alert unfilledSupplierNameComBox=new Alert(Alert.AlertType.WARNING,"Please Choose Supplier Name");
      //Alert unfilledPaymentMethod=new Alert(Alert.AlertType.WARNING,"Please Choose Payment Method");

    //Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added");
    Alert addedPay=new Alert(Alert.AlertType.INFORMATION,"Successfully Paid");
    @FXML
    private TextField PaymentMethodTextField;
    @FXML
    private TextField StatusTextField;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SupplierNameComboBox.getItems().addAll("Power Utility Co","Maintenance Inc","Linen Supplies Co","Fresh Foods Inc.","Golden Harvest Enterprises","Nexus Supply Co.");
         //PaymentmethodComboBox.getItems().addAll("Cash","Credit Card","Bank Transfer");
        // TODO
    }    

    @FXML
    private void supplierNameComboBoxOnSelect(ActionEvent event) {
         switch (SupplierNameComboBox.getValue()) {
            case "Power Utility Co":
                InvoiceNumberTextField.setText("INV-2024-001");
                InvoiceDateTextField.setText("2024-03-19");
                DueDateTextField.setText("2024-04-23");
                AmountTextField.setText("310000BDT");
                PaymentMethodTextField.setText("Bank Transfer");
                StatusTextField.setText("Pending");
                break;
            case "Maintenance Inc":
               InvoiceNumberTextField.setText("INV-2024-002");
                InvoiceDateTextField.setText("2024-03-25");
                DueDateTextField.setText("2024-04-27");
                AmountTextField.setText("40000BDT");
                PaymentMethodTextField.setText("Credit Card");
                StatusTextField.setText("Pending");
                break;
                
            case "Linen Supplies Co":
                InvoiceNumberTextField.setText("INV-2024-003");
                InvoiceDateTextField.setText("2024-03-21");
                DueDateTextField.setText("2024-04-17");
                AmountTextField.setText("150000BDT");
                 PaymentMethodTextField.setText("Bank Transfer");
                StatusTextField.setText("Pending");
                break;
            case "Fresh Foods Inc.":
                InvoiceNumberTextField.setText("INV-2024-004");
                InvoiceDateTextField.setText("2024-03-27");
                DueDateTextField.setText("2024-04-30");
                AmountTextField.setText("10000BDT");
                 PaymentMethodTextField.setText("Bank Transfer");
                StatusTextField.setText("Pending");
                break;
            case "Golden Harvest Enterprises":
               InvoiceNumberTextField.setText("INV-2024-005");
                InvoiceDateTextField.setText("2024-04-03");
                DueDateTextField.setText("2024-05-03");
                AmountTextField.setText("270000BDT");
                 PaymentMethodTextField.setText("Bank Transfer");
                StatusTextField.setText("Pending");
                break;
            case "Nexus Supply Co.":
                InvoiceNumberTextField.setText("INV-2024-006");
                InvoiceDateTextField.setText("2024-04-09");
                DueDateTextField.setText("2024-04-21");
                AmountTextField.setText("530000BDT");
                 PaymentMethodTextField.setText("Bank Transfer");
                StatusTextField.setText("Pending");
                break;
           

        }
        
    }

    @FXML
    private void payButtonOnClick(ActionEvent event) {
         String SupplierName=SupplierNameComboBox.getValue();
        if(SupplierName.isEmpty()){
              unfilledSupplierNameComBox.show();
             return;
        }
//        String InvoiceNumber=ExpenseDescriptionTextField.getText();
//        if(expDescription.isEmpty()){
//             unfilledTextField.show();
//             return;
//        }
//        String InvoiceDate=AmountTextField.getText();
//        if(aMount.isEmpty()){
//              unfilledTextField.show();
//             return;
//        }
//        String payMethod=PaymentmethodComboBox.getValue();
//        if( payMethod.isEmpty()){
//             unfilledPaymentMethod.show();
//             return;
//        }
         try {
            FileWriter w = new FileWriter("DuePayments.bin",true);
            w.write( SupplierNameComboBox.getValue().toString() +";"+ InvoiceNumberTextField.getText().toString()+";"+ 
              InvoiceDateTextField.getText().toString()+";"+DueDateTextField.getText().toString()+";"+AmountTextField.getText().toString()+";"+  PaymentMethodTextField.getText().toString()+";"+ StatusTextField.getText().toString()+"\n"); 
            w.close();
            
           InvoiceNumberTextField.clear();
             InvoiceDateTextField.clear();
            //datePicker.setValue(null);
           DueDateTextField.clear();
           AmountTextField.clear();
           PaymentMethodTextField.clear();
           StatusTextField.clear();
           
            
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Successfully Paid");
            
            
        } catch (Exception e) {
        }
//        String suPPlier=ExpenseCatagoryComboBox.getValue();
//        if(suPPlier.isEmpty()){
//            unfilledTextField.show();
//             return;
//        }
        
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
    private void backButtonOnClick(ActionEvent event) throws IOException {
      Parent back=FXMLLoader.load(getClass().getResource("ViewPendingDueDetails.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}

//    @FXML
//    private void returnToDashboardButtonOnClick(ActionEvent event) {
//    }
//
//    @FXML
//    private void logOutButtonOnClick(ActionEvent event) {
//    }
//
//    @FXML
//    private void backButtonOnClick(ActionEvent event) {
//    }
