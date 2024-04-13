/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author gouto
 */
public class ForgotPasswordAndUpdatepassSceneController implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> gendercomboBoxTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    private AnchorPane emailAnchorpane;
    @FXML
    private AnchorPane updatepassAnchorPane;
    @FXML
    private PasswordField newPassWordTextField;
    @FXML
    private PasswordField confirmPassWordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
             gendercomboBoxTextField.getItems().addAll("Male", "Female", "Other");
        
              userComboBox.getItems().addAll("CEO", "IT Manager", "Sales Manager", "Revenue Manager",
                "Restaurant Manager", "Accountant", "Hotel Receptionist",
                "Security Manager", "Customer", "Staff");
        emailAnchorpane.setVisible(true);
        updatepassAnchorPane.setVisible(false);
    }    

    @FXML
    private void proceedOnActionButton(ActionEvent event) {
            
        String email = emailTextField.getText();
        String gender=gendercomboBoxTextField.getValue().toString();
        String dob = datePicker.getValue().toString();
        String user=userComboBox.getValue().toString();
        
        boolean found = false;
        String userEmail = "";
        String usergender = "";       
        String userDob = "";
        String user1 = "";
        try {
             File file = new File("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/LoginUserDetails.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[;\n]");
            
                while (scanner.hasNext() && !found) {
                userEmail = scanner.next();
                scanner.next(); // Skip password field
                user1=scanner.next();        // user role field
                usergender=scanner.next(); //  gender field
                userDob = scanner.next();  // date of birth

                
                if (email.equals(userEmail) &&  user.equals(user1)&& gender.equals(usergender)&& dob.equals(userDob)) {
                    // Match found
                    // Implement your logic to reset the password
                    // For example, update the password in the user data file
                    // Or send a temporary password to the user's email
                    
                    // In this example, we'll just display a message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Password Reset");
                    alert.setHeaderText(null);
                    alert.setContentText("Continue to Password reset !");
                    alert.showAndWait();
                    
                    found = true;
                }
                }
                
                scanner.close();
            
            if (!found) {
                // No matching email and date of birth found
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Email and Date of Birth do not match.");
                alert.showAndWait();
                return;
            }


        emailAnchorpane.setVisible(false);
        updatepassAnchorPane.setVisible(true);
                
        } catch (Exception e) {
        }    
    }

    @FXML
    private void updatepassOnAction(ActionEvent event) {
        
    String newPassword = newPassWordTextField.getText();
    String confirmPassword = confirmPassWordTextField.getText();
    
       // Check if new password and confirmed password match

       
       try {
        File file = new File("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/LoginUserDetails.txt");
         File passInfoFile = new File("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/Updatepassinfo.txt");
        File userInfoFile = new File("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/LoginUserInfo.txt");
        File tempFile = new File("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/LoginUserDetails_temp.txt");
         
        Scanner userScanner = new Scanner(userInfoFile);
         FileWriter userWriter = new FileWriter(userInfoFile);
        Scanner scanner = new Scanner(file);
         FileWriter passInfoWriter = new FileWriter(passInfoFile, true);
        FileWriter writer = new FileWriter(tempFile);
        
      if (!newPassWordTextField.getText().equals(confirmPassWordTextField.getText())) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("New password and confirmed password do not match.");
        alert.showAndWait();
        
        return;  
            
    }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            String email = parts[0];
            String password = parts[1];
            String role = parts[2];
            String gender = parts[3];
            String dob = parts[4];

            // Update the password if the email matches
            if (email.equals(emailTextField.getText()) && role.equals(userComboBox.getValue())) {
                
             password =  newPassword; // Update password
             passInfoWriter.write(email + ";" + role + ";" + gender + ";" + dob+";"+LocalDate.now()+ "\n");
             passInfoWriter.close();
                
            }

            // Write the updated line to the temporary file
            writer.write(email + ";" + password + ";" + role + ";" + gender + ";" + dob + "\n");
            
             // Write the updated line to the file
            userWriter.write(email + ";" + password + ";" + role + "\n");
             
        }

        scanner.close();
        writer.close();
       
        
        userScanner.close();
        userWriter.close();
         
        
        // Delete the original file and rename the temporary file to the original filename
        if (!file.delete()) {
            System.out.println("Error deleting file");
            return;
        }
        if (!tempFile.renameTo(file)) {
            System.out.println("Error renaming file");
            return;
        }
   
        // Display a confirmation message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Password Updated");
        alert.setHeaderText(null);
        alert.setContentText("Password updated successfully!");
        alert.showAndWait();
//-------------------------------------------------------------------
        Parent Loginpage = FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
        Scene scene = new Scene(Loginpage);
        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        addStage.setScene(scene);
        addStage.show();

    } catch (IOException e) {
           System.out.println(e);
    }
       
    } 
    
}
