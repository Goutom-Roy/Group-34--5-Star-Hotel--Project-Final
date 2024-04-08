/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;


import ModelClass.Mail;

import java.awt.Frame;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerMailDashBoardController implements Initializable {

    @FXML
    private TableView<Mail> tableView;
    @FXML
    private TableColumn<Mail, String> subjectColumn;
    @FXML
    private TableColumn<Mail, String> timeColumn;
    @FXML
    private TableColumn<Mail, LocalDate> dateColumn;
    @FXML
    private TableColumn<Mail, String> detailsColumn;
    
// ObservableList to hold Project objects
    private ObservableList<Mail> mailList = FXCollections.observableArrayList();
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          subjectColumn.setCellValueFactory(new PropertyValueFactory<Mail,String>("subject"));
          timeColumn.setCellValueFactory(new PropertyValueFactory<Mail,String>("time"));
          dateColumn.setCellValueFactory(new PropertyValueFactory<Mail,LocalDate>("date"));
          detailsColumn.setCellValueFactory(new PropertyValueFactory<Mail,String>("detail"));
          
   mailList.add(new Mail("Your Exclusive Invitation to Experience Luxury ", "12.00pm", LocalDate.now().minusDays(2), "Dear [Recipient's Name],\n" +
"\n"+"We are thrilled to extend to you an exclusive invitation to indulge in a world of luxury at our prestigious 5-star hotel."
            + " Nestled in the heart of [City/Area], our hotel promises an unparalleled experience of opulence,"
            + " sophistication, and unmatched hospitality.Here are some details of what awaits you during your stay:"));
    mailList.add(new Mail("Elevate Your Getaway: Discover Unmatched Luxury ", "11.09pm", LocalDate.now().minusDays(3), "Escape to a realm of unmatched luxury and unparalleled hospitality at our esteemed 5-star hotel in Rangpur."));
    mailList.add(new Mail("Elevate Your Getaway: Discover Unmatched Luxury", "07.56pm", LocalDate.now().minusDays(3), "Escape to a realm of unmatched luxury and unparalleled hospitality at our esteemed"));
    mailList.add(new Mail("Elevate Your Getaway: Discover Unmatched Luxury", "08.10pm", LocalDate.now().minusDays(2), "Escape to a realm of unmatched luxury and unparalleled hospitality at our esteemed"));

    tableView.setItems(mailList);
          
          
        
        // TODO
    }    

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("IT_ManagerDashboardScene.fxml"));
        Scene newScene = new Scene(back);
        Stage stg1 = (Stage) menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void closeOnAction(ActionEvent event) {
       Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void detailsOnAction(ActionEvent event) {
                try {
            
      Mail selectedItem = tableView.getSelectionModel().getSelectedItem();
      if(selectedItem != null){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("IT_ManagerMailDetailsScene.fxml"));
        Parent userViewParent = loader.load();
        
        Scene userViewScene = new Scene(userViewParent);
        
        IT_ManagerMailDetailsSceneController controller = loader.getController();
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
    
}
