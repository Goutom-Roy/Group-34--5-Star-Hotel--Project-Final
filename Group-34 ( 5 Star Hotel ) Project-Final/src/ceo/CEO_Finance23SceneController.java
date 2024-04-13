/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_Finance23SceneController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private Label statusLabel;
    @FXML
    private Button loadPieChartButton;
        private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void labelMouseEnterOnClick(MouseEvent event) {
        statusLabel.setText(" Financial performance 2023 ");
    }

    @FXML
    private void loadPieChartButtonOnAction(ActionEvent event) {
                pieChart.getData().clear();
        
        list.add( new PieChart.Data("Very much",0) );
        list.add( new PieChart.Data("Pretty much",42.50) );
        list.add( new PieChart.Data("Moderat",32.50) );
        list.add( new PieChart.Data("Slightly",25) );
      
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
    
}
