/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import ModelClass.Food;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    ObservableList<Food> foodList=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuManagement.fxml"));
        Parent parent = loader.load();
        MenuManagementController add=loader.getController();
        add.setFood(foodList);

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene MenuManagementScene = new Scene(parent);

        currentStage.setScene( MenuManagementScene);
        currentStage.show();
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene RestaurantManagerDeshBoardScene = new Scene(parent);

        currentStage.setScene(RestaurantManagerDeshBoardScene);
        currentStage.show();
    }

    @FXML
    private void LogOutButtonOnClick(ActionEvent event) {
    }

    void initData(Food selectedItem, ObservableList<Food> foodList) {
       IdShowLabel.setText(selectedItem.getId());
       ItemNameShowLabel.setText(selectedItem.getItemName());
       ItemTypeShowLabel.setText(selectedItem.getItemType());
       ItemDescriptionShowLabel.setText(selectedItem.getItemDescription());
       QuantityShowLabel.setText(selectedItem.getQuantity());
       PriceShowLabel.setText(selectedItem.getPrice());
       this.foodList=foodList;
       StatusShowLabel.setText(selectedItem.getStatus());
    }
    
}
