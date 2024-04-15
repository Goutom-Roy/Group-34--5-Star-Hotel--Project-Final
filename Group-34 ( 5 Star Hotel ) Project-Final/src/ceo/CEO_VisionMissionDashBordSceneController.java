/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_VisionMissionDashBordSceneController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TextArea visionTextArea;
    @FXML
    private TextArea missionTextArea;
    @FXML
    private TextArea strategyTextArea;

// File path to save vision, mission, and strategy
    private final String FILE_PATH = "Vision_mission_strategy.txt";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
// Load existing vision, mission, and strategy from file if available
        loadFromFile();
        visionTextArea.setEditable(false);
        missionTextArea.setEditable(false);
         strategyTextArea.setEditable(false);
    }    

    @FXML
    private void saveonActionButton(ActionEvent event) {
// Save vision, mission, and strategy to file
        saveToFile();
        visionTextArea.setEditable(false);
        missionTextArea.setEditable(false);
        strategyTextArea.setEditable(false);
        
    }

    @FXML
    private void backOnActionButton(ActionEvent event) throws IOException {
       Parent back=FXMLLoader.load(getClass().getResource("CEODashboardScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void editVisionOnActionButton(ActionEvent event) {
        visionTextArea.setEditable(true);
          missionTextArea.setEditable(false);
         strategyTextArea.setEditable(false);
        
    }

    @FXML
    private void editMissionOnActionButton(ActionEvent event) {
        missionTextArea.setEditable(true);
           visionTextArea.setEditable(false);
             strategyTextArea.setEditable(false);
        
    }

    @FXML
    private void editStrategyOnActionButton(ActionEvent event) {
        strategyTextArea.setEditable(true);
        missionTextArea.setEditable(false);
          visionTextArea.setEditable(false);
         
        
    }
    
        private void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write("Vision:\n" + visionTextArea.getText() + "\n");
            writer.write("Mission:\n" + missionTextArea.getText() + "\n");
            writer.write("Strategy:\n" + strategyTextArea.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Vision, mission, and strategy saved successfully.");
            alert.showAndWait();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving data.");
            alert.showAndWait();
        }
    }
        
private void loadFromFile() {
    try {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            // Read data from file
            StringBuilder content = new StringBuilder();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
            }

// Set data to text areas based on their identifiers

            String fileContent = content.toString();
            if (fileContent.contains("Vision:")) {
                int start = fileContent.indexOf("Vision:") + "Vision:".length();
                int end = fileContent.indexOf("Mission:");
                visionTextArea.setText(fileContent.substring(start, end).trim());
            }
            if (fileContent.contains("Mission:")) {
                int start = fileContent.indexOf("Mission:") + "Mission:".length();
                int end = fileContent.indexOf("Strategy:");
                missionTextArea.setText(fileContent.substring(start, end).trim());
            }
            if (fileContent.contains("Strategy:")) {
                int start = fileContent.indexOf("Strategy:") + "Strategy:".length();
                strategyTextArea.setText(fileContent.substring(start).trim());
            }
        }
    } catch (IOException ex) {
// Handle exception        
        ex.printStackTrace(); 
    }
}

}
