/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_ServicesDashBoardController implements Initializable {

    @FXML
    private MenuBar MuneBar;
    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackOnAction(ActionEvent event) throws IOException {
        Parent back=FXMLLoader.load(getClass().getResource("CEODashboardScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MuneBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
       
    }

    @FXML
    private void closeOnAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Exit Confirmation");
        a.setHeaderText("You are about to exit the application!");
        a.setContentText("Press OK to exit!");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
        Stage stage;
        stage = (Stage)borderpane.getScene().getWindow();
     
        stage.close();
        }
    }

    @FXML
    private void spaMouseClick(MouseEvent event) {
        
      displayServiceStatus("231522"); 
    }

    @FXML
    private void butlerMouseClick(MouseEvent event) {
        
     displayServiceStatus("234223");
        
    }

    @FXML
    private void meetingRoomMouseClick(MouseEvent event) {
        
       displayServiceStatus("234222");
    }

    @FXML
    private void train(MouseEvent event) {
                
        displayServiceStatus("234212");
    }

    @FXML
    private void poolMouseClick(MouseEvent event) {
        
       displayServiceStatus("235212");
        
    }

    @FXML
    private void loungeMouseClick(MouseEvent event) {
      displayServiceStatus("225212");
        
    }

    @FXML
    private void updateStatusOnActionButton(ActionEvent event) throws IOException {
        Parent back=FXMLLoader.load(getClass().getResource("CEO_UpdateServiceStatus.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MuneBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
    private void displayServiceStatus(String serviceCode) {
        
    try (
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/gouto/Netbeans files1/Group Projects/Group-34 ( 5 Star Hotel ) Project/src/files/Services.txt"))
            ) 
    {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 3 && parts[0].equals(serviceCode)) {
                String serviceName = parts[1];
                String status = parts[2];
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Service ID: "+ serviceCode);
                alert.setHeaderText(serviceName);
                alert.setContentText("Status: " + status);
                alert.showAndWait();
                return;
            }
        }
        // If service code not found
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Service not found.");
        alert.showAndWait();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
