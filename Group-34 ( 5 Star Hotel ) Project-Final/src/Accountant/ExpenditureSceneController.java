/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import ModelClass.Expense;
import ModelClass.Food;
import RestaurantManager.ViewSelectedItemController;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
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
public class ExpenditureSceneController implements Initializable {

    @FXML
    private DatePicker ExpenseDatePicker;
    @FXML
    private ComboBox<String> ExpenseCatagoryComboBox;
    @FXML
    private TextField SupplierTextField;
    @FXML
    private ComboBox<String> PaymentMethodComboBox;
    @FXML
    private TextField AmountTextField;
    @FXML
    private TextField ExpenseDescriptionTextField;
    @FXML
    private TableView<Expense> ExpenseRecordTableView;
    @FXML
    private TableColumn<Expense, LocalDate> DateTableColumn;
    @FXML
    private TableColumn<Expense,String> ExpenseCatagoryTableColumn;
    @FXML
    private TableColumn<Expense,String> ExpenseDescriptionTableColumn;
    @FXML
    private TableColumn<Expense,String> AmountTableColumn;
    @FXML
    private TableColumn<Expense,String> PaymentMethodTableColumn;
    @FXML
    private TableColumn<Expense,String> SupplierTableColumn;
    Alert unfilledTextField=new Alert(Alert.AlertType.WARNING,"Please enter everything");
     Alert unfilledExpenseCatagoryComBox=new Alert(Alert.AlertType.WARNING,"Please Choose Expense Catagory");
      Alert unfilledPaymentMethod=new Alert(Alert.AlertType.WARNING,"Please Choose Payment Method");

