/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import ModelClass.Feedback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEO_feedbackController implements Initializable {


    @FXML
    private MenuBar menuBar;
    @FXML
    private TableView<Feedback> tableView;
    @FXML
    private TableColumn<Feedback,String> costomernameColimn;
    @FXML
    private TableColumn<Feedback,Integer> ratingColumn;
    @FXML
    private TableColumn<Feedback,String> detailsColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                costomernameColimn.setCellValueFactory(new PropertyValueFactory<Feedback,String>("Costomer_name"));
                ratingColumn.setCellValueFactory(new PropertyValueFactory<Feedback,Integer>("rating"));
                detailsColumn.setCellValueFactory(new PropertyValueFactory<Feedback,String>("details"));
        
              Feedback f =new Feedback("Goutom Roy", 5,"Restoreant service was very good");
        Feedback f1 =new Feedback("Goutom Roy1", 4,"Restoreant service was very good");
        Feedback f2 =new Feedback("Goutom Roy2", 3,"Restoreant service was very good");
        tableView.getItems().add(f);
        tableView.getItems().add(f1);
        tableView.getItems().add(f2);
        
    }    


    @FXML
    private void backOnActionButton(ActionEvent event) throws IOException {
        Parent back=FXMLLoader.load(getClass().getResource("CEODashboardScene.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1= (Stage)menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
       
    }

    
}
