/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class OrderAnalysisPieChartController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button loadPieChartButton;
    @FXML
    private TextField newItemName;
    @FXML
    private TextField newItemValue;
    @FXML
    private Button loadPieChartButton1;
     private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Alert a = new Alert(Alert.AlertType.ERROR);
        // TODO
    }    

    @FXML
    private void labelMouseEnterOnClick(MouseEvent event) {
        statusLabel.setText("You are hoovering on the label");
    }

    @FXML
    private void loadPieChartButtonOnClick(ActionEvent event) {
         pieChart.getData().clear();
        list.add( new PieChart.Data("Garlic Butter Prawns",50) );
        list.add( new PieChart.Data("Szechuan Beef",40) );
        list.add( new PieChart.Data("Dim Sum Platter",30) );
        list.add( new PieChart.Data("Chicken Wonton",10) );
        list.add( new PieChart.Data("Thai Soup",15) );
        list.add( new PieChart.Data("Chicken Chowmein",17) );
        list.add( new PieChart.Data("Chicken Sizzling",15) );
        
         pieChart.setData(list);
        
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        statusLabel.setText(String.valueOf(data.getPieValue()));
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                }
            );
            
        }
    }

    @FXML
    private void addNewItemToChartButtonOnClick(ActionEvent event) {
         PieChart.Data newItem = 
            new PieChart.Data(
                newItemName.getText(),
                Double.parseDouble(newItemValue.getText())
            );
        
        pieChart.getData().add(newItem );
        
        newItem.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        statusLabel.setText(String.valueOf(newItem.getPieValue()));
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText(newItem.getName() + " is known by "
                                + String.valueOf(newItem.getPieValue()) + " students.");
                        a.showAndWait();
                    }
                }
        );
        
    }

    @FXML
    private void returnToDashBoardButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }
    
}
