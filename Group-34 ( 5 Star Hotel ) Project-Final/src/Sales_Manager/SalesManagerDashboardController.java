
package SalesManager;

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
import javafx.stage.Stage;



public class SalesManagerDashboardController implements Initializable {

    @FXML
    private Button NewBookingfxid;
    @FXML
    private Button Updatebookingfxid;
    @FXML
    private Button Cancelbookingfxid;
    @FXML
    private Button Generatesalesreportfxid;
    @FXML
    private Button ManageSpecialofferfxid;
    @FXML
    private Button Monitorsalesperformancefxid;
    @FXML
    private Button Viewroomavailibilityfxid;
   
    @FXML
    private Button HelpCenterfxid;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
     @FXML
    private void OnclickviewroomavailibilityButton(ActionEvent event) throws IOException {
        
        
        
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Viewroomavailibilityfxid){
             
             
            stage = (Stage)Viewroomavailibilityfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerViewroomAvailibility.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ViewroomAvailibility");
        stage.show();
        
        
        
        
        
    }
    
    
    
    
    

    @FXML
    private void OnclickNewbookingButton(ActionEvent event) throws IOException {
        
          
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== NewBookingfxid){
             
             
            stage = (Stage)NewBookingfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerNewBooking.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("NewBookingRoom");
        stage.show();
        
        
        
    }

   

    @FXML
    private void OnclickupdateBookingButton(ActionEvent event) throws IOException {
        
        
        
        
         
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Updatebookingfxid){
             
             
            stage = (Stage)Updatebookingfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerupdateBookingdetails.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("UpdateBooking");
        stage.show();
        
        
        
        
    }

    @FXML
    private void OnclickCancelbookingButton(ActionEvent event) throws IOException {
        
        
        
         
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Cancelbookingfxid){
             
             
            stage = (Stage)Cancelbookingfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerCancelBooking.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CancelBooking");
        stage.show();
        
        
        
    }

    @FXML
    private void OnclickGenerateSalesreportButton(ActionEvent event) throws IOException {
        
       
        
        
                  Stage stage = null;
        Parent root = null;
        
           if(event.getSource()==  Generatesalesreportfxid){
             
             
            stage = (Stage) Generatesalesreportfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerGeneratesalesReport.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GenerateSalesReport");
        stage.show();
        
                
                
           
         
    }
    
    
    

    @FXML
    private void OnclickManagespecialofferButton(ActionEvent event) throws IOException {
        
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== ManageSpecialofferfxid){
             
             
            stage = (Stage)ManageSpecialofferfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerSpecialOffer.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ManageSpecialoffer");
        stage.show();
        
        
    }

    @FXML
    private void OnclickSalesperformanceButton(ActionEvent event) throws IOException {
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Monitorsalesperformancefxid){
             
             
            stage = (Stage)Monitorsalesperformancefxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerMonitorSalesPerformance.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Salesperformance");
        stage.show();
        
        
        
    }

   

    @FXML
    private void OnclickHelpCenterbutton(ActionEvent event) throws IOException{
        
        Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== HelpCenterfxid){
             
             
            stage = (Stage)HelpCenterfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SalesmanagerHelpCenter.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("HelpCenter");
        stage.show();
        
        
    }

   
    
}
