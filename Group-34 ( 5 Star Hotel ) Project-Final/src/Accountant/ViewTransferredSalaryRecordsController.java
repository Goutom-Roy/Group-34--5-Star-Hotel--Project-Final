/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Accountant;


//import ModelClass.Due;
import ModelClass.Salary;
import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewTransferredSalaryRecordsController implements Initializable {

    @FXML
    private MenuBar MenuBar;
    @FXML
    private TableView<Salary> EmployeeSalaryTransferredRecordsTableView;
    @FXML
    private TableColumn<Salary,String> MonthTableColumn;
    @FXML
    private TableColumn<Salary,String> IdTableCo;
    @FXML
    private TableColumn<Salary,String> EmployeeTableCo;
//    private TableColumn<Salary,String> EmployeeIdTableCo;
    @FXML
    private TableColumn<Salary,String> GenderTableCo;
    @FXML
    private TableColumn<Salary,String> BirthDateTableCo;
    @FXML
    private TableColumn<Salary,String> DepartmentTableCo;
    @FXML
    private TableColumn<Salary,String> JobTitleTableCo;
    @FXML
    private TableColumn<Salary,String> BasicSalaryTableCo;
    @FXML
    private TableColumn<Salary,String> RegularHrTableCo;
    @FXML
    private TableColumn<Salary,String> OverTimeHrTableCo;
    @FXML
    private TableColumn<Salary,String> TotalHrTableCo;
    @FXML
    private TableColumn<Salary,String> TaxDeductTableCo;
    @FXML
    private TableColumn<Salary,String> SocialSecurityTableCo;
    @FXML
    private TableColumn<Salary,String> HealthInsuTableCo;
    @FXML
    private TableColumn<Salary,String> UniformFeeTableCo;
    @FXML
    private TableColumn<Salary,String> OtherDeductTableCo;
    @FXML
    private TableColumn<Salary,String> ratePerHrTableCo;
    @FXML
    private TableColumn<Salary,String> TotalDeductTableCo;
    @FXML
    private TableColumn<Salary,String> NetSalaryTableCo;
    @FXML
    private TableColumn<Salary,LocalDate> SalaryDateTableCo;
    @FXML
    private TableColumn<Salary,String> PayMethodTableCo;
    @FXML
    private TableColumn<Salary,String> EmployeeEmailIdTableCo;
    @FXML
    private TableColumn<Salary,String> OverTimeEarningTableCo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          MonthTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("month"));
           SalaryDateTableCo.setCellValueFactory(new PropertyValueFactory<Salary,LocalDate>("salaryDate"));
       IdTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("employeeId"));
        EmployeeTableCo.setCellValueFactory(new PropertyValueFactory<Salary,String>("employeeName"));
       EmployeeEmailIdTableCo.setCellValueFactory(new PropertyValueFactory<Salary,String>("emailAddress"));
       GenderTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("gender"));
       BirthDateTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("dateOfBirth"));
       DepartmentTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("departMent"));
        JobTitleTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("jobTitle"));
        BasicSalaryTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("BasicSalary"));
         RegularHrTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("regularHours"));
         OverTimeHrTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("OverTimeHours"));
         TotalHrTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("totalHours"));
         TaxDeductTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("taxDeduction"));
         SocialSecurityTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("socialSecurity"));
          HealthInsuTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("healthInsurance"));
          UniformFeeTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("uniformFees"));
          
          OtherDeductTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("otherDeductions"));
         ratePerHrTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("ratePerHours"));
         OverTimeEarningTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("overTimeEarning"));
         
         TotalDeductTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("totalDeduction"));
          PayMethodTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("paymentMethod"));
          NetSalaryTableCo.setCellValueFactory(new PropertyValueFactory<Salary, String>("netsalary"));
         
         
          try {
            
       
        FileReader f= new FileReader("SalaryData.bin");
        
        BufferedReader reader = new BufferedReader(f);
        
            String line;
            while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] fields = line.split(";");
            String month = fields[0];
            LocalDate salaryDate = LocalDate.parse(fields[1]);
            String employeeId = fields[2];
            String employeeName = fields[3];
            String emailAddress = fields[4];
            String gender = fields[5];
            String dateOfBirth = fields[6];
            String departMent = fields[7];
            String jobTitle= fields[8];
             String basicsalary = fields[9];
            String regualarHours= fields[10];
             String overTimeHr = fields[11];
            String totalhr= fields[12];
             String taxDeductions = fields[13];
            String socialsecurity= fields[14];
             String healthInsu = fields[15];
              String uniformFees= fields[16];
            String otherDeductions= fields[17];
              String ratePerHr = fields[18];
               String overTimeEarning = fields[19];
               String totaldeductions= fields[20];
               String paymentmethod = fields[21];
               String netSalary = fields[22];
           
            
            
           
             
          
            
            
            //LocalDate salaryDate = LocalDate.parse(fields[2]);
//            LocalDate dueDate = LocalDate.parse(fields[3]);
//            String amount = fields[4];
//            String status = fields[5];
//            String payMethod = fields[6];
//            LocalDate date = LocalDate.parse(fields[2]);
//            String location =fields[3];
          Salary s=new Salary(month,salaryDate,employeeId,employeeName,emailAddress,gender,dateOfBirth,departMent,jobTitle,basicsalary,regualarHours,overTimeHr,totalhr, taxDeductions,socialsecurity,healthInsu,uniformFees,otherDeductions,ratePerHr,overTimeEarning,totaldeductions,paymentmethod,netSalary );
           EmployeeSalaryTransferredRecordsTableView.getItems().add(s);
          

        }
         } catch (Exception e) {
        } 
          
        
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
          Parent back=FXMLLoader.load(getClass().getResource("SalaryManagement.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void returnTodashboardButtonOnClick(ActionEvent event) throws IOException {
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
