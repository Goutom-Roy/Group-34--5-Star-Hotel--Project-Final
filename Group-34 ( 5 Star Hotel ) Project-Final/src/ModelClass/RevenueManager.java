package ModelClass;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;  


public class RevenueManager extends Application {  

        
    @Override   
    public void start(Stage primaryStage) throws Exception {   
       
   Parent root = FXMLLoader.load(getClass().getResource("/RevenueManager/RevenueManagerDashboard.fxml"));
   
    
    Scene scene = new Scene(root);
    
    primaryStage.setScene(scene);
    primaryStage.setTitle("RevenueManagerDashboard"); 
    primaryStage.show();
        
       
    
}

    public static void main(String[] args) {
        launch(args);
      
      
        
        
        
        
        
 }

   
        
       
        
}

