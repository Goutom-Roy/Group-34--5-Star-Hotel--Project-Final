/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;

import ModelClass.Budget;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class IT_ManagerBudgetDashBoardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private TableView<Budget> budgettableView;
    @FXML
    private TableColumn<Budget, Double> totalBudgetColumn;
    @FXML
    private TableColumn<Budget, Double> expensesColumn;
    @FXML
    private TableColumn<Budget, Integer> yearColumn;
    
     private ObservableList<Budget> itbudgetData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        totalBudgetColumn.setCellValueFactory(new PropertyValueFactory<Budget, Double>("totalBudget"));
        expensesColumn.setCellValueFactory(new PropertyValueFactory<Budget, Double>("expenses"));

        yearColumn.setCellValueFactory(new PropertyValueFactory<Budget, Integer>("year"));
        
        itbudgetData.add(new Budget(30221.12, 21333.21, 2018));
        itbudgetData.add(new Budget(40221.12, 30333.21, 2019));
        itbudgetData.add(new Budget(50221.12, 35333.21, 2020));
        itbudgetData.add(new Budget(70221.12, 50333.21, 2021));
        itbudgetData.add(new Budget(120221.12, 80333.21, 2022));
        itbudgetData.add(new Budget(130221.12, 100333.21, 2023));
        budgettableView.setItems(itbudgetData);
        
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
    private void downloadbudgetButtonOnActio(ActionEvent event) {
         exportToPDF1();
    }
    
    private void exportToPDF1() {
    try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("IT_Budget_Report.pdf");
        
        // Set extension filter to ensure only PDF files are selected
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

                     // Write header
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 24, Font.BOLD);
            Chunk titleChunk = new Chunk("IT_Budget Report", titleFont);
            titleChunk.setBackground(BaseColor.GREEN);
            titleChunk.setTextRise(5); // Adjust text rise for better appearance
            Paragraph titleParagraph = new Paragraph(titleChunk);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);
            document.add(new Paragraph("\n")); // Add some space before the table

            // Write table data
            PdfPTable table = new PdfPTable(3);
            table.addCell("Total Budget(TK)");
            table.addCell("Expenses(TK)");
            
            table.addCell("Year");
            
            for (Budget budget : itbudgetData) {
                table.addCell(String.valueOf(budget.getTotalBudget()));
                table.addCell(String.valueOf(budget.getExpenses()));
              
                table.addCell(String.valueOf(budget.getYear()));
            }
            
            document.add(table);

            document.close();

            // Success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("IT_Budget report saved successfully as PDF.");
            alert.showAndWait();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
