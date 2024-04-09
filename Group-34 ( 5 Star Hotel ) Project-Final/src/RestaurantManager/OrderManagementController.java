/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import ModelClass.Food;
import ModelClass.Order;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class OrderManagementController implements Initializable {

    @FXML
    private TableView<Order> OrderDetailsTableView;
    @FXML
    private TableColumn<Order, LocalDate> OrderDateTableColumn;
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
     Alert acceptOrder=new Alert(Alert.AlertType.INFORMATION,"Order is accepted");
     Alert rejectOrder=new Alert(Alert.AlertType.INFORMATION,"Order is rejected");
      Alert statusAccepted=new Alert(Alert.AlertType.INFORMATION,"Update Pending Order Status to accepted");
      Alert warningMsg=new Alert(Alert.AlertType.WARNING,"Please Select the row from table");

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
       OrderDetailsTableView.setItems(this. getOrders());
        // TODO
    }
     public ObservableList<Order>   getOrders(){
       ObservableList<Order> OrderDetails=FXCollections.observableArrayList(); 
       OrderDetails.add(new Order(LocalDate.of(2024, Month.APRIL, 11),"731","Mr.Rahman Chowdury","Kung Pao Chicken\nSzechuan Beef\nDim Sum Platter","3 Portion\n1 Portion\nPlatter For 2","390BDT\n900BDT\n650BDT","3330BDT","Pending"));
       OrderDetails.add(new Order(LocalDate.of(2024, Month.APRIL, 12),"321","Ms.Zanantul Begume","Garlic Butter Prawns\nSzechuan Beef\nCappuccino","Platter For 2\n1 Portion\n2 cup","450BDT\n900BDT\n150BDTBDT","2100BDT","Pending"));
       OrderDetails.add(new Order(LocalDate.of(2024, Month.APRIL, 13),"725","Mr.Karim Chowdury","Kung Pao Chicken\nSzechuan Beef\nThai Soup","2 Portion\n1 Portion\n350ml","390BDT\n900BDT\n270BDT","2180BDT","Pending"));
       OrderDetails.add(new Order(LocalDate.of(2024, Month.APRIL, 14),"521","Ms.Shahenoor Begume","Dim Sum Platter\nChicken Noodle Soup","1 portion\n250ml","450BDT\n270BDT","720BDT","Pending"));
       return OrderDetails;
     }

    @FXML
    private void acceptButtonOnClick(ActionEvent event) {
           Order SelectedRow= OrderDetailsTableView.getSelectionModel().getSelectedItem();
          if (SelectedRow==null){
               warningMsg.show();
              return;
          }
           acceptOrder.show();
          
//          String x;
//          if(x.matches(x)SelectedRow){
//              
//          }
          
        try{
             FileWriter a = new FileWriter("orderStorage.bin");
             a.write("Date:2024-04-11,731,customerName:Mr.Rahman Chowdury,orderItem:Kung Pao Chicken"
                     + " , Szechuan Beef"
                     + " , Dim Sum Platter,quantity:3 Portion"
                     + " , 1 Portion"
                     + " , Platter For 2,perUnitPrice:390BDT"
                     + " , 900BDT"
                     + " , 650BDT,totalPrice:3330BDT");
             a.close();
          }catch(Exception e){
              System.out.println("Error occured");
          }

        ObservableList<Order> SelectedOrder,allOrder;
        allOrder= OrderDetailsTableView.getItems();
       SelectedOrder=  OrderDetailsTableView.getSelectionModel().getSelectedItems();
       for(Order i:SelectedOrder){
          allOrder.remove(i);
       }
       acceptOrder.show();
        
    }
          

    @FXML
    private void rejectButtonOnClick(ActionEvent event) {
          Order SelectedRow= OrderDetailsTableView.getSelectionModel().getSelectedItem();
          if (SelectedRow==null){
               warningMsg.show();
              return;
          }
         ObservableList<Order> SelectedOrder,allOrder;
        allOrder= OrderDetailsTableView.getItems();
       SelectedOrder=  OrderDetailsTableView.getSelectionModel().getSelectedItems();
       for(Order i:SelectedOrder){
          allOrder.remove(i);
       }
       rejectOrder.show();
        
    }

    @FXML
    private void updateOrderStatusToAccepted(ActionEvent event) {
          Order SelectedRow= OrderDetailsTableView.getSelectionModel().getSelectedItem();
          if (SelectedRow==null){
               warningMsg.show();
              return;
          }
        statusAccepted.show();
        
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
    private void viewPastOrder(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewPastOrder.fxml"));
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
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotificationShowScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
    }
    
}
