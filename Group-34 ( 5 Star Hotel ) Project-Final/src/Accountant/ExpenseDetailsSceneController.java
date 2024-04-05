/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import ModelClass.Expense;
import ModelClass.Food;
import RestaurantManager.MenuManagementController;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ExpenseDetailsSceneController implements Initializable {

    @FXML
    private Label ExpenseDateLabel;
    @FXML
    private Label ExpenseCatagoryLabel;
    @FXML
    private Label ExpenseDescriptionLabel;
    @FXML
    private Label AmountLabel;
    @FXML
    private Label PaymentMethodLabel;
    @FXML
    private Label SupplierLabel;
     ObservableList<Expense> expenseList=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpenditureScene.fxml"));
        Parent parent = loader.load();
        ExpenditureSceneController add=loader.getController();
        add.setExpense(expenseList);

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene ExpenditureScene = new Scene(parent);

        currentStage.setScene( ExpenditureScene);
        currentStage.show();
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }

    void initData(Expense selectedItem, ObservableList<Expense> expenseList) {
        ExpenseDateLabel.setText( selectedItem.getDate().toString());
        ExpenseCatagoryLabel.setText(selectedItem.getExpenseCatagory());
        ExpenseDescriptionLabel.setText(selectedItem.getExpenseDescription());
        AmountLabel.setText(selectedItem.getAmount());
        PaymentMethodLabel.setText(selectedItem.getPaymentMethod());
        this.expenseList=expenseList;
        SupplierLabel.setText(selectedItem.getSupplier());
        
        
        
    }
    
}
