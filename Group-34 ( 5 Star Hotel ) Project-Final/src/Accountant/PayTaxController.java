/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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
public class PayTaxController implements Initializable {

    @FXML
    private ComboBox<String> TaxidComboBox;
    @FXML
    private TextField TaxTypeTextField;
    @FXML
    private TextField DueDateTextField;
    @FXML
    private TextField AmountTextField;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private TextField StatusTextField;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    Alert UnselectTaxIdCombo=new Alert(Alert.AlertType.WARNING,"Please Select Tax Id");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       TaxidComboBox.getItems().addAll("TX001","TX002","TX003","TX004","TX005","TX006","TX007");
        paymentMethodComboBox.getItems().addAll("Bank Transfer","credit Card","Mobile Banking","bKash","Nagad","Roket","Cash");
        // TODO
    }    


    @FXML
    private void payButtonOnClick(ActionEvent event) {
        String taxId= TaxidComboBox.getValue();
        if(taxId.isEmpty()){
             UnselectTaxIdCombo.show();
             return;
        }
        try {
            FileWriter w = new FileWriter("TaxPayments.bin",true);
            w.write(  TaxidComboBox.getValue().toString() +";"+ TaxTypeTextField.getText().toString()+";"+ 
              DueDateTextField.getText().toString()+";"+AmountTextField.getText().toString()+";"+  StatusTextField.getText().toString()+";"+ paymentMethodComboBox.getValue().toString()+"\n"); 
            w.close();
            TaxidComboBox.setValue(null);
          TaxTypeTextField.clear();
            
            //datePicker.setValue(null);
           DueDateTextField.clear();
           AmountTextField.clear();
          paymentMethodComboBox.setValue(null);
           StatusTextField.clear();
           
            
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Tax Paid Successfully");
            
            
        } catch (Exception e) {
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
          Parent back=FXMLLoader.load(getClass().getResource("TaxDetails.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void taxIDComboBoxOnSelect(ActionEvent event) {
         switch (TaxidComboBox.getValue()) {
            case "TX001":
                TaxTypeTextField.setText("Income Tax");
                
                DueDateTextField.setText("2024-04-23");
                AmountTextField.setText("100000BDT");
               
                StatusTextField.setText("Pending");
                break;
            case "TX002":
                TaxTypeTextField.setText("Property Tax");
                
                DueDateTextField.setText("2024-05-07");
                AmountTextField.setText("10000BDT");
               
                StatusTextField.setText("Pending");
                break;
            case "TX003":
                TaxTypeTextField.setText("Sales Tax");
                
                DueDateTextField.setText("2024-06-17");
                AmountTextField.setText("55000BDT");
               
                StatusTextField.setText("Pending");
                break;
            case "TX004":
                TaxTypeTextField.setText("Value Added Tax");
                
                DueDateTextField.setText("2024-04-30");
                AmountTextField.setText("75000BDT");
               
                StatusTextField.setText("Pending");
                break;
            case "TX005":
                TaxTypeTextField.setText("Local Tax Tax");
                
                DueDateTextField.setText("2024-03-17");
                AmountTextField.setText("49000BDT");
               
                StatusTextField.setText("Not Paid");
                break;
            case "TX006":
                TaxTypeTextField.setText("Occupancy Tax");
                
                DueDateTextField.setText("2024-03-10");
                AmountTextField.setText("63000BDT");
               
                StatusTextField.setText("Not Paid");
                break;
            case "TX007":
                TaxTypeTextField.setText("Luxury Tax");
                
                DueDateTextField.setText("2024-03-09");
                AmountTextField.setText("40000BDT");
               
                StatusTextField.setText("Not Paid");
                break;
        
        }
    
    }
}
