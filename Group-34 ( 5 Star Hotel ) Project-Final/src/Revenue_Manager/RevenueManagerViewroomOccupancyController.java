
package RevenueManager;


import java.io.BufferedWriter;
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
import javafx.stage.Stage;

public class RevenueManagerViewroomOccupancyController implements Initializable {

    @FXML
    private Label roomNumberLabel;
    @FXML
    private Label occupancyLabel;
    @FXML
    private Button Nextbuttonfxid;
    @FXML
    private Button Savebuttonfxid;

    private int roomNumber = 7003; 
    private boolean occupied = true; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateLabels();
    }

    private void updateLabels() {
        roomNumberLabel.setText("Room Number: " + roomNumber);
        occupancyLabel.setText("Occupied: " + (occupied ? "Yes" : "No"));
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
        // Navigate to the next scene
        Stage stage = (Stage) Nextbuttonfxid.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RevenueManagerSetRoomprice.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Set Room Price");
        stage.show();
    }

    @FXML
    private void Onclicksavetbutton(ActionEvent event) {
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("RoomOccupancyData.txt"))) {
            writer.write( roomNumberLabel.getText() + "\n");
            writer.write( occupancyLabel.getText() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
           
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving data!");
            alert.showAndWait();
            return;
        }

       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Room occupancy data saved successfully!");
        alert.showAndWait();
    }
}
