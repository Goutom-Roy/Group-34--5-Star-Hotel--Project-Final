/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import ModelClass.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewPastOrderController implements Initializable {

    @FXML
    private TableView<Order> OrderDetailsTableView;
    @FXML
    private TableColumn<Order,LocalDate> OrderDateTableColumn;
    @FXML
    private TableColumn<Order,String> OrderIdTableColumn;
    @FXML
    private TableColumn<Order,String> CustomerNameTableColumn;
    @FXML
    private TableColumn<Order,String> OrderItemsTableColumn;
    @FXML
    private TableColumn<Order,String> QuantityTableColumn;
    @FXML
    private TableColumn<Order,String> PerUnitPriceTableColumn;
    @FXML
    private TableColumn<Order,String> TotalPriceTableColumn;
    @FXML
    private TableColumn<Order,String> OrderStatusTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OrderDateTableColumn.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("date"));
        OrderIdTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderId"));
        CustomerNameTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("customerName"));
        OrderItemsTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderItem"));
        QuantityTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("quantity"));
       PerUnitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("perUnitPrice"));
       TotalPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("totalPrice"));
       OrderStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
       OrderDetailsTableView.setItems(this.  getPastOrder());
        // TODO
    }
     public ObservableList<Order>   getPastOrder(){
       ObservableList<Order> OrderDetails=FXCollections.observableArrayList(); 
       OrderDetails.add(new Order(LocalDate.of(2023, Month.SEPTEMBER, 11),"751","Mr.Rahmanul Khan","Chicken Chow Mein\nSzechuan Beef\nSweet and Sour Fish","3 Portion\n2 Portion\nPlatter For 1","570BDT\n900BDT\n770BDT","4280BDT","Accepted"));
       OrderDetails.add(new Order(LocalDate.of(2023, Month.SEPTEMBER, 12),"331","Ms.Zanantul Khatun","Garlic Butter Prawns\nChicken Wonton","2 portion\n1 Platter","520BDTBDT\n430BDT","1470BDT","Accepted"));
       OrderDetails.add(new Order(LocalDate.of(2024, Month.APRIL, 13),"725","Mr.Karim Chowdury","Kung Pao Chicken,Szechuan Beef","2 Portion","370BDT","740BDT","Accepted"));
       OrderDetails.add(new Order(LocalDate.of(2024, Month.APRIL, 14),"521","Ms.Shahenoor Begume","Garlic Butter Prawns","1 portion","300BDT","600BDT","Accepted"));
       return OrderDetails;
     }
    

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
        
        
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
         try{
             FileWriter a = new FileWriter("orderStorage.bin");
             a.write("Date:2023-09-11,731,customerName:Mr.Rahmanul Khan ,orderItem:Chicken Chow Mein"
                     + " , Szechuan Beef"
                     + " , Sweet and Sour Fish,quantity:3 Portion"
                     + " ,2 Portion"
                     + " , Platter For 1,perUnitPrice:570BDT"
                     + " , 900BDT"
                     + " , 770BDT,totalPrice:4280BDT"+"Status:Accepted");
             a.write(" , Dim Sum Platter,quantity:3 Portion"
                     + "Date:2024-04-11,731,customerName:Mr.Rahman Chowdury,orderItem:Kung Pao Chicken"
                     + " , Szechuan Beef"
                     + " , 1 Portion"
                     + " , Platter For 2,perUnitPrice:390BDT"
                     + " , 900BDT"
                     + " , 650BDT,totalPrice:3330BDT");
             a.close();
          }catch(Exception e){
              System.out.println("Error occured");
              
        
          
        
          }
         
         try {
            File myFile = new File("orderStorage.bin");
            Scanner myReader = new Scanner(myFile);
            ObservableList<String> orderList=FXCollections.observableArrayList();
            while (myReader.hasNextLine()) {
                String myText = myReader.nextLine();
                orderList.add(myText);
                //System.out.println(myText);
                //OrderDetailsTableView.setItems(myText);
            }
            //OrderDetailsTableView.setItems(orderList);
            myReader.close();
//            System.out.println(myFile.length());
//            System.out.println(myFile.getAbsolutePath());

            
        } catch (Exception e) {
            System.out.println("Error occured");
        }

         
    
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderManagement.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
    }
}
