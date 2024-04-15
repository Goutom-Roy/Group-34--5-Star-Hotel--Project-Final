
package Revenue_Manager;

import java.io.BufferedWriter;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RevenueManagerGenerateReportController implements Initializable {

    @FXML
    private TextField ReportNamefxid;
    @FXML
    private TextArea Reportdetailsfxid;
    @FXML
    private Button Submitbuttonfxid;
    @FXML
    private Button Nextbuttonfxid;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void OnclicksubmitButton(ActionEvent event) throws IOException {
        
        
      
        String reportName = ReportNamefxid.getText();
        String reportDetails = Reportdetailsfxid.getText();
        
     
        String fileName = reportName + ".txt";
        
     
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(reportDetails);
        writer.close();
        
       
        showAlert(Alert.AlertType.INFORMATION, "Success", null, "Report file created successfully.");  
        
  
        
        
        
    }
    
      
    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.showAndWait();
}

    
 
    

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
        
        
           Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Nextbuttonfxid){
             
             
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagermonitorMarketTrend.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ViewoccupancyTrend");
        stage.show();
        
        
        
        
        
    }
    
}
