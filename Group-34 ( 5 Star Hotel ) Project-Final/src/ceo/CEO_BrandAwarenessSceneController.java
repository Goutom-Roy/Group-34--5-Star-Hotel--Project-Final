package ceo;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_BrandAwarenessSceneController implements Initializable {

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

    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.getData().add(new XYChart.Data<>("Marriott Awareness", 82));
    series.getData().add(new XYChart.Data<>("Marrjott popularity", 34));
    series.getData().add(new XYChart.Data<>("Marriott usage", 19));
    series.getData().add(new XYChart.Data<>("Marriott loyalty", 16));
    series.getData().add(new XYChart.Data<>("Marriott buzz", 17));



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

    barChart.getData().add(series);
}

}
