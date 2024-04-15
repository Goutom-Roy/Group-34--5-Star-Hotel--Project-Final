
package Sales_Manager;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalesmanagerHelpCenterController implements Initializable {

    @FXML
    private TextField HelpNamefxid;
    @FXML
    private TextArea HelpDetailTextarea;
    @FXML
    private Button SubmitButtonfxid;
    @FXML
    private Button Dashboardbuttonfxid;
    @FXML
    private ComboBox<String> HelpComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        HelpComboBox.getItems().addAll(
            "Room", "Dining", "Facilities", "Housekeeping", "Guest Services", "Health and Safety"
        );
    }

    @FXML
    private void OnclickSubmitButton(ActionEvent event) {
        String helpCategory = HelpComboBox.getValue();
        String helpName = HelpNamefxid.getText();
        String helpDetails = HelpDetailTextarea.getText();

        if (helpCategory == null || helpName.isEmpty() || helpDetails.isEmpty()) {
            showAlert("Please fill in all fields!");
            return;
        }

        String fileName = helpCategory + "_" + helpName + "_Help.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Help Category: " + helpCategory + "\n");
            writer.write("Help Name: " + helpName + "\n");
            writer.write("Help Details:\n" + helpDetails);
            showAlert("Help submitted successfully! File created: " + fileName);
        } catch (IOException e) {
            showAlert("Error occurred while writing help to file!");
            e.printStackTrace();
        }
    }

    @FXML
    private void OnclickDashboardbutton(ActionEvent event) throws IOException {
     
        
        
        
        Stage stage = null;
        Parent root = null;
                
           if(event.getSource()== Dashboardbuttonfxid) {
             
             
            stage = (Stage)Dashboardbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesManagerDashboard.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("SalesManagerDashboard");
        stage.show(); 
        
        
        
        
        
        
        
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help Submission");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

