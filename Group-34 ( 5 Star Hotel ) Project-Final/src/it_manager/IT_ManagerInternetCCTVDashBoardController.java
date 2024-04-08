/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import ModelClass.Internet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
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
public class IT_ManagerInternetCCTVDashBoardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label internetSpeedLabel;
    @FXML
    private Label internetRangeLabel;
    @FXML
    private Label cctvCountLabel;
    @FXML
    private MediaView mediaView;
    
    private Timeline internetSpeedTimeline;
    private MediaPlayer mediaPlayer;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Internet internet = fetchDataForInternet();
        String cameraCount = fetchCameraCount();
        internetSpeedLabel.setText(internet.getSpeed() + " Mbps");
        internetRangeLabel.setText(internet.getRange() + " Meters");
        cctvCountLabel.setText(cameraCount);

        // Start a timeline to update internet speed every second
        internetSpeedTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateInternetSpeed()));
        internetSpeedTimeline.setCycleCount(Animation.INDEFINITE);
        internetSpeedTimeline.play();

        // Load the video file
        String videoPath = "C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/CCTV.mp4";
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
    private void backOnActionButton(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("IT_ManagerDashboardScene.fxml"));
        Scene newScene = new Scene(back);
        Stage stg1 = (Stage) menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void closeOnAction(ActionEvent event) {
      // Stop the timeline when closing the window
        internetSpeedTimeline.stop();

        // Stop the MediaPlayer
        mediaPlayer.stop();

        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }
    
        private Internet fetchDataForInternet() {
        return new Internet(1000, 150);
    }

    private String fetchCameraCount() {
        return "30";
    }

    private void updateInternetSpeed() {
        // Generate a random internet speed between 500 and 2000 Mbps
        Random random = new Random();
        int speed = random.nextInt(1501) + 500;
        internetSpeedLabel.setText(speed + " Mbps");
    }
    
}
