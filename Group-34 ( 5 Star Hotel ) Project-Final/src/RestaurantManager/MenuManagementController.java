/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import ModelClass.Food;
//import User.Restaurant_Manager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MenuManagementController implements Initializable {
    //private Restaurant_Manager restaurantManager;

    @FXML
    private TextField IdtextField;
    @FXML
    private TextField ItemDescriptionTextField;
    @FXML
    private TextField QuantityTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private ComboBox<String> ItemTypeComboBox;
    @FXML
    private ComboBox<String> StatusComboBox;
    @FXML
    private TextField ItemNameTextField;
    @FXML
    private TableView<Food> ItemDetailsTableView;
    @FXML
    private TableColumn<Food, String> IdTableColumn;
    @FXML
    private TableColumn<Food, String> ItemNameTableColumn;
    @FXML
    private TableColumn<Food, String> ItemTypeTableColumn;
    @FXML
    private TableColumn<Food, String> ItemDescriptionTableColumn;
    @FXML
    private TableColumn<Food, String> QuantityTableColumn;
    @FXML
    private TableColumn<Food, String> PriceTableColumn;
    @FXML
    private TableColumn<Food, String> StatusTableColumn;
     Alert unfilledTextField=new Alert(Alert.AlertType.WARNING,"Please enter everything");
     Alert unfilledItemTypeComBox=new Alert(Alert.AlertType.WARNING,"Please Choose Item Type");
      Alert unfilledStatusCBox=new Alert(Alert.AlertType.WARNING,"Please Choose Status");

    //Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added");
    Alert addedTable=new Alert(Alert.AlertType.INFORMATION,"Successfully Added To Table");

