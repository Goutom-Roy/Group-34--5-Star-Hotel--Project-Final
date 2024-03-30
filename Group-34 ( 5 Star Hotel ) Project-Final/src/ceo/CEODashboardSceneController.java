/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEODashboardSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButton(ActionEvent event) {

    }

    @FXML
    private void productAndServiceButton(ActionEvent event) {
    }

    @FXML
    private void guestSatisfactionButton(ActionEvent event) {
    }

    @FXML
    private void mettingButton(ActionEvent event) {
    }

    @FXML
    private void budgetButton(ActionEvent event) {
    }

    @FXML
    private void namageEmployeeButton(ActionEvent event) {
    }

    @FXML
    private void visionMissionButton(ActionEvent event) {
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
     Parent singup=FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
