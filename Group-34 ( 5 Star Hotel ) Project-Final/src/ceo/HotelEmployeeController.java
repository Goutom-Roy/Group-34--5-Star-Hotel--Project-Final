/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ModelClass.Employee;
import java.awt.Frame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class HotelEmployeeController implements Initializable {

    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee,Integer> idColum;
    @FXML
    private TableColumn<Employee,String> nameColum;
    @FXML
    private TableColumn<Employee,String> gerderColum;
    @FXML
    private TableColumn<Employee,LocalDate> dateofJoinColum;
    @FXML
    private TextField idtextField;
    @FXML
    private TextField nametextField;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private DatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.getItems().addAll("Male","Female","other");
        
       idColum.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
       nameColum.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
       gerderColum.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
       dateofJoinColum.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("joining_date"));
       
       tableView.setItems(this.getEmployee());
        tableView.setEditable(true);
         
       nameColum.setCellFactory(TextFieldTableCell.forTableColumn());
       gerderColum.setCellFactory(TextFieldTableCell.forTableColumn());
       
       tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       
    }   
    public ObservableList<Employee>getEmployee(){
        
        ObservableList<Employee> employee = FXCollections.observableArrayList();
        
        employee.add(new Employee(222034, "Goutom Roy", "Male", LocalDate.of(2002, Month.JULY, 13)));
        employee.add(new Employee(222035, "Goutom Roy1", "Male", LocalDate.of(2003, Month.JUNE, 14)));
        employee.add(new Employee(222036, "Goutom Roy2", "Male", LocalDate.of(2002, Month.JUNE, 16)));
   return employee;
   
    }

    @FXML
    private void addnewEmployeeActionButton(ActionEvent event) {
            try{
            Employee u = new Employee(Integer.parseInt(idtextField.getText()),
                    nametextField.getText(), comboBox.getValue(), datePicker.getValue());
            
            FileOutputStream fos = new FileOutputStream("EmployeeDetailes.bin", true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            dos.writeInt(u.getId());
            dos.writeUTF(u.getName());
            dos.writeUTF(u.getGender());
            LocalDate joiningDate = u.getJoining_date();
             String dateString = joiningDate.toString();
               dos.writeUTF(dateString);
               
//  --------------------------------------
//read
    FileInputStream fis = new FileInputStream("EmployeeDetailes.bin");
    DataInputStream dis = new DataInputStream(fis);

    ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    while (dis.available() > 0) {
        int id = dis.readInt();
        String name = dis.readUTF();
        String gender = dis.readUTF();
        LocalDate joiningDate1 = LocalDate.parse(dis.readUTF());

        employeeList.add(new Employee(id, name, gender, joiningDate1));
    }
  tableView.setItems(employeeList);

    dis.close();
    fis.close();
               
               
            
        }catch (Exception e){
                System.out.println(e);
                
        }
    }

    @FXML
    private void EmployeeDetailsActionButton(ActionEvent event) throws IOException {
        

        try {
           Employee selectedItem = tableView.getSelectionModel().getSelectedItem(); 
          if(selectedItem != null){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EmployeeDetailsScene.fxml"));
        Parent userViewParent = loader.load();
        
        Scene userViewScene = new Scene(userViewParent);
        
        EmployeeDetailsSceneController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(userViewScene);
        window.show();
          }
      else {
            
            Frame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Select a Employee first."); 
            return;
            
         }
            } catch (Exception e) {
                System.out.println(e);
        }
    }

    @FXML
    private void backOnactionButton(ActionEvent event) throws IOException {
        Parent back=FXMLLoader.load(getClass().getResource("CEODashboardScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
