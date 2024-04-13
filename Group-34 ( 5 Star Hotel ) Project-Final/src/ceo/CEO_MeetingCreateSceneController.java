/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.io.FileWriter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_MeetingCreateSceneController implements Initializable {

    @FXML
    private TextField topictextfield;
    @FXML
    private TextField timetextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField locationtextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddmeetingOnActionButton(ActionEvent event) {
        try {
            FileWriter w = new FileWriter("C:/Users/gouto/Netbeans files1/Group Projects/Group-34 ( 5 Star Hotel ) Project/src/files/Meetings.txt",true);
            w.write( topictextfield.getText().toString() +";"+ timetextField.getText().toString()+";"+ 
              datePicker.getValue().toString()+";"+locationtextField.getText().toString()+"\n"); 
            w.close();
            
            topictextfield.clear();
            timetextField.clear();
            datePicker.setValue(null);
            locationtextField.clear();
            
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "ADD Meeting Successfully");
            
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void backOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_Meeting.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