    //Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added");
    Alert addedTable=new Alert(Alert.AlertType.INFORMATION,"Successfully Added To Table");
    Alert unselectRow=new Alert(Alert.AlertType.WARNING,"Please Select the row from the table");
    @FXML
    private MenuBar MenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTableColumn.setCellValueFactory(new PropertyValueFactory<Expense,LocalDate>("date"));
       ExpenseCatagoryTableColumn.setCellValueFactory(new PropertyValueFactory<Expense,String>("expenseCatagory"));
        ExpenseDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Expense,String>("expenseDescription"));
        AmountTableColumn.setCellValueFactory(new PropertyValueFactory<Expense,String>("amount"));
        PaymentMethodTableColumn.setCellValueFactory(new PropertyValueFactory<Expense,String>("paymentMethod"));
        SupplierTableColumn.setCellValueFactory(new PropertyValueFactory<Expense,String>("supplier"));
        
       ExpenseRecordTableView.setItems(this. getExpenses());
        ExpenseCatagoryComboBox.getItems().addAll("Utilities","Maintenance","Staff Costs","Supplies","Food and Bevarage","Marketing","Property expenses","Administrative Expenses","hospitality Services");
       PaymentMethodComboBox.getItems().addAll("Cash","Credit Card","Bank Transfer");
            
            
            
            
            
            
            
        
        //MenuItemsTableView.setItems(this.getItems());
        DateTableColumn.setEditable(true);
        ExpenseCatagoryTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       ExpenseDescriptionTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        AmountTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PaymentMethodTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        SupplierTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        ExpenseRecordTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // TODO
    }
     public void setExpense(ObservableList<Expense> ExpenseDetails){
        ExpenseRecordTableView.setItems( ExpenseDetails);
    }
    public ObservableList<Expense>   getExpenses(){
       ObservableList<Expense> ExpenseDetails=FXCollections.observableArrayList(); 
        ExpenseDetails.add(new Expense(LocalDate.of(2024, Month.MARCH, 27),"Utilities","Electricity Bill","15000","Credit Card","Power Utility Co"));
        ExpenseDetails.add(new Expense(LocalDate.of(2024, Month.MARCH, 28),"Maintenance","Building Repairs","35000","Credit Card","Maintenance Inc"));
        ExpenseDetails.add(new Expense(LocalDate.of(2024, Month.MARCH, 29),"Stuff Costs","salaries and wages","25000","Bank Transfer","Staffing Agencies LTD"));
        return ExpenseDetails;
    }
      
    

    @FXML
    private void addExpenseButtonOnClick(ActionEvent event) {
        String expctg=ExpenseCatagoryComboBox.getValue();
        if(expctg.isEmpty()){
             unfilledExpenseCatagoryComBox.show();
             return;
        }
        String expDescription=ExpenseDescriptionTextField.getText();
        if(expDescription.isEmpty()){
             unfilledTextField.show();
             return;
        }
        String aMount=AmountTextField.getText();
        if(aMount.isEmpty()){
              unfilledTextField.show();
             return;
        }
        String payMethod=ExpenseCatagoryComboBox.getValue();
        if( payMethod.isEmpty()){
             unfilledPaymentMethod.show();
             return;
        }
        String suPPlier=ExpenseCatagoryComboBox.getValue();
        if(suPPlier.isEmpty()){
            unfilledTextField.show();
             return;
        }
        
        
//        LocalDate Date=ExpenseDatePicker.getValue();
//        if(Date.isEm)
         try{
             Expense u = new Expense(ExpenseDatePicker.getValue(),ExpenseCatagoryComboBox.getValue(),ExpenseDescriptionTextField.getText(),AmountTextField.getText(),PaymentMethodComboBox.getValue(), SupplierTextField.getText());
             ExpenseRecordTableView.getItems().addAll(u);
            
            FileOutputStream fos = new FileOutputStream("ExpenseRecords.bin", true);
            DataOutputStream dos = new DataOutputStream(fos);
            
           LocalDate date=u.getDate();
           String dateString=date.toString();
           dos.writeUTF(dateString);
            dos.writeUTF(u.getExpenseCatagory());
            dos.writeUTF(u.getExpenseDescription());
            dos.writeUTF(u.getAmount());
            dos.writeUTF(u.getPaymentMethod());
            dos.writeUTF(u.getSupplier());
            
            //read-----------------------------------
            
            FileInputStream fis = new FileInputStream("ExpenseRecords.bin");
            DataInputStream dis = new DataInputStream(fis);

            ObservableList<Expense> ExpenseList = FXCollections.observableArrayList();

            while (dis.available() > 0){
                
                
                
                
                
            LocalDate date1=LocalDate.parse(dis.readUTF());
             String expenseCatagory = dis.readUTF();
             String expenseDescription = dis.readUTF();
             String amount=dis.readUTF();
             String paymentMethod=dis.readUTF();
             String supplier=dis.readUTF();
             
            //LocalDate joiningDate1 = LocalDate.parse(dis.readUTF());

             ExpenseList.add(new Expense(date1,expenseCatagory,expenseDescription,amount,paymentMethod,supplier));
             
             
            }
              ExpenseRecordTableView.setItems(ExpenseList);

           dis.close();
           fis.close();
               
               
            
        }catch (Exception e){
                System.out.println(e);
                
        }
        SupplierTextField.clear();
        AmountTextField.clear();
        ExpenseDescriptionTextField.clear();
        addedTable.show();
        
        

    }

    @FXML
    private void viewExpenseDetailsButtonOnClick(ActionEvent event) throws IOException {
         Expense SelectedExpense=ExpenseRecordTableView.getSelectionModel().getSelectedItem();
         if(SelectedExpense==null){
             unselectRow.show();
             return;
         }
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpenseDetailsScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene ExpenseDetailsScene = new Scene(parent);
        currentStage.setScene( ExpenseDetailsScene );
        currentStage.show();
       ExpenseDetailsSceneController controller=loader.getController();
        controller.initData(ExpenseRecordTableView.getSelectionModel().getSelectedItem(),ExpenseRecordTableView.getItems());
        
    }

    @FXML
    private void RemoveExpenseButtonOnClick(ActionEvent event) {
         ObservableList<Expense> SelectedExpense,allExpense;
        allExpense=ExpenseRecordTableView.getItems();
       SelectedExpense= ExpenseRecordTableView.getSelectionModel().getSelectedItems();
       for(Expense i:SelectedExpense){
          allExpense.remove(i);
       }
        
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene ExpenseDetailsScene = new Scene(parent);
        currentStage.setScene( ExpenseDetailsScene );
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

    @FXML
    private void dateTableColumnOnEdit(CellEditEvent event) {
//        Expense SelectedItem=ExpenseRecordTableView.getSelectionModel().getSelectedItem();
//        SelectedItem.getDate(event.getNewValue().toString());
    }

    @FXML
    private void expenseCatagoryTableColumnOnEdit(CellEditEvent event) {
//         Expense SelectedItem=ExpenseRecordTableView.getSelectionModel().getSelectedItem();
//        SelectedItem.getExpenseCatagory(event.getNewValue().toString());
    }

    @FXML
    private void expenseDescriptionTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void amountTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void paymentMethodTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void supplierTableColumnOnEdit(CellEditEvent event) {
    }

    @FXML
    private void viewExpenseChartButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("ExpensePieChart.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