//    public void setRestaurantManager(Restaurant_Manager restaurantManager){
//        this.restaurantManager=restaurantManager;
//        ObservableList<Food>  ItemList=FXCollections.observableArrayList();
//         this.restaurantManager.readItemsList(ItemList);
//        ItemDetailsTableView.setItems(ItemList);
//    }
//    public Restaurant_Manager getRestaurantManager(){
//        return restaurantManager;
//    }

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IdTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("id"));
        ItemNameTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("itemName"));
        ItemTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("itemType"));
        ItemDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("itemDescription"));
        QuantityTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("quantity"));
        PriceTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("price"));
        StatusTableColumn.setCellValueFactory(new PropertyValueFactory<Food,String>("status"));
       ItemDetailsTableView.setItems(this. getItems());
        ItemTypeComboBox.getItems().addAll("Appetizers","Main Course","Soup","Side Dishes","Desserts","Bevarages","Drinks");
        StatusComboBox.getItems().addAll("Available","Not Available");
            
            
            
            
            
            
            
        
        //MenuItemsTableView.setItems(this.getItems());
        ItemDetailsTableView.setEditable(true);
        IdTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ItemNameTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ItemTypeTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ItemDescriptionTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        QuantityTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PriceTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        StatusTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ItemDetailsTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // TODO
    }
    public void setFood(ObservableList<Food> ItemDetails){
        ItemDetailsTableView.setItems(ItemDetails);
    }
    public ObservableList<Food>   getItems(){
       ObservableList<Food> ItemDetails=FXCollections.observableArrayList(); 
       ItemDetails.add(new Food("234","Green mango Juice","Drinks","Green Mango,water,sugar","1 Glass","70BDT","Available"));
       ItemDetails.add(new Food("253","Kung Pao Chicken","Main Course","Stir-fried chicken breast with peanuts, bell peppers, and dried chili peppers in a spicy and savory sauce","1 portion","1200BDT","Available"));
       ItemDetails.add(new Food("642","Szechuan Beef","Main Course","Tender beef slices stir-fried with Szechuan peppercorns, chili peppers, and mixed vegetables in a spicy sauce","1 Portion","1200BDT","Available"));
       ItemDetails.add(new Food("167","Garlic Butter Prawns","Main Course","Jumbo prawns sautéed in garlic butter sauce with diced bell peppers, onions, and served with steamed rice","Platter for 2", "1200BDT","Available"));
       ItemDetails.add(new Food("434","Dim Sum Platter","Main Course", "A selection of steamed and fried dim sum including shrimp dumplings, pork buns, and spring rolls, served with soy sauce and chili oil","1 Portion", "1200BDT","Available"));
      
//       ItemDetails.add(new ItemInfo("763","Sweet and Sour Fish"," Crispy fish fillets tossed in a sweet and tangy sauce with bell peppers, onions, and pineapple chunks","Platter for 2", "1200BDT"));
//       ItemDetails.add(new ItemInfo("Yang Chow Fried Rice"," Fried rice with shrimp, chicken, eggs, mixed vegetables, and seasoned with soy sauce","Platter for 2", "700BDT"));
//       ItemDetails.add(new ItemInfo("Chicken Chow Mein"," Stir-fried noodles with Chicken, cabbage, carrots, and onions in a savory sauce.","1 Portion", "800BDT"));
//       ItemDetails.add(new ItemInfo("Hot and Sour Soup"," A spicy and tangy soup made with chicken, mushrooms, tofu, bamboo shoots, and flavored with vinegar and chili sauce.","1bowl", "500BDT"));
//       ItemDetails.add(new ItemInfo("Wonton Soup"," Clear broth soup with wontons filled with minced chicken and shrimp, garnished with green onions and cilantro","1bowl", "450BDT"));
       return ItemDetails;
    }
    

    

    @FXML
    private void addNewItemButtonOnClick(ActionEvent event) {
        String Id=IdtextField.getText();
        if(Id.isEmpty()){
            unfilledTextField.show();
            return;
        }
         String itemName=ItemNameTextField.getText();
        if(itemName.isEmpty()){
            unfilledTextField.show();
            return;
        }
         String itemtype=ItemTypeComboBox.getValue();
        if(itemtype.isEmpty()){
            unfilledItemTypeComBox.show();
            return;
        }
         String itemDescription=ItemDescriptionTextField.getText();
        if(itemDescription.isEmpty()){
            unfilledTextField.show();
            return;
        }
         String quantity=QuantityTextField.getText();
        if(quantity.isEmpty()){
            unfilledTextField.show();
            return;
        }
         String price=priceTextField.getText();
        if(price.isEmpty()){
            unfilledTextField.show();
            return;
        }
         String status=StatusComboBox.getValue();
        if(status.isEmpty()){
            unfilledStatusCBox.show();
            return;
        }
        
        
        //restaurantManager.addNewItem(IdtextField.getText(),ItemNameTextField.getText(),ItemTypeComboBox.getValue(),ItemDescriptionTextField.getText(),QuantityTextField.getText(), priceTextField.getText(),StatusComboBox.getValue());

        
        
        try{
             Food u = new Food(IdtextField.getText(),ItemNameTextField.getText(),ItemTypeComboBox.getValue(),ItemDescriptionTextField.getText(),QuantityTextField.getText(), priceTextField.getText(),StatusComboBox.getValue());
             ItemDetailsTableView.getItems().addAll(u);
            
            FileOutputStream fos = new FileOutputStream("foodStorage.bin", true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            dos.writeUTF(u.getId());
            dos.writeUTF(u.getItemName());
            dos.writeUTF(u.getItemType());
            dos.writeUTF(u.getItemDescription());
            dos.writeUTF(u.getQuantity());
            dos.writeUTF(u.getPrice());
            dos.writeUTF(u.getStatus());
            //read-----------------------------------
            
            FileInputStream fis = new FileInputStream("foodStorage.bin");
            DataInputStream dis = new DataInputStream(fis);

            ObservableList<Food> ItemsList = FXCollections.observableArrayList();

            while (dis.available() > 0){
                
                
                
                
                
             String id = dis.readUTF();
             String ItemName = dis.readUTF();
             String itemType = dis.readUTF();
             String ItemDescription=dis.readUTF();
             String Quantity=dis.readUTF();
             String Price=dis.readUTF();
             String Status=dis.readUTF();
            //LocalDate joiningDate1 = LocalDate.parse(dis.readUTF());

             ItemsList.add(new Food(id, ItemName, itemType,ItemDescription,Quantity,Price,Status ));
             
            }
              ItemDetailsTableView.setItems(ItemsList);

           dis.close();
           fis.close();
               
               
            
        }catch (Exception e){
                System.out.println(e);
                
        }
        addedTable.show();
        IdtextField.clear();
        ItemNameTextField.clear();
        ItemDescriptionTextField.clear();
        QuantityTextField.clear();
        priceTextField.clear();
       
       


            
            

    }

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
        ObservableList<Food> SelectedItem,allItem;
        allItem=ItemDetailsTableView.getItems();
       SelectedItem= ItemDetailsTableView.getSelectionModel().getSelectedItems();
       for(Food i:SelectedItem){
          allItem.remove(i);
       }
        
    }

    @FXML
    private void viewSelectedItemButtonOnClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSelectedItem.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene AddNewItemScene = new Scene(parent);

        currentStage.setScene(AddNewItemScene);
        currentStage.show();
        ViewSelectedItemController controller=loader.getController();
        controller.initData(ItemDetailsTableView.getSelectionModel().getSelectedItem(),ItemDetailsTableView.getItems());
    }

    @FXML
    private void IdTableColumnOnEdit(CellEditEvent event) {
        Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
        SelectedItem.setId(event.getNewValue().toString());
        
        
        
    }

    @FXML
    private void ItemNameTableColumnOnEdit(CellEditEvent event) {
        Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
        SelectedItem.setItemName(event.getNewValue().toString());
 
        
    }

    @FXML
    private void ItemTypeTableColumnOnEdit(CellEditEvent event) {
       Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
       SelectedItem.setItemType(event.getNewValue().toString());

    }

    @FXML
    private void ItemDescriptionTableColumnOnEdit(CellEditEvent event) {
         Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
        SelectedItem.setItemDescription(event.getNewValue().toString());

        
    }

    @FXML
    private void QuantityTableColumnOnEdit(CellEditEvent event) {
         Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
       SelectedItem.setQuantity(event.getNewValue().toString());
    }

    @FXML
    private void PriceTableColumnOnEdit(CellEditEvent event) {
         Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
       SelectedItem.setPrice(event.getNewValue().toString());
    }

    @FXML
    private void StatusTableCOlumnOnEdit(CellEditEvent event) {
       Food SelectedItem=ItemDetailsTableView.getSelectionModel().getSelectedItem();
       SelectedItem.setStatus(event.getNewValue().toString());
    }

    @FXML
    private void returnToDeshboardButtonOnClick(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
        
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
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
