
package RevenueManager;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RevenueManagermonitorMarketTrendController implements Initializable {

    @FXML
    private TextField trendnamefxid;
    @FXML
    private TextField trendescriptionfxid;
    @FXML
    private Button Savebuttonfxid;
    @FXML
    private Button Nextbuttonfxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        
        if(event.getSource() == Nextbuttonfxid){
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManageranalyzeRevenueperformance.fxml"));
        }
     
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Revenueperformance");
        stage.show();
    }

    @FXML
    private void OnclickSavebutton(ActionEvent event) {
       
        String trendName = trendnamefxid.getText();
        String trendDescription = trendescriptionfxid.getText();

       
        try (FileWriter writer = new FileWriter("market_trends.txt", true)) {
            writer.write("Trend Name: " + trendName + "\n");
            writer.write("Trend Description: " + trendDescription + "\n\n");
            System.out.println("Market trend details saved to market_trends.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    
        trendnamefxid.clear();
        trendescriptionfxid.clear();
    }
}
