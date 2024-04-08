/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import ModelClass.Meeting;
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
public class CEO_MeetingDetailsController implements Initializable {

    @FXML
    private Label topiclabel;
    @FXML
    private Label timelabel;
    @FXML
    private Label datelabel;
    @FXML
    private Label locationlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
   public void initDate(Meeting selectedItem){
        topiclabel.setText(selectedItem.getTopic());
        timelabel.setText(selectedItem.getTime());
        datelabel.setText(selectedItem.getDate().toString());
        locationlabel.setText(selectedItem.getLocation());
        
    }

    @FXML
    private void backOnactionButton(ActionEvent event) throws IOException {
       Parent singup=FXMLLoader.load(getClass().getResource("CEO_Meeting.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
