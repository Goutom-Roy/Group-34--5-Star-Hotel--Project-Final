/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import ModelClass.Employee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class EmployeeDetailsSceneController implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label DateofJoinLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
        public void initData(Employee selectedItem) {
            
       idLabel.setText(String.valueOf(selectedItem.getId()));
       nameLabel.setText(selectedItem.getName().toString());
        genderLabel.setText(selectedItem.getGender().toString());
       DateofJoinLabel.setText(selectedItem.getJoining_date().toString());
    }
    
}
