
package Revenue_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class RevenueManageranalyzeRevenueperformanceController implements Initializable {

    @FXML
    private BarChart<String , Integer> Barchartrevenueperformance;
    @FXML
    private Button Nextbuttonfxid;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Months");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Sales Performance");

      
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("January", 100));
        series.getData().add(new XYChart.Data<>("February", 150));
        series.getData().add(new XYChart.Data<>("March", 200));
        series.getData().add(new XYChart.Data<>("April", 180));
        series.getData().add(new XYChart.Data<>("May", 220));
        series.getData().add(new XYChart.Data<>("June", 250));

     
        Barchartrevenueperformance.getData().add(series);

      
        Barchartrevenueperformance.setAnimated(false);
        Barchartrevenueperformance.setCategoryGap(10);
        Barchartrevenueperformance.setBarGap(5);
        Barchartrevenueperformance.setHorizontalGridLinesVisible(true);
        Barchartrevenueperformance.setVerticalGridLinesVisible(true);
        Barchartrevenueperformance.setVerticalZeroLineVisible(true);
        Barchartrevenueperformance.getXAxis().setLabel("Months");
        Barchartrevenueperformance.getYAxis().setLabel("Revenue Performance");

      
        generateRandomData();
    }

   
    private void generateRandomData() {
        XYChart.Series<String, Integer> series = Barchartrevenueperformance.getData().get(0);
        for (XYChart.Data<String, Integer> data : series.getData()) {
         
            int randomValue = (int) (Math.random() * 201) + 100;
            data.setYValue(randomValue);
        }
    }
        
        

    
    @FXML
    private void OnclickNextbutton(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) Nextbuttonfxid.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RevenueManagerHelpCenter.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("HelpCenter");
        stage.show();
        
        
        
    }
    
}
