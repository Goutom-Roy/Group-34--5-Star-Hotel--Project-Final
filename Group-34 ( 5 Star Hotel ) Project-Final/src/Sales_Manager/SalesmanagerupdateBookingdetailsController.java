

package Sales_Manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalesmanagerupdateBookingdetailsController implements Initializable {

    @FXML
    private DatePicker CheckinDatefxid;
    @FXML
    private TextField PhoneNumberfield;
    @FXML
    private TextField Roomtypefield;
    @FXML
    private TextField Totalroomfield;
    @FXML
    private TextField Numberofguestfieldfxid;
    @FXML
    private TextField Guestfieldfxid;
    @FXML
    private Button Updatebuttonfxid;
    @FXML
    private TextArea Textareafieldfxid;
    @FXML
    private DatePicker CheckoutDatefxid;
    @FXML
    private Button Nextbuttonfxid;
    @FXML
    private TextField Roomratesfxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void OnclickUpdatebutton(ActionEvent event) {
        String guestName = Guestfieldfxid.getText();
        int numberOfGuests = Integer.parseInt(Numberofguestfieldfxid.getText());
        String phoneNumber = PhoneNumberfield.getText();
        String roomType = Roomtypefield.getText();
        int totalRoom = Integer.parseInt(Totalroomfield.getText());
        LocalDate checkinDate = CheckinDatefxid.getValue(); 
        LocalDate checkoutDate = CheckoutDatefxid.getValue();
        double roomRate = Double.parseDouble(Roomratesfxid.getText());
        
        String bookingInfo = String.format(
            "Guest Name: %s\nNumber of Guests: %d\nPhone Number: %s\nRoom Type: %s\nTotal Room: %d\nCheck-in Date: %s\nCheckout Date: %s\nRoom Rate: %.2f\n",
            guestName, numberOfGuests, phoneNumber, roomType, totalRoom, checkinDate, checkoutDate, roomRate
        );
        
        Textareafieldfxid.setText(bookingInfo);
        
     
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BookingInfo.txt"))) {
            writer.write(bookingInfo);
        } catch (IOException e) {
            e.printStackTrace();
            Textareafieldfxid.setText("Error occurred while saving data.");
        }
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
       
        Stage stage = null;
        Parent root = null;
        
        if (event.getSource() == Nextbuttonfxid) {
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerCancelBooking.fxml"));
        }
     
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CancelBooking");
        stage.show();
    }
}
