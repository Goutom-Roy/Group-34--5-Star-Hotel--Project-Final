/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import ModelClass.Employee;
import ModelClass.User;
import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class RegistrationSceneController implements Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User,String> emailColumn;
    @FXML
    private TableColumn<User,String> roleColumn;
    @FXML
    private TableColumn<User,LocalDate> datrofBirthColumn;
    @FXML
    private TableColumn<User,String> genderColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
         datrofBirthColumn.setCellValueFactory(new PropertyValueFactory<User,LocalDate>("dateofjoin"));
         genderColumn.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
         roleColumn.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
         
    }    

    @FXML
    private void detailsOnActionButton(ActionEvent event) {
    }

    @FXML
    private void backOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerDashboardScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void userOnActionButton(ActionEvent event) {
        try {
            
   
        FileReader f= new FileReader("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/LoginUserDetails.txt");
        BufferedReader reader = new BufferedReader(f);

        String line;
            while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] fields = line.split(";");
            String email = fields[0];
            String role = fields[2];
            String gender = fields[3];
            LocalDate dateOfjoin = LocalDate.parse(fields[4]);
            
            User user = new User(email, dateOfjoin, gender, role);
            tableView.getItems().add(user);
        }

            } catch (Exception e) {
        }
    }
    
}
