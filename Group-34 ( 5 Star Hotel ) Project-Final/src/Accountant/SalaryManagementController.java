/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;

import java.io.FileWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
               DepartmentTextField.setText("Sales Department");
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
               DepartmentTextField.setText("Food And Bevarage t");
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
              OverTimeHoursTextField.setText("7hr");
               TotalHoursTextField.setText("167hr");
               TaxDeductionsTextField.setText("10000BDT");
               SocialsecurityTextField.setText("4000BDT");
               HealthInsuranceTextField.setText("2000BDT");
               UniformFeeTextField.setText("800BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("367.5BDT");
               TotalDeductionTextField.setText("16800BDT");
               NetSalaryTextField.setText("33567.5BDT");
                GenderTextField.setText("Male");
                break;
            case "175":
                EmployeeNameTextField.setText("Marjana Khanom");
                EmailAddressTextField.setText("marjana026@gmail.com");
               DateOfBirthTextField.setText("2002-04-29");
               DepartmentTextField.setText("Services Department");
               JobTitleTextField.setText("Staff Manager");
               BasicSalaryTextField.setText("43000BDT");
               RegularHoursTextField.setText("160hr");
              OverTimeHoursTextField.setText("5hr");
               TotalHoursTextField.setText("165hr");
               TaxDeductionsTextField.setText("16700BDT");
               SocialsecurityTextField.setText("6000BDT");
               HealthInsuranceTextField.setText("3000BDT");
               UniformFeeTextField.setText("1000BDT");
               OtherDeductionsTextField.setText("0BDT");
               RatePerHourTextField.setText("52.50BDT");
               OverTimeEarningTextField.setText("892.5BDT");
               TotalDeductionTextField.setText("26700BDT");
               NetSalaryTextField.setText("84192.5BDT");
                GenderTextField.setText("Female");                break;
            case "Nexus Supply Co.":
                 EmployeeNameTextField.setText("Goutom Roy");
                EmailAddressTextField.setText("goutom021@gmail.com");
               DateOfBirthTextField.setText("2002-04-23");
               DepartmentTextField.setText("Executive Management Department");
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
           

        }
        
    }

    @FXML
    private void transferSalaryButtonOnClick(ActionEvent event) {
          String monthName=SelectMonthComboBox.getValue();
        if(monthName.isEmpty()){
             unSelectMonth.show();
             return;
        }
         LocalDate date= SalaryPayDatePicker.getValue();
        if(date==null){
            unSelectDate.show();
             return;
        }
         String employeeId=SelectEmployeeIdComboBox.getValue();
        if( employeeId.isEmpty()){
              unSelectId.show();
             return;
        }
         try {
            FileWriter w = new FileWriter("SalaryData.bin",true);
            w.write( SelectMonthComboBox.getValue().toString() +";"+  SelectEmployeeIdComboBox.getValue().toString()+";"+ 
               EmployeeNameTextField.getText().toString()+";"+EmailAddressTextField.getText().toString()+";"+GenderTextField.getText().toString()+";"+ 
                    DateOfBirthTextField.getText().toString()+";"+
                    DepartmentTextField.getText().toString()+";"+JobTitleTextField.getText().toString()+";"+BasicSalaryTextField.getText().toString()+";"+
                    RegularHoursTextField.getText().toString()+";"+ OverTimeHoursTextField.getText().toString()+";"+
                    TotalHoursTextField.getText().toString()+";"+TaxDeductionsTextField.getText().toString()+";"+SocialsecurityTextField.getText().toString()+";"+
                    HealthInsuranceTextField.getText().toString()+";"+UniformFeeTextField.getText().toString()+";"+OtherDeductionsTextField.getText().toString()+";"+
                    NetSalaryTextField.getText().toString()+";"+PaymentMethodComboBox.getValue().toString()+";"+OverTimeEarningTextField.getText().toString()+";"+
                    TotalDeductionTextField.getText().toString()+";"+SalaryPayDatePicker.getValue().toString()+";"+"\n"); 
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
      JOptionPane.showMessageDialog(frame, "Successfully Paid");
            
            
        } catch (Exception e) {
        }
        
        
    }
    
}
