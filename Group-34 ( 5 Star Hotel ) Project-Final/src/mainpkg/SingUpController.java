/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package mainpkg;


import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class SingUpController implements Initializable {

    @FXML
    private PasswordField passwordTextField;
    @FXML
    private ComboBox<String> genderComboBox;
    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private TextField emailTextField;
    @FXML
    private DatePicker DatePickerTextField;
    @FXML
    private Label labelTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userComboBox.getItems().addAll("CEO", "IT Manager", "Sales Manager", "Revenue Manager",
                "Restaurant Manager", "Accountant", "Hotel Receptionist",
                "Security Manager", "Customer", "Staff");
        genderComboBox.getItems().addAll("Male", "Female", "Other");
    }

    @FXML
    private void signUpButtonOnClick(MouseEvent event) throws IOException {
        String email = emailTextField.getText().toString();
        try {
     
     FileWriter w = new FileWriter("LoginUserInfo.txt",true);
      FileWriter w1 = new FileWriter("LoginUserDetails.txt",true);
      
// Email Validation check  

      if (email.endsWith("@gmail.com")) {

      w.write( emailTextField.getText().toString() +";"+ passwordTextField.getText().toString()+";"+ 
              userComboBox.getValue().toString()+"\n"); 
      
      w1.write( emailTextField.getText().toString() +";"+ passwordTextField.getText().toString()+";"+ 
              userComboBox.getValue().toString()+";"+genderComboBox.getValue().toString()+";"+DatePickerTextField.getValue().toString()+"\n"); 
      }else{
       JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Enter valite Email ");
       return;
      }
      w1.close();
       w.close();
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, " Registration Completed");
     
       Parent Loginpage = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene = new Scene(Loginpage);
        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        addStage.setScene(scene);
        addStage.show();
        
          } catch (Exception e) {
         
              labelTextField.setText("Please Enter all Infomation ");
              
        }
}
}
