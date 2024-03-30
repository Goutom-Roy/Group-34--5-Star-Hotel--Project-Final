/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private ComboBox<String> userComboBox;
   
    @FXML
    private TextField passwordShowTextField;
    @FXML
    private ImageView hideEye;
    @FXML
    private ImageView showEye;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      userComboBox.getItems().addAll("CEO", "IT Manager", "Sales Manager", "Revenue Manager",
                "Restaurant Manager", "Accountant", "Hotel Receptionist",
                "Security Manager", "Customer", "Staff");
      passwordShowTextField.setVisible(false);
      showEye.setVisible(false);
      

            
      
    }   
 

    @FXML
    private void loginButton(ActionEvent event) throws IOException {
        
 //        alert.show();       
        
       if (emailTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " ENTER YOUR EMAIL AND PASSWORD ");
          }
          else if (passwordTextField.getText().isEmpty()){
        JFrame frame = new JFrame();
         JOptionPane.showMessageDialog(frame, " ENTER YOUR PASSWORD  ");
          }
          else if (emailTextField.getText().isEmpty()){         
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " ENTER YOUR EMAIL  ");
          }
      
  
        else if (userComboBox.getValue()==null ){         
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " SELECT USER  ");
        
          }
// ------------------------------------------------------------------------------------      
        boolean found = false;
        String userEmail = "";
        String userPassword ="";
        String userRole="";
        
        try {
           File file = new File("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/LoginUserInfo.txt");
            Scanner x = new Scanner(file);
            x.useDelimiter("[;\n]");
            
                while(x.hasNext() && !found){
                userEmail = x.next();
                userPassword = x.next();
                userRole = x.next();
                
//-----------------------------------------------------------    
//CEO
               if(userComboBox.getValue().equals("CEO")){
                    if(emailTextField.getText().equals(userEmail)
                        && passwordTextField.getText().equals(userPassword) 
                        && userComboBox.getValue().equals(userRole) ){
                        
                                            
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
//                        Parent homepage = FXMLLoader.load(getClass().getResource("/ceo/CEODashboardScene.fxml"));
                        Parent homepage = FXMLLoader.load(getClass().getResource("/ceo/HotelEmployee.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show(); 
                    }

                    return;
                    
                }
               }
//  ---------------------------------------------------------
//IT manager               
               
                              else if(userComboBox.getValue().equals("IT Manager")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/it_manager/IT_ManagerDashBoardScene.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }

                    return ;
                    
                }
               
               }
//-----------------------------------------
//Sales Manager

                    }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No User Found");
            alert.setContentText("SIGN UP FIRST or (GIVEN THE ACCURATE INFORMATION)");
            alert.showAndWait();
            
            
            
//-------------------------------------------------------------------------------------            

                      
        }catch (Exception e) {
            System.out.println(e);
//           

        }
        

    }

    @FXML
    private void singupButton(ActionEvent event) throws IOException {
       Parent singup=FXMLLoader.load(getClass().getResource("SingUp.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void closeEyeOnMouseClicked(MouseEvent event) {
       passwordShowTextField.setText(passwordTextField.getText());
       passwordTextField.setVisible(false);
        passwordShowTextField.setVisible(true);
        showEye.setVisible(true);
        hideEye.setVisible(false);
    }

    @FXML
    private void openEyeOnMouseClicked(MouseEvent event) {
       passwordTextField.setText(passwordShowTextField.getText());
        passwordShowTextField.setVisible(false);
        passwordTextField.setVisible(true);
        hideEye.setVisible(true);
        showEye.setVisible(false);
    }

    @FXML
    private void forgetpasswordOnAction(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("/it_manager/ForgotPasswordAndUpdatepassScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
