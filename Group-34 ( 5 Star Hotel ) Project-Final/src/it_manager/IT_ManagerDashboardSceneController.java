/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerDashboardSceneController implements Initializable {

    @FXML
    private MediaView mediaView;
    
    private MediaPlayer mediaPlayer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                       // Load the video file
        String videoPath = "IT_Manager.mp4";
        Media media = new Media(new File(videoPath).toURI().toString());

        // Create the MediaPlayer
        mediaPlayer = new MediaPlayer(media);

        // Set the MediaPlayer to the MediaView
        mediaView.setMediaPlayer(mediaPlayer);

        // Add event handler to replay the video when it ends
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        // Play the video
        mediaPlayer.play(); 
        
        
    }    

    @FXML
    private void registrationOnActionButton(ActionEvent event) throws IOException {
                
        Parent singup=FXMLLoader.load(getClass().getResource("RegistrationScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();

    }

    @FXML
    private void logoutOnActionButton(ActionEvent event) throws IOException {
    

        // Stop the MediaPlayer
        mediaPlayer.stop();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Logout Successfully");
        alert.setContentText("Do you want to Logout ? If not then click Cancel");
        
        if(alert.showAndWait().get()==ButtonType.OK){
        Parent singup=FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        }
        else{
            mediaPlayer.play();
        }
    }

    @FXML
    private void peojectOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerProjectsDashBoard.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void mailOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerMailDashBoard.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void netandCCTVOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerInternetCCTVDashBoard.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void budgetOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerBudgetDashBoard.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
    }

    @FXML
    private void feedbackOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerFeedback.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
    }
    
}
