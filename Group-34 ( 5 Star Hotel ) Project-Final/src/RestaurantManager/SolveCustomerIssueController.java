/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

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
public class SolveCustomerIssueController implements Initializable {

    @FXML
    private ComboBox<String> CustomerIdComboBox;
    @FXML
    private TextField EmailAddressTextField;
    @FXML
    private TextField IssueTypeTextField;
    @FXML
    private TextField ReplyCustomersIssueTextField;
    Alert unSelectId=new Alert(Alert.AlertType.WARNING,"Please Select Customer Id");
    Alert unfilledIssueSolved=new Alert(Alert.AlertType.WARNING,"Please Enter your solution in the solution box");
    @FXML
    private MenuBar MenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CustomerIdComboBox.getItems().addAll("37346","37389","25347","94876");
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("CustomerIssue.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
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
    private void submitReplyButtonOnClick(ActionEvent event) {
        String customerId=CustomerIdComboBox.getValue();
        if(customerId==null){
             unSelectId.show();
             return;
        }
        
        String soluttionBox=ReplyCustomersIssueTextField.getText();
        if(soluttionBox.isEmpty()){
           unfilledIssueSolved.show();
             return;
        }
        
          try {
            FileWriter w = new FileWriter("Reply_CustomerIssue.bin",true);
            w.write( CustomerIdComboBox.getValue().toString() +";"+ EmailAddressTextField.getText().toString()+";"+ 
             IssueTypeTextField.getText().toString()+";"+ ReplyCustomersIssueTextField.getText().toString()+"\n"); 
            w.close();
            
           CustomerIdComboBox.setValue(null);
             
            //datePicker.setValue(null);
            EmailAddressTextField.clear();
           IssueTypeTextField.clear();
           ReplyCustomersIssueTextField.clear();
          
           
            
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Submitted Successfully");
            
            
        }catch (Exception e) {
        }
        
    }

    @FXML
    private void customerIdComboBoxOnClick(ActionEvent event) {
         switch (CustomerIdComboBox.getValue()) {
            case "37346":
                EmailAddressTextField.setText("fatemakhatun2039@gmail.com");
                IssueTypeTextField.setText("Technical Issue");
                break;
            case "37389":
                EmailAddressTextField.setText("jannat1927@gmail.com");
                IssueTypeTextField.setText("Product Issue");
                break;
            case "25347":
                EmailAddressTextField.setText("rahimkhan7383@gmail.com");
                IssueTypeTextField.setText("Incorrect Order");
                break;
            case "94876":
                EmailAddressTextField.setText("shahadat9586@gmail.com");
                IssueTypeTextField.setText("Order Cancalletion");
                break;
                
        }
    
    }
}
