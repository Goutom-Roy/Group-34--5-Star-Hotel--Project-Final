
package Sales_Manager;


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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    
public class SalesmanagerViewroomAvailibilityController implements Initializable {

    @FXML
    private Label output;
    @FXML
    private TextField PricepernightField;
    @FXML
    private TextField TotalroomField;
    @FXML
    private Button viewbuttonfxid;
    @FXML
    private Button Nextbuttonfxid;
    @FXML
    private ComboBox<String> ComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBox.getItems().addAll("Family Room", "Single Room", "Double Room");
    }

    @FXML
    private void Onclickviewbutton(ActionEvent event) {
        String totalRoom = TotalroomField.getText();
        String roomType = ComboBox.getValue();
        String pricePerNight = PricepernightField.getText();

        if (totalRoom.isEmpty() || roomType == null || pricePerNight.isEmpty()) {
            output.setText("Please fill in all fields!");
            return;
        }

        int totalRoomValue = Integer.parseInt(totalRoom);

        if ((totalRoomValue >= 1 && totalRoomValue <= 3) && (roomType.equalsIgnoreCase("Single Room") || roomType.equalsIgnoreCase("Double Room") || roomType.equalsIgnoreCase("Family Room"))) {
            String outputMessage = String.format("Total Room: %s, Room type: %s, Price per night: %s is available!", totalRoom, roomType, pricePerNight);
            output.setText(outputMessage);

            showAlert("Success", "Data saved as RoomAvailability.txt");
        } else {
            output.setText("Not available!");
        }
    }

    @FXML
    private void OnclicknextButton(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == Nextbuttonfxid) {
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerNewBooking.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NewBooking");
            stage.show();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}