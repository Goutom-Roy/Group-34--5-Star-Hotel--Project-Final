/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerProjectsDashBoardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    
   private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderPane.setCenter(root);
       } catch (IOException ex) {
           Logger.getLogger(IT_ManagerProjectsDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        Parent back=FXMLLoader.load(getClass().getResource("IT_ManagerDashboardScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void closeOnAction(ActionEvent event) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ongoingOnActionButton(ActionEvent event) {
        loadUI("IT_ManagerOngoingProject");
    }

    @FXML
    private void upcomingOnActionButton(ActionEvent event) {
        loadUI("IT_ManagerUpComingProject");
    }

    @FXML
    private void createOnActionButton(ActionEvent event) {
        loadUI("IT_ManagerNewProject");
       
    }
    
}
