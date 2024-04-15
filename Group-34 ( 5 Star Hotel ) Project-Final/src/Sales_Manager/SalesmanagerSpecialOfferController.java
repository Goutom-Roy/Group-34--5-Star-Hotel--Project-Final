

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalesmanagerSpecialOfferController implements Initializable {

    @FXML
    private Button Addbuttonfxid;
    @FXML
    private TextField AddoffertextField;
    @FXML
    private TextField Discountfxid;
    @FXML
    private TextArea textarea;
    @FXML
    private Button Deletebuttonfxid;
    @FXML
    private Button Nextbuttonfxid;
    @FXML
    private ChoiceBox<String> Offerchoicefxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        Offerchoicefxid.getItems().addAll("Yes", "No");
        Offerchoicefxid.setValue("Yes");
    }

    @FXML
    private void OnclickaddButton(ActionEvent event) {
        String offerName = AddoffertextField.getText();
        String discount = Discountfxid.getText();
        String availability = Offerchoicefxid.getValue();

      
        textarea.appendText("Offer Name: " + offerName + "\nDiscount: " + discount + "\nAvailability: " + availability + "\n\n");

      
        AddoffertextField.clear();
        Discountfxid.clear();

      
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Offer Added");
        alert.setHeaderText(null);
        alert.setContentText("Offer added successfully!");
        alert.show();

      
        String fileName = offerName + "_Offer.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Offer Name: " + offerName + "\nDiscount: " + discount + "\nAvailability: " + availability + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void OnclickdeleteButton(ActionEvent event) {
        // Clear the text area
        textarea.clear();
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == Nextbuttonfxid) {
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerMonitorSalesPerformance.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MonitorSalesPerformance");
        stage.show();
    }
}
