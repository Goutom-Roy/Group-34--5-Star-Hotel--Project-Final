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
public class RestaurantManagerFeedbackSceneController implements Initializable {

    @FXML
    private MenuBar MenuBar;
    @FXML
    private ComboBox<String> DepartmentComboBox;
    @FXML
    private DatePicker FeedbackDatePicker;
    @FXML
    private ComboBox<String> JobTitleComboBox;
    @FXML
    private TextField FeedbackTextField;
    @FXML
    private ComboBox<String> RatingComboBox;
    Alert UnfilledFeedback=new Alert(Alert.AlertType.WARNING,"Please Enter your feedback ");
    Alert UnSelectDapartment=new Alert(Alert.AlertType.WARNING,"Please Select your department");
    Alert UnselectJobTitle=new Alert(Alert.AlertType.WARNING,"Please select your job Position");
    Alert UnfilledRating=new Alert(Alert.AlertType.WARNING,"Please select rating");
    Alert unDate=new Alert(Alert.AlertType.WARNING,"Please Select your feedback date");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       DepartmentComboBox.getItems().addAll("Executive Management","Information Technology","Food Preparation","Sales and Marketing","Accounts","Front Office","Human Resources(HR)");
       JobTitleComboBox.getItems().addAll("Chief Executive Officer(CEO)","IT Manager","Revenue Manager","Sales Manager","Restaurant Manager","Accountant","Hotel Receiptionist","Security Manager","Staff Manager");
       RatingComboBox.getItems().addAll("1","2","3","4","5");
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
    private void submitFeedbackBuutonOnClick(ActionEvent event) {
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
        String rating=RatingComboBox.getValue();
        if(rating==null){
            UnfilledRating.show();
             return;
        }
        String feedbackBox=FeedbackTextField.getText();
        if(feedbackBox.isEmpty()){
           UnfilledFeedback.show();
             return;
        }
        LocalDate date=  FeedbackDatePicker.getValue();
        if(date==null){
           unDate.show();
             return;
        }
          try {
            FileWriter w = new FileWriter("EmployeeFeedback.bin",true);
            w.write( FeedbackDatePicker.getValue().toString() +";"+ DepartmentComboBox.getValue().toString()+";"+ 
             JobTitleComboBox.getValue().toString()+";"+RatingComboBox.getValue().toString()+";"+FeedbackTextField.getText().toString()+"\n"); 
            w.close();
            
          FeedbackDatePicker.setValue(null);
             DepartmentComboBox.setValue(null);
              JobTitleComboBox.setValue(null);
              RatingComboBox.setValue(null);
              
            //datePicker.setValue(null);
          FeedbackTextField.clear();
          
          
           
            
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Your feedback has been submitted");
            
            
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
