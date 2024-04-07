/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_MarketShareSceneController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("2024",60));
        series.getData().add(new XYChart.Data<String,Number>("2023",50));
        series.getData().add(new XYChart.Data<String,Number>("2022",35));
        series.getData().add(new XYChart.Data<String,Number>("2021",24));
        series.getData().add(new XYChart.Data<String,Number>("2020",23));
        series.getData().add(new XYChart.Data<String,Number>("2019",20));
        series.setName("Market Share");
        barChart.getData().add(series);
      
        // TODO
    }    
    
}
