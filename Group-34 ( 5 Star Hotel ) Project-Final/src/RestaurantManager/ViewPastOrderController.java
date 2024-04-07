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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewPastOrderController implements Initializable {

    @FXML
    private TableView<?> OrderDetailsTableView;
    @FXML
    private TableColumn<?, ?> OrderDateTableColumn;
    @FXML
    private TableColumn<?, ?> OrderIdTableColumn;
    @FXML
    private TableColumn<?, ?> CustomerNameTableColumn;
    @FXML
    private TableColumn<?, ?> OrderItemsTableColumn;
    @FXML
    private TableColumn<?, ?> QuantityTableColumn;
    @FXML
    private TableColumn<?, ?> PerUnitPriceTableColumn;
    @FXML
    private TableColumn<?, ?> TotalPriceTableColumn;
    @FXML
    private TableColumn<?, ?> OrderStatusTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }
    
}
