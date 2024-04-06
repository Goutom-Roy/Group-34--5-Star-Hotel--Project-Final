package ceo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_UpdateServiceStatusController implements Initializable {

    @FXML
    private TextField serviceIDtextField;
    @FXML
    private Label servicelabel;
    @FXML
    private ComboBox<String> statuscomboBox1;

    // File path for the services data
    private static final String FILE_PATH = "C:/Users/gouto/Netbeans files1/Group Projects/Group-34 ( 5 Star Hotel ) Project/src/files/Services.txt";
    @FXML
    private Label statusLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statuscomboBox1.getItems().addAll("Active", "Non-active");
    }

    @FXML
    private void searchButtonOnAction(ActionEvent event) {
        String id = serviceIDtextField.getText();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3 && parts[0].equals(id)) {
                    servicelabel.setText(parts[1]);
                    statusLabel.setText(parts[2]);
                    
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            // Service not found
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Service with ID " + id + " not found.");
            alert.showAndWait();
        }
    }

    @FXML
    private void updateStatusButton(ActionEvent event) {
        String id = serviceIDtextField.getText();
        String newStatus = statuscomboBox1.getValue();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3 && parts[0].equals(id)) {
                    parts[2] = newStatus;
                    found = true;
                }
                sb.append(String.join(";", parts)).append("\n");
            }

            if (!found) {
                // Service not found
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Service with ID " + id + " not found.");
                alert.showAndWait();
                return;
            }

            // Write the updated content back to the file
            try (FileWriter fw = new FileWriter(FILE_PATH)) {
                fw.write(sb.toString());
            }

            // Success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Service status updated successfully.");
            alert.showAndWait();
            
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CEO_ServicesDashBoard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
