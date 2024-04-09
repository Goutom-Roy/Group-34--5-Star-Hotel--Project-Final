/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;


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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerUserPassMonitorController implements Initializable {

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
    @FXML
    private TableColumn<User,LocalDate> passwordCgangedateColumn;
    @FXML
    private MenuBar menuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
         datrofBirthColumn.setCellValueFactory(new PropertyValueFactory<User,LocalDate>("dateofjoin"));
         genderColumn.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
         roleColumn.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
         passwordCgangedateColumn.setCellValueFactory(new PropertyValueFactory<User,LocalDate>("passwordChangeDate"));
         
         
       try {
            
  
        FileReader f= new FileReader("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/Updatepassinfo.txt");
        BufferedReader reader = new BufferedReader(f);

        String line;
            while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] fields = line.split(";");
            String email = fields[0];
            String role = fields[1];
            String gender = fields[2];
            LocalDate dateOfjoin = LocalDate.parse(fields[3]);
            LocalDate updateDate = LocalDate.parse(fields[4]);
            
            User user = new User(email, gender, dateOfjoin, gender, role, updateDate);
            tableView.getItems().add(user);
        }

            } catch (Exception e) {
                System.out.println(e);
        }  
     
    }    

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        
        Parent back = FXMLLoader.load(getClass().getResource("RegistrationScene.fxml"));
        Scene newScene = new Scene(back);
        Stage stg1 = (Stage) menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
