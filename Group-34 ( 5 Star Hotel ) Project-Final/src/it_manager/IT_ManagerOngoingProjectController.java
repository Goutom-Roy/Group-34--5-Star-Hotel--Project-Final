/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;


import ModelClass.Project;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerOngoingProjectController implements Initializable {

    @FXML
    private TableView<Project> tableView;
    @FXML
    private TableColumn<Project, String> nameColumn;
    @FXML
    private TableColumn<Project, LocalDate> datelineColumn;
    @FXML
    private TableColumn<Project, String> detailsColumn;
     // ObservableList to hold Project objects
    private ObservableList<Project> projectList = FXCollections.observableArrayList();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
// Set cell value factories
    nameColumn.setCellValueFactory(new PropertyValueFactory<Project,String>("name"));
    datelineColumn.setCellValueFactory(new PropertyValueFactory<Project,LocalDate>("dateline"));
    detailsColumn.setCellValueFactory(new PropertyValueFactory<Project,String>("detail"));
          
    projectList.add(new Project("Project 1", LocalDate.now().plusYears(2024), "Details 1"));
    projectList.add(new Project("Project 2", LocalDate.now().plusMonths(1), "Details 3"));
    projectList.add(new Project("Project 3", LocalDate.now().plusDays(8), "Details 4"));
    projectList.add(new Project("Project 4", LocalDate.now().plusDays(9), "Details 5"));
    tableView.setItems(projectList);
          
          
          
       
    }    
    
}
