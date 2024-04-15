

package Revenue_Manager;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class RevenueManagerAnalyzeRevenuedataController implements Initializable {

    @FXML
    private DatePicker StartDateField;
    @FXML
    private DatePicker EndDateField;
    @FXML
    private Label Analyzerevenuelabel;
    @FXML
    private Button Nextbuttonfxid;
    @FXML
    private ComboBox<String> ComboBox;
    @FXML
    private Label analyzeData;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ComboBox.getItems().addAll("Room Revenue", "Food and Beverage Revenue", "Other Revenue");
    
    ComboBox.setValue("Room Revenue");
        
    }    

    @FXML
    private void Onclickanalyzebutton(ActionEvent event) {
        
        
        
        
        
    java.time.LocalDate startDate = StartDateField.getValue();
    java.time.LocalDate endDate = EndDateField.getValue();
    String selectedOption = ComboBox.getValue();

    
    
  double revenue = 25000.0;
  
  String revenueAnalysis = "StartDate: "+ startDate +" to "+ " EndDate: "+ endDate  +" Category: "+ selectedOption +" , "+ " Total revenue is $" + String.valueOf(revenue);

    analyzeData.setText(revenueAnalysis);
        
        
        
    try {
        
        FileWriter writer = new FileWriter("revenue_analysis.txt");
        writer.write(revenueAnalysis);
        writer.close();
        
    } catch (IOException e) {
        e.printStackTrace();
    } 
        
        
        
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
        
        
        
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Nextbuttonfxid){
             
             
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerManagediscounts.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Managediscounts");
        stage.show();
        
        
        
        
        
        
        
        
        
    }
    
}
