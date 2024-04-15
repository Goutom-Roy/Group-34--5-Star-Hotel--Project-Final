
package Sales_Manager;


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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SalesmanagerMonitorSalesPerformanceController implements Initializable {

    @FXML
    private AnchorPane SalesmanagerPerfomancefxid;
    @FXML
    private BarChart<String, Integer> Barchartsalesperformance;
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

     
        Barchartsalesperformance.getData().add(series);

     
        Barchartsalesperformance.setAnimated(false);
        Barchartsalesperformance.setCategoryGap(10);
        Barchartsalesperformance.setBarGap(5);
        Barchartsalesperformance.setHorizontalGridLinesVisible(true);
        Barchartsalesperformance.setVerticalGridLinesVisible(true);
        Barchartsalesperformance.setVerticalZeroLineVisible(true);
        Barchartsalesperformance.getXAxis().setLabel("Months");
        Barchartsalesperformance.getYAxis().setLabel("Sales Performance");

     
        updateSalesPerformanceData();
    }

   
    private void updateSalesPerformanceData() {
        XYChart.Series<String, Integer> series = Barchartsalesperformance.getData().get(0);
        for (XYChart.Data<String, Integer> data : series.getData()) {
            int randomValue = (int) (Math.random() * 201) + 100;
            data.setYValue(randomValue);
        }
    }
        
      

    @FXML
    private void OnclicknextButton(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == Nextbuttonfxid) {
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerHelpCenter.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HelpCenter");
            stage.show();
        }
    }
}
