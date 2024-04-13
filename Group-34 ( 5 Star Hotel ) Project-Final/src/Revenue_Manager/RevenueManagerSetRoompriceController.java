/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RevenueManager;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RevenueManagerSetRoompriceController implements Initializable {

    @FXML
    private TextField Singleroomfxid;
    @FXML
    private TextField Doubleroomfxid;
    @FXML
    private TextField Familyroomfxid;
    @FXML
    private Label Setroomlabel;
    @FXML
    private Button Savebuttonfxid;
    @FXML
    private Button Nextbuttonfxid;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnclickSavebutton(ActionEvent event) {
        
      
    double singleRoomPrice = Double.parseDouble(Singleroomfxid.getText());
    double doubleRoomPrice = Double.parseDouble(Doubleroomfxid.getText());
    double familyRoomPrice = Double.parseDouble(Familyroomfxid.getText());

   
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Room Prices Saved");
    alert.setHeaderText(null);
    
   
    String content = String.format("Single Room Price: $%.2f\nDouble Room Price: $%.2f\nFamily Room Price: $%.2f",
                                    singleRoomPrice, doubleRoomPrice, familyRoomPrice);
    alert.setContentText(content);

   
    alert.show();

    
    Setroomlabel.setText(content);
        
        
        
        // Writing data to a text file
    try {
        FileWriter writer = new FileWriter("room_prices.txt");
        writer.write(content);
        writer.close();
       
    } catch (IOException e) {
        e.printStackTrace();
    } 
        
        
        
        
        
        
        
    }

    @FXML
    private void OnclickNextbutton(ActionEvent event) throws IOException {
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()==Nextbuttonfxid){
             
             
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerAnalyzerevenueData.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnalyzeRevenueData");
        stage.show();
        
        
        
        
        
        
    }

    
    
}
