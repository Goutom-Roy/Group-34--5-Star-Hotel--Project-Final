/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddNewItemController implements Initializable {

    @FXML
    private Label QuantityShowLabel;
    @FXML
    private Label ItemDescriptionShowLabel;
    @FXML
    private Label PriceShowLabel;
    @FXML
    private Label StatusShowLabel;
    @FXML
    private Label ItemNameShowLabel;
    @FXML
    private Label ItemTypeShowLabel;
    @FXML
    private Label IdShowLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void LogOutButtonOnClick(ActionEvent event) {
    }
    
}
