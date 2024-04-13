
package SalesManager;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SalesmanagerCancelBookingController implements Initializable {

    @FXML
    private Button Cancelbookingfxid;
    @FXML
    private Label Bookingtext;
    @FXML
    private String bookingInfo; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayRandomValues();
    }

    @FXML
    private void OnclickcancelbookingButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Booking");
        alert.setHeaderText("Are you sure you want to cancel this booking?");
        alert.setContentText("Click OK to confirm.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
               
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("CancelledBooking.txt"))) {
                    writer.write(bookingInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Stage stage = (Stage) Cancelbookingfxid.getScene().getWindow();
                stage.close();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Booking Cancelled");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Booking cancelled successfully!");
                successAlert.showAndWait();
            }
        });
    }


   
    private void displayRandomValues() {
       
        
        bookingInfo = generateRandomBookingInfo();

        
        Bookingtext.setText(bookingInfo);
    }

   
    private String generateRandomBookingInfo() {
       
        String guestName = "Ayesha";
        String roomType = "Single";
        String checkinDate = "10-04-2024";
        String checkoutDate = "20-04-2024";
        String bookingID = "1010368"; // Booking ID
        
        
        String bookingInfo = String.format(
            "Booking ID: #%s\nGuest Name: %s\nRoom Type: %s\nCheck-in Date: %s\nCheckout Date: %s",
            bookingID, guestName, roomType, checkinDate, checkoutDate
        );
        
        return bookingInfo;
    }
}

