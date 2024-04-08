/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import ModelClass.Meeting;
import java.awt.Frame;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class CEO_MeetingController implements Initializable {

    @FXML
    private MenuBar MenuBar;
    @FXML
    private TableView<Meeting> meetingTable;
    @FXML
    private TableColumn<Meeting,String> topicColumn;
    @FXML
    private TableColumn<Meeting,String> timeColumn;
    @FXML
    private TableColumn<Meeting,LocalDate> dateColumn;
    @FXML
    private TableColumn<Meeting,String> locationColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 topicColumn.setCellValueFactory(new PropertyValueFactory<Meeting,String>("topic"));
         timeColumn.setCellValueFactory(new PropertyValueFactory<Meeting,String>("time"));
         dateColumn.setCellValueFactory(new PropertyValueFactory<Meeting,LocalDate>("date"));
         locationColumn.setCellValueFactory(new PropertyValueFactory<Meeting,String>("location"));
         
         meetingTable.setEditable(true);
                topicColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                locationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
               meetingTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
             
         try {
            
       
        FileReader f= new FileReader("C:/Users/gouto/Netbeans files1/Group Projects/Group-34-(5-Star-Hotel)- Project-Final/Group-34--5-Star-Hotel--Project-Final/Group-34 ( 5 Star Hotel ) Project-Final/src/files/Meetings.txt");
        
        BufferedReader reader = new BufferedReader(f);
        
            String line;
            while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] fields = line.split(";");
            String topic = fields[0];
            String time = fields[1];   
            LocalDate date = LocalDate.parse(fields[2]);
            String location =fields[3];
          Meeting m=new Meeting(topic, time, date, location);
          meetingTable.getItems().add(m);
          

        }
         } catch (Exception e) {
        }
    }    

    @FXML
    private void CreateMeetingOnActionbutton(ActionEvent event) throws IOException {
        
       Parent sceneParent = FXMLLoader.load(getClass().getResource("CEO_MeetingCreateScene.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage stg = (Stage)MenuBar.getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void DetailOnactionButton(ActionEvent event) {
            try {
        
        Meeting selectedItem = meetingTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CEO_MeetingDetails.fxml"));
            Parent meetingViewParent = loader.load();

            Scene userViewScene = new Scene(meetingViewParent);

            CEO_MeetingDetailsController controller = loader.getController();
            controller.initDate(selectedItem);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
            
        }
        else {
            
            Frame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Select a meeting first."); 
            return;
            
         }
        
    } catch (IOException e) {
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
