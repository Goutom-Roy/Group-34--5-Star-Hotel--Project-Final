
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import ModelClass.ManageDiscount;


public class RevenueManagerManagediscountsController implements Initializable {

    @FXML
    private Button Viewbuttonfxid;
    @FXML
    private TableView<ManageDiscount> DiscountTablefxid;
    @FXML
    private TableColumn<ManageDiscount, String> Discountcolumnfxid;
    @FXML
    private TableColumn<ManageDiscount, Double> Amountcolumnfxid;
    @FXML
    private TableColumn<ManageDiscount, String> Statuscolumnfxid;
    @FXML
    private Button Nextbuttonfxid;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the TableView columns
        Discountcolumnfxid.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        Amountcolumnfxid.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        Statuscolumnfxid.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

       
        setExampleDiscounts();
    }

    @FXML
    private void OnclickviewButton(ActionEvent event) {
      
        setExampleDiscounts();
        
        
      
    try {
        FileWriter writer = new FileWriter("discounts_data.txt");
        for (ManageDiscount discount : DiscountTablefxid.getItems()) {
            writer.write("Room: "+discount.getName() + ", " +"Discount: "+ discount.getAmount() + ", " + "Status: " + discount.getStatus() + "\n");
        }
        writer.close();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
    }

    private void setExampleDiscounts() {
        // Create example discount data
        ManageDiscount discount1 = new ManageDiscount("Single Room", 20.0, "Active");
        ManageDiscount discount2 = new ManageDiscount("Double Room", 20.0, "Active");
        ManageDiscount discount3 = new ManageDiscount("Family Room", 20.0, "Active");

        
        DiscountTablefxid.getItems().clear();
        
       
        DiscountTablefxid.getItems().addAll(discount1, discount2, discount3);
    }

    @FXML
    private void Onclicknextbutton(ActionEvent event) throws IOException {
       
        
          Stage stage = null;
        Parent root = null;
        
           if(event.getSource()== Nextbuttonfxid){
             
             
            stage = (Stage) Nextbuttonfxid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RevenueManagerGenerateReport.fxml"));
        
        
        }
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GenerateReport");
        stage.show();
        
        
        
        
        
        
        
        
        
    }

    @FXML
    private void OnclickDeleteButton(ActionEvent event) {
        
        int selectedIndex = DiscountTablefxid.getSelectionModel().getSelectedIndex();
    
   
    if (selectedIndex >= 0) {
        
        DiscountTablefxid.getItems().remove(selectedIndex);
    } else {
      
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText(null);
        alert.setContentText("Please select a discount to delete.");
        alert.showAndWait();
    }
        
        
    }
}
