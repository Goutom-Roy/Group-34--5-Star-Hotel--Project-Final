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
      
 // Add a listener to synchronize passwordShowTextField with passwordTextField
    passwordShowTextField.textProperty().bindBidirectional(passwordTextField.textProperty());
         
      
    }   
 

    @FXML
    private void loginButton(ActionEvent event) throws IOException {
           
        
 //        alert.show();       
        
       if (emailTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " ENTER YOUR EMAIL AND PASSWORD ");
        return;
          }
          else if (passwordTextField.getText().isEmpty()){
        JFrame frame = new JFrame();
         JOptionPane.showMessageDialog(frame, " ENTER YOUR PASSWORD  ");
          return;
          }
          else if (emailTextField.getText().isEmpty()){         
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " ENTER YOUR EMAIL  ");
         return;
          }
      
  
        else if (userComboBox.getValue()==null ){         
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " SELECT USER  ");
        return;
        
          }
        else if(emailTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()&&userComboBox.getValue()==null){       
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, " ENTER YOUR EMAIL , PASSWORD AND USER  ");

        return;
        }

 
// ------------------------------------------------------------------------------------      
        boolean found = false;
        String userEmail = "";
        String userPassword ="";
        String userRole="";
        
        try {
           File file = new File("LoginUserInfo.txt");
            Scanner x = new Scanner(file);
            
 //Scanner will tokenize the input file based on semicolons and newline characters           
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
                        Parent homepage = FXMLLoader.load(getClass().getResource("/ceo/CEODashboardScene.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show(); 
                    }
 // Set found to true when user is found     
            found = true; 
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
                        Parent homepage = FXMLLoader.load(getClass().getResource("/it_manager/IT_ManagerDashboardScene.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               }
//-----------------------------------------
//Sales Manager

                    else if(userComboBox.getValue().equals("Sales Manager")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/Sales_Manager/SalesManagerDashboard.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               }

//--------------------------------------------------------------------------------------------
//Revenue Manager
                    else if(userComboBox.getValue().equals("Revenue Manager")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/Revenue_Manager/RevenueManagerDashboard.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               }
//----------------------------------------------------------------------------------------------
//Restaurant Manager
                    else if(userComboBox.getValue().equals("Restaurant Manager")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/RestaurantManager/RestaurantManagerDeshBoard.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               }
               
//--------------------------------------------------------------------------------------------------------------      
  //Accountant                  
                          else if(userComboBox.getValue().equals("Accountant")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/Accountant/AccountantDashboard.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               }    
               
//-------------------------------------------------------------------------------------------------
//Hotel Receptionist
                          else if(userComboBox.getValue().equals("Hotel Receptionist")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/package/fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               } 
 //--------------------------------------------------------------------------------------
 //Security Manager
                           else if(userComboBox.getValue().equals("Security Manager")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/package/fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               } 
               
//-------------------------------------------------------------------------------
//Customer
                   else if(userComboBox.getValue().equals("Customer")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/package/fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               } 
 //--------------------------------------------------------------------------------------------
 //Staff
                    else if(userComboBox.getValue().equals("Customer")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/package/fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }
 // Set found to true when user is found     
            found = true; 
                    return ;
                    
                }
               
               } 


                    }
                
//---------------------------------------------------------------
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

      
       passwordTextField.setVisible(false);
        passwordShowTextField.setVisible(true);
        showEye.setVisible(true);
        hideEye.setVisible(false);
    }

    @FXML
    private void openEyeOnMouseClicked(MouseEvent event) {

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
