package Sales_Manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SalesmanagerNewBookingController {

    @FXML
    private TextField Guestfieldfxid;
    @FXML
    private DatePicker Datefield;
    @FXML
    private TextField PhoneNumberfield;
    @FXML
    private Button Submitbuttonfxid;
    @FXML
    private TextField Totalroomfield;
    @FXML
    private TextField Numberofguestfieldfxid;
    @FXML
    private TextArea Bookingoutput;
    @FXML
    private Button Nextbuttonfxid;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private void initialize() {
        
        comboBox.getItems().addAll("Standard Room", "Deluxe Room", "Family Room", "Single Room", "Double Room");
    }

    @FXML
    private void OnclickSubmitbutton(ActionEvent event) {
        
        String guestName = Guestfieldfxid.getText();
        int numberOfGuests = Integer.parseInt(Numberofguestfieldfxid.getText());
        String phoneNumber = PhoneNumberfield.getText();
        String roomType = comboBox.getValue();
        int totalRoom = Integer.parseInt(Totalroomfield.getText());
        LocalDate bookingDate = Datefield.getValue();

        String bookingDetails = "Guest Name: " + guestName + "\n" +
                "Number of Guests: " + numberOfGuests + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Room Type: " + roomType + "\n" +
                "Total Rooms: " + totalRoom + "\n" +
                "Booking Date: " + bookingDate + "\n\n";

        Bookingoutput.appendText(bookingDetails);

        saveBookingToFile(bookingDetails);
    }

    private void saveBookingToFile(String bookingDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("booking_details.txt", true))) {
            writer.write(bookingDetails);
            writer.newLine();
            showAlert("Success", "Booking details saved successfully.");
        } catch (IOException e) {
            showAlert("Error", "Failed to save booking details.");
        }
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == Nextbuttonfxid) {
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerupdateBookingdetails.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("UpdateBooking");
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
