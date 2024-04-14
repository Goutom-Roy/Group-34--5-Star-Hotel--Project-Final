/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class OrderAnalysisPieChartController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button loadPieChartButton;
    @FXML
    private TextField newItemName;
    @FXML
    private TextField newItemValue;
    @FXML
    private Button loadPieChartButton1;
     private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
    @FXML
    private MenuBar MenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Alert a = new Alert(Alert.AlertType.ERROR);
        // TODO
    }    

    @FXML
    private void labelMouseEnterOnClick(MouseEvent event) {
        statusLabel.setText("Most Ordered Item from December 2023-March 2024");
    }

    @FXML
    private void loadPieChartButtonOnClick(ActionEvent event) {
         pieChart.getData().clear();
        list.add( new PieChart.Data("Garlic Butter Prawns",50) );
        list.add( new PieChart.Data("Szechuan Beef",40) );
        list.add( new PieChart.Data("Dim Sum Platter",30) );
        list.add( new PieChart.Data("Chicken Wonton",10) );
        list.add( new PieChart.Data("Thai Soup",15) );
        list.add( new PieChart.Data("Chicken Chowmein",17) );
        list.add( new PieChart.Data("Chicken Sizzling",15) );
        
         pieChart.setData(list);
        
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        statusLabel.setText(String.valueOf(data.getPieValue()));
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                }
            );
            
        }
    }

    @FXML
    private void addNewItemToChartButtonOnClick(ActionEvent event) {
         PieChart.Data newItem = 
            new PieChart.Data(
                newItemName.getText(),
                Double.parseDouble(newItemValue.getText())
            );
        
        pieChart.getData().add(newItem );
        
        newItem.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        statusLabel.setText(String.valueOf(newItem.getPieValue()));
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText(newItem.getName() + " is known by "
                                + String.valueOf(newItem.getPieValue()) + " students.");
                        a.showAndWait();
                    }
                }
        );
        
    }

    @FXML
    private void returnToDashBoardButtonOnClick(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
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

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent back=FXMLLoader.load(getClass().getResource("OverallAnalysis.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage)MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
