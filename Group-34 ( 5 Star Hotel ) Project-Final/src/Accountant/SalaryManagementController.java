/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SalaryManagementController implements Initializable {

    @FXML
    private TextField EmailAddressTextField;
    @FXML
    private TextField GenderTextField;
    @FXML
    private TextField DateOfBirthTextField;
    @FXML
    private ComboBox<String> SelectEmployeeIdComboBox;
    @FXML
    private TextField DepartmentTextField;
    @FXML
    private TextField JobTitleTextField;
    @FXML
    private TextField BasicSalaryTextField;
    @FXML
    private TextField RegularHoursTextField;
    @FXML
    private TextField OverTimeHoursTextField;
    @FXML
    private ComboBox<String> SelectMonthComboBox;
    @FXML
    private TextField TotalHoursTextField;
    @FXML
    private TextField TaxDeductionsTextField;
    @FXML
    private TextField SocialsecurityTextField;
    @FXML
    private TextField HealthInsuranceTextField;
    @FXML
    private TextField UniformFeeTextField;
    @FXML
    private ComboBox<String> PaymentMethodComboBox;
    @FXML
    private TextField NetSalaryTextField;
    @FXML
    private DatePicker SalaryPayDatePicker;
    @FXML
    private TextField EmployeeNameTextField;
    @FXML
    private TextField RatePerHourTextField;
    @FXML
    private TextField OverTimeEarningTextField;
    @FXML
    private TextField TotalDeductionTextField;
    @FXML
    private TextField OtherDeductionsTextField;
    Alert unSelectMonth=new Alert(Alert.AlertType.WARNING,"Please Select Month");
    Alert unSelectDate=new Alert(Alert.AlertType.WARNING,"Please Select Date");
    Alert unSelectId=new Alert(Alert.AlertType.WARNING,"Please Select employee Id");
    @FXML
    private MenuBar MenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SelectMonthComboBox.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");
        SelectEmployeeIdComboBox.getItems().addAll("213","731","735","971","175","534","241","263","124","753");
        PaymentMethodComboBox.getItems().addAll("Bank Transfer","Credit Card");
        
        // TODO
    }    

    @FXML
    private void SelectEmployeeIdComboBoxOnClick(ActionEvent event) {
         switch (SelectEmployeeIdComboBox.getValue()) {
            case "213":
                EmployeeNameTextField.setText("Goutom Roy");
                EmailAddressTextField.setText("goutom021@gmail.com");
               DateOfBirthTextField.setText("2002-04-23");
               DepartmentTextField.setText("Executive Management ");
               JobTitleTextField.setText("Cheif executive Officer(CEO)");
               BasicSalaryTextField.setText("110000");
               RegularHoursTextField.setText("160hr");
              OverTimeHoursTextField.setText("17hr");
               TotalHoursTextField.setText("177hr");
               TaxDeductionsTextField.setText("16700BDT");
               SocialsecurityTextField.setText("6000BDT");
               HealthInsuranceTextField.setText("3000BDT");
               UniformFeeTextField.setText("1000BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("892.5BDT");
               TotalDeductionTextField.setText("26700BDT");
               NetSalaryTextField.setText("84192.5BDT");
                GenderTextField.setText("Male");
               
                break;
            case "731":
                EmployeeNameTextField.setText("Ayesha Akhter Meghla");
                EmailAddressTextField.setText("ayesha0341@gmail.com");
               DateOfBirthTextField.setText("2002-04-21");
               DepartmentTextField.setText("Sales and Marketing");
               JobTitleTextField.setText("Sales Manager");
               BasicSalaryTextField.setText("89000BDT");
               RegularHoursTextField.setText("160hr");
              OverTimeHoursTextField.setText("10hr");
               TotalHoursTextField.setText("170hr");
               TaxDeductionsTextField.setText("15700BDT");
               SocialsecurityTextField.setText("5000BDT");
               HealthInsuranceTextField.setText("2500BDT");
               UniformFeeTextField.setText("900BDT");
               OtherDeductionsTextField.setText("10BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("525BDT");
               TotalDeductionTextField.setText("24110BDT");
               NetSalaryTextField.setText("63415BDT");
               GenderTextField.setText("Female");
                break;
                
            case "735":
                 EmployeeNameTextField.setText("Mosammad Maherun Nesa");
                EmailAddressTextField.setText("maherun093@gmail.com");
               DateOfBirthTextField.setText("2002-04-27");
               DepartmentTextField.setText("Department of Food Preparation");
               JobTitleTextField.setText("Restaurant Manager");
               BasicSalaryTextField.setText("87000BDT");
               RegularHoursTextField.setText("160hr");
              OverTimeHoursTextField.setText("9hr");
               TotalHoursTextField.setText("169hr");
               TaxDeductionsTextField.setText("15000BDT");
               SocialsecurityTextField.setText("5000BDT");
               HealthInsuranceTextField.setText("2500BDT");
               UniformFeeTextField.setText("900BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("472.5BDT");
               TotalDeductionTextField.setText("23400BDT");
               NetSalaryTextField.setText("64072.5BDT");
               GenderTextField.setText("Female");
                break;
            case "971":
                EmployeeNameTextField.setText("Mahmudur Hasan Bijoy");
                EmailAddressTextField.setText("mahmudur022@gmail.com");
               DateOfBirthTextField.setText("2002-04-25");
               DepartmentTextField.setText("Front Office Department");
               JobTitleTextField.setText("Hotel Receiptionist");
               BasicSalaryTextField.setText("50000");
               RegularHoursTextField.setText("160hr");
              //OverTimeHoursTextField.setText("7hr");
               //TotalHoursTextField.setText("167hr");
               TaxDeductionsTextField.setText("10000BDT");
               SocialsecurityTextField.setText("4000BDT");
               HealthInsuranceTextField.setText("2000BDT");
               UniformFeeTextField.setText("800BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               //OverTimeEarningTextField.setText("367.5BDT");
               //TotalDeductionTextField.setText("16800BDT");
               //NetSalaryTextField.setText("33567.5BDT");
                GenderTextField.setText("Male");
                break;
            case "175":
                EmployeeNameTextField.setText("Mosammad Maherun Neas");
                EmailAddressTextField.setText("maherun037@gmail.com");
               DateOfBirthTextField.setText("2002-04-17");
               DepartmentTextField.setText("Accounts Department");
               JobTitleTextField.setText("Accountant");
               BasicSalaryTextField.setText("70000BDT");
               RegularHoursTextField.setText("160hr");
              OverTimeHoursTextField.setText("17hr");
               TotalHoursTextField.setText("177hr");
               TaxDeductionsTextField.setText("15000BDT");
               SocialsecurityTextField.setText("3000BDT");
               HealthInsuranceTextField.setText("2000BDT");
               UniformFeeTextField.setText("700BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("892.5BDT");
               TotalDeductionTextField.setText("20700BDT");
               NetSalaryTextField.setText("50192.5BDT");
                GenderTextField.setText("Female");                
                break;
            case "534":
               EmployeeNameTextField.setText("Goutom Roy");
                EmailAddressTextField.setText("goutom019@gmail.com");
               DateOfBirthTextField.setText("2002-04-19");
               DepartmentTextField.setText("Information Technology Department");
               JobTitleTextField.setText("IT Manager");
               BasicSalaryTextField.setText("60000");
               RegularHoursTextField.setText("160hr");
              OverTimeHoursTextField.setText("5hr");
               TotalHoursTextField.setText("165hr");
               TaxDeductionsTextField.setText("10000BDT");
               SocialsecurityTextField.setText("3000BDT");
               HealthInsuranceTextField.setText("2000BDT");
               UniformFeeTextField.setText("700BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("262.5BDT");
               TotalDeductionTextField.setText("15700BDT");
               NetSalaryTextField.setText("44562.5BDT");
                GenderTextField.setText("Male");
                break;
           

        }
        
    }

    @FXML
    private void transferSalaryButtonOnClick(ActionEvent event) {
          String monthName=SelectMonthComboBox.getValue();
        if(monthName==null){
             unSelectMonth.show();
             return;
        }
         LocalDate date= SalaryPayDatePicker.getValue();
        if(date==null){
            unSelectDate.show();
             return;
        }
         String employeeId=SelectEmployeeIdComboBox.getValue();
        if( employeeId==null){
              unSelectId.show();
             return;
        }
         try {
            FileWriter w = new FileWriter("SalaryData.bin",true);
            w.write( SelectMonthComboBox.getValue().toString() +";"+SalaryPayDatePicker.getValue().toString()+";"+  SelectEmployeeIdComboBox.getValue().toString()+";"+ 
               EmployeeNameTextField.getText().toString()+";"+EmailAddressTextField.getText().toString()+";"+GenderTextField.getText().toString()+";"+ 
                    DateOfBirthTextField.getText().toString()+";"+
                    DepartmentTextField.getText().toString()+";"+JobTitleTextField.getText().toString()+";"+BasicSalaryTextField.getText().toString()+";"+
                    RegularHoursTextField.getText().toString()+";"+ OverTimeHoursTextField.getText().toString()+";"+
                    TotalHoursTextField.getText().toString()+";"+TaxDeductionsTextField.getText().toString()+";"+SocialsecurityTextField.getText().toString()+";"+
                    HealthInsuranceTextField.getText().toString()+";"+UniformFeeTextField.getText().toString()+";"+OtherDeductionsTextField.getText().toString()+";"+
                    RatePerHourTextField.getText().toString()+";"+OverTimeEarningTextField.getText().toString()+";"+TotalDeductionTextField.getText().toString()+";"+PaymentMethodComboBox.getValue().toString()+";"+NetSalaryTextField.getText().toString()+";"+
                   "\n"); 
            w.close();
            
           EmployeeNameTextField.clear();
             EmailAddressTextField.clear();
            //datePicker.setValue(null);
          GenderTextField.clear();
           DateOfBirthTextField.clear();
          DepartmentTextField.clear();
      JobTitleTextField.clear();
         BasicSalaryTextField.clear();
          RegularHoursTextField.clear();
          OverTimeHoursTextField.clear();
          TotalHoursTextField.clear();
          TaxDeductionsTextField.clear();
          SocialsecurityTextField.clear();
            HealthInsuranceTextField.clear();
            UniformFeeTextField.clear();
            OtherDeductionsTextField.clear();
             NetSalaryTextField.clear();
             OverTimeEarningTextField.clear();
              TotalDeductionTextField.clear();
             SalaryPayDatePicker.setValue(null);
             PaymentMethodComboBox.setValue(null);
             SelectMonthComboBox.setValue(null);
             SelectEmployeeIdComboBox.setValue(null);
         
         
         
            
          JFrame frame = new JFrame();
          JOptionPane.showMessageDialog(frame, "Successfully Transfer the Salary");
            
            
        } catch (Exception e) {
        }
        
        
    }

    @FXML
    private void viewSalaryTransferRecordButtonOnclick(ActionEvent event) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("ViewTransferredSalaryRecords.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage stg = (Stage)MenuBar.getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent back=FXMLLoader.load(getClass().getResource("ViewPendingDueDetails.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show(); 
    }

    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
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
