/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RestaurantManager;

import ModelClass.Analysis;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RestaurantPerformanceAnalysisSceneController implements Initializable {

    @FXML
    private TableView<Analysis> PerformanceAndCustomerSatisfactionAnalysisTableView;
    @FXML
    private TableColumn<Analysis,LocalDate> DateTableCo;
    @FXML
    private TableColumn<Analysis,Double> TotalSalesTableCo;
    @FXML
    private TableColumn<Analysis,String> SalesByCatagoryTableCo;
    @FXML
    private TableColumn<Analysis,Double> AverageTransactionValueTableCo;
    @FXML
    private TableColumn<Analysis,Float> CustomerSatisfactionTableCo;
    @FXML
    private MenuBar MenuBar;
     private ObservableList<Analysis> analysisDataList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       DateTableCo.setCellValueFactory(new PropertyValueFactory<Analysis,LocalDate>("date"));
        TotalSalesTableCo.setCellValueFactory(new PropertyValueFactory<Analysis,Double>("totalSales"));
       SalesByCatagoryTableCo.setCellValueFactory(new PropertyValueFactory<Analysis,String>("salesCatagory"));
      AverageTransactionValueTableCo.setCellValueFactory(new PropertyValueFactory<Analysis,Double>("avdTransaction"));
      CustomerSatisfactionTableCo.setCellValueFactory(new PropertyValueFactory<Analysis,Float>("rating"));

        // Load data from file
        loadDataFromFile();
        // TODO
    }    


    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
          Parent back=FXMLLoader.load(getClass().getResource("OverallAnalysis.fxml"));
        Scene newScene=new Scene(back);
        Stage stg1=(Stage) MenuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
    }
     private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Restaurant_Performance_Analysis.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                LocalDate date = LocalDate.parse(parts[0]);
                double totalSales = Double.parseDouble(parts[1]);
                String salesCatagory = parts[2];
                double avgTransaction = Double.parseDouble(parts[3]);
                float rating = Float.parseFloat(parts[4]);

               analysisDataList.add(new Analysis(date, totalSales, salesCatagory, avgTransaction,rating));
            }
            PerformanceAndCustomerSatisfactionAnalysisTableView.setItems(analysisDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void exportToPDF() {
    try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("Restaurant Performance Report.pdf");
        
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
            Chunk titleChunk = new Chunk("Restaurant Performance Report", titleFont);
            titleChunk.setBackground(BaseColor.GREEN);
            titleChunk.setTextRise(5); // Adjust text rise for better appearance
            Paragraph titleParagraph = new Paragraph(titleChunk);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);
            document.add(new Paragraph("\n")); // Add some space before the table

            // Write table data
            PdfPTable table = new PdfPTable(5);
            table.addCell("Date");
            table.addCell("Total Sales(BDT)");
            table.addCell("Sales By Catagory(BDT)");
            table.addCell("Average Transaction Value(BDT)");
            table.addCell("Customer Satisfaction(Rating Out Of 5)");
            
            for (Analysis analysis : analysisDataList) {
                table.addCell(String.valueOf(analysis.getDate()));
                table.addCell(String.valueOf(analysis.getTotalSales()));
                table.addCell(String.valueOf(analysis.getSalesCatagory()));
                table.addCell(String.valueOf(analysis.getAvdTransaction()));
                table.addCell(String.valueOf(analysis.getRating()));
            }
            
            document.add(table);

            document.close();

            // Success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Restaurant Performance report saved successfully as PDF.");
            alert.showAndWait();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
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
    private void returnToDashboardButtonOnClick(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantManagerDeshBoard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene UserViewScene = new Scene(parent);

        currentStage.setScene(UserViewScene);
        currentStage.show(); 
    }

    @FXML
    private void dowmloadReportButtonOnClick(ActionEvent event) {
         exportToPDF();
    }
    
}
