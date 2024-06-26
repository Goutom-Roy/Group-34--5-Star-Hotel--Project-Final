/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class CEODashboardSceneController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("2024",60));
        series.getData().add(new XYChart.Data<String,Number>("2023",50));
        series.getData().add(new XYChart.Data<String,Number>("2022",35));
        series.getData().add(new XYChart.Data<String,Number>("2021",24));
        series.getData().add(new XYChart.Data<String,Number>("2020",23));
        series.getData().add(new XYChart.Data<String,Number>("2019",20));
        series.setName("Market Share");
        barChart.getData().add(series);
        
    }    


    @FXML
    private void productAndServiceButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_ServicesDashBoard.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void guestSatisfactionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_feedback.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void mettingButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_Meeting.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void budgetButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_BudgetDashBardScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void namageEmployeeButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("HotelEmployee.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void visionMissionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_VisionMissionDashBordScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
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
    private void FinanceButton(ActionEvent event) throws IOException {
         Parent singup=FXMLLoader.load(getClass().getResource("CEO_FinanceDashBoardScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
    }

    @FXML
    private void brandAwarenessOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("CEO_MarketShareandBrandAwareness.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
