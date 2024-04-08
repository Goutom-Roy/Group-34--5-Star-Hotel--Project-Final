/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import ModelClass.Project;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerNewProjectController implements Initializable {

    @FXML
    private TableView<Project> tableView;
    @FXML
    private TableColumn<Project, String> nameColumn;
    @FXML
    private TableColumn<Project, LocalDate> datelineColumn;
    @FXML
    private TableColumn<Project, String> detailsColumn;
    @FXML
    private TextField nameTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea detailsTextArea;
    
   private ArrayList<Project> projectList = new ArrayList<>();
 //private ObservableList<Project> projectList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
// Set cell value factories
    nameColumn.setCellValueFactory(new PropertyValueFactory<Project,String>("name"));
    datelineColumn.setCellValueFactory(new PropertyValueFactory<Project,LocalDate>("dateline"));
    detailsColumn.setCellValueFactory(new PropertyValueFactory<Project,String>("detail"));
        //tableView.setItems(projectList);
    }    

    @FXML
    private void saveOnAction(ActionEvent event) {
        
        projectList.add(new Project(nameTextField.getText(), datePicker.getValue(), detailsTextArea.getText()));
        
        tableView.getItems().setAll(projectList);
         nameTextField.clear();
        datePicker.setValue(null);
        detailsTextArea.clear();
     
        
    }
    
}
