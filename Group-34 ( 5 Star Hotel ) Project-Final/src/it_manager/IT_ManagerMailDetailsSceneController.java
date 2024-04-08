/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import ModelClass.Mail;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerMailDetailsSceneController implements Initializable {

    @FXML
    private Label subjectLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label detailsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
    
      public void initData(Mail selectedItem) {
            
       subjectLabel.setText(String.valueOf(selectedItem.getSubject()));
       timeLabel.setText(selectedItem.getTime().toString());
        dateLabel.setText(selectedItem.getDate().toString());
        
// Set details with wrapping enabled for multiline display
        detailsLabel.setText(selectedItem.getDetail());
        detailsLabel.setWrapText(true);
    }


    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerMailDashBoard.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
