/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sales_Manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class SalesmanagerNewBookingController implements Initializable {

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
    private ComboBox<?> comboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnclickSubmitbutton(ActionEvent event) {
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) {
    }
    
}
