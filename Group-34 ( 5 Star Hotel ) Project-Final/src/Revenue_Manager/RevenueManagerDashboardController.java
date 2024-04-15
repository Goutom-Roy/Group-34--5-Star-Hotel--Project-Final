
package Revenue_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class RevenueManagerDashboardController implements Initializable {

    @FXML
    private Button Viewroomoccupancyfxid;
    @FXML
    private Button Setroomfxid;
    @FXML
    private Button Analyzerevenuedatafxid;
    @FXML
    private Button Managediscountfxid;
    @FXML
    private Button Generatereportfxid;
    @FXML
    private Button Monitormarkettrendfxid;
    @FXML
    private Button Analyzerevenueperformancefxid;
    
    @FXML
    private Button HelpCenterfxid;
   
   
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void OnclickviewroomoccupancyButton(ActionEvent event) throws IOException {
        
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Viewroomoccupancyfxid){
             
             
            stage = (Stage) Viewroomoccupancyfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerViewroomOccupancy.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ViewroomOccupancy");
        stage.show();
        
    }

    @FXML
    private void OnclicksetroomButton(ActionEvent event) throws IOException {
        
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Setroomfxid){
             
             
            stage = (Stage) Setroomfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerSetRoomprice.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("SetRoomprice");
        stage.show();
        
        
        
        
        
        
    }

    @FXML
    private void OnclickanalyzerevenuedataButton(ActionEvent event) throws IOException {
        
        
        
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Analyzerevenuedatafxid){
             
             
            stage = (Stage) Analyzerevenuedatafxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerAnalyzeRevenuedata.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnalyzerevenueData");
        stage.show();
        
        
        
        
        
        
        
    }

    @FXML
    private void OnclickManageDiscountButton(ActionEvent event) throws IOException {
        
        
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Managediscountfxid){
             
             
            stage = (Stage) Managediscountfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerManagediscounts.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ManageDiscount");
        stage.show();
        
        
        
        
        
        
        
        
    }

    @FXML
    private void OnclickgeneratereportButton(ActionEvent event) throws IOException {
        
        
         Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Generatereportfxid){
             
             
            stage = (Stage) Generatereportfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerGenerateReport.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Generatereport");
        stage.show();
        
        
        
        
        
        
    }

  

    @FXML
    private void OnclickmonitormarkettrendButton(ActionEvent event) throws IOException {
        
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Monitormarkettrendfxid){
             
             
            stage = (Stage) Monitormarkettrendfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagermonitorMarketTrend.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MonitormarketTrend");
        stage.show();
        
        
         
        
                
        
        
    }

    @FXML
    private void OnclickanalyzerevenueperformanceButton(ActionEvent event) throws IOException {
        
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Analyzerevenueperformancefxid){
             
             
            stage = (Stage) Analyzerevenueperformancefxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManageranalyzeRevenueperformance.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnalyzeRevenueperformance");
        stage.show();
        
        
        
    }

    

   

    @FXML
    private void OnclickHelpCenterbutton(ActionEvent event) throws IOException {
        
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== HelpCenterfxid){
             
             
            stage = (Stage)HelpCenterfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerHelpCenter.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("HelpCenter");
        stage.show();
        
        
        
        
        
        
        
        
        
        
    }

    @FXML
    private void logouOnAction(ActionEvent event) throws IOException {
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
