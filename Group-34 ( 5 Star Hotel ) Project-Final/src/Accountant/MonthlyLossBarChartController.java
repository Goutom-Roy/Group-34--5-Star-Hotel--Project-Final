/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MonthlyLossBarChartController implements Initializable {

    @FXML
    private BarChart<String,Number> barChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private MenuBar MenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.getData().add(new XYChart.Data<>("Retail Shops", 82));
    series.getData().add(new XYChart.Data<>("Concierge Services", 34));
    series.getData().add(new XYChart.Data<>("Business Services", 25));
     series.getData().add(new XYChart.Data<>("Spa and wellness", 17));
//    series.getData().add(new XYChart.Data<>("", 16));
//    series.getData().add(new XYChart.Data<>("Marriott buzz", 17));
    
     // Convert the values to percentages and display them on the bars
    for (XYChart.Data<String, Number> data : series.getData()) {
        double value = data.getYValue().doubleValue();
        double percentage = (value / 100) * 100; 
        data.setYValue(percentage);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(new Text(String.format("%.2f%%", percentage)));
        stackPane.setAlignment(Pos.TOP_CENTER);
        StackPane.setAlignment(stackPane, Pos.TOP_CENTER);
        stackPane.setMouseTransparent(true);
        data.setNode(stackPane);
    }
    series.setName("Monthly Loss");

    barChart.getData().add(series);
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("MonthlyProfitAndLossChartScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
         
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Logout Successfully");
        alert.setContentText("Do you want to Logout ? If not then click Cancel");
        
        if(alert.showAndWait().get()==ButtonType.OK){
        Parent singup=FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    }
    
}
