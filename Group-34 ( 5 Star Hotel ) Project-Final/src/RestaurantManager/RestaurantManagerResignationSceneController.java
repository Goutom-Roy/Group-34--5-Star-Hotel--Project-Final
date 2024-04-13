/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import Accountant.*;
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
import javafx.scene.control.DatePicker;
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
public class RestaurantManagerResignationSceneController implements Initializable {

    @FXML
    private MenuBar MenuBar;
    @FXML
    private ComboBox<String> DepartmentComboBox;
    @FXML
    private TextField ReasonForResignationTextField;
    @FXML
    private DatePicker ResignationDatePicker;
    @FXML
    private ComboBox<String> JobTitleComboBox;
    @FXML
    private TextField ResignationLetterTextField;
     Alert UnfilledLetter=new Alert(Alert.AlertType.WARNING,"Please Enter your Resignation Letetr");
    Alert UnSelectDapartment=new Alert(Alert.AlertType.WARNING,"Please Select your department");
    Alert UnselectJobTitle=new Alert(Alert.AlertType.WARNING,"Please select your job Position");
    Alert UnfilledReason=new Alert(Alert.AlertType.WARNING,"Please enter your reason for resignation");
    Alert unDate=new Alert(Alert.AlertType.WARNING,"Please Select your resignation date");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          DepartmentComboBox.getItems().addAll("Executive Management","Information Technology","Food Preparation","Sales and Marketing","Accounts","Front Office","Human Resources(HR)");
       JobTitleComboBox.getItems().addAll("Chief Executive Officer(CEO)","IT Manager","Revenue Manager","Sales Manager","Restaurant Manager","Accountant","Hotel Receiptionist","Security Manager","Staff Manager");
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show(); 
    }

    @FXML
    private void submitResignationBuutonOnClick(ActionEvent event) {
           String department=DepartmentComboBox.getValue();
        if(department.isEmpty()){
             UnSelectDapartment.show();
             return;
        }
         String jobTitle=JobTitleComboBox.getValue();
        if(jobTitle==null){
            UnselectJobTitle.show();
             return;
        }
        String reason=ReasonForResignationTextField.getText();
        if(reason.isEmpty()){
            UnfilledReason.show();
             return;
        }
        String letter=ResignationLetterTextField.getText();
        if(letter.isEmpty()){
           UnfilledLetter.show();
             return;
        }
        LocalDate date= ResignationDatePicker.getValue();
        if(date==null){
           unDate.show();
             return;
        }
          try {
            FileWriter w = new FileWriter("RestaurantManagerResignation.bin",true);
            w.write( ResignationDatePicker.getValue().toString() +";"+ DepartmentComboBox.getValue().toString()+";"+ 
             JobTitleComboBox.getValue().toString()+";"+ReasonForResignationTextField.getText().toString()+";"+ResignationLetterTextField.getText().toString()+"\n"); 
            w.close();
            
           ResignationDatePicker.setValue(null);
             DepartmentComboBox.setValue(null);
              JobTitleComboBox.setValue(null);
            //datePicker.setValue(null);
           ReasonForResignationTextField.clear();
           ResignationLetterTextField.clear();
          
           
            
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Your resignation has been submitted");
            
            
        }catch (Exception e) {
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
    
}
