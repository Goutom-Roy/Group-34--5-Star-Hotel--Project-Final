package ceo;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CEO_BudgetDashBardSceneController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TableView<Budget> budgettableView;
    @FXML
    private TableColumn<Budget, Double> totalBudgetColumn;
    @FXML
    private TableColumn<Budget, Double> expensesColumn;
    @FXML
    private TableColumn<Budget, Double> revenuecolumn;
    @FXML
    private TableColumn<Budget, Integer> yearColumn;

    private ObservableList<Budget> budgetData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("totalBudget"));
        expensesColumn.setCellValueFactory(new PropertyValueFactory<>("expenses"));
        revenuecolumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        // Load data from file
        loadDataFromFile();
    }

    @FXML
    private void backOnactionButton(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("CEODashboardScene.fxml"));
        Scene newScene = new Scene(back);
        Stage stg1 = (Stage) menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }


    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Budgetinfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                double totalBudget = Double.parseDouble(parts[0]);
                double expenses = Double.parseDouble(parts[1]);
                double revenue = Double.parseDouble(parts[2]);
                int year = Integer.parseInt(parts[3]);

                budgetData.add(new Budget(totalBudget, expenses, revenue, year));
            }
            budgettableView.setItems(budgetData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private void exportToPDF() {
    try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("Budget_Report.pdf");
        
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
            Chunk titleChunk = new Chunk("Budget Report", titleFont);
            titleChunk.setBackground(BaseColor.GREEN);
            titleChunk.setTextRise(5); // Adjust text rise for better appearance
            Paragraph titleParagraph = new Paragraph(titleChunk);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);
            document.add(new Paragraph("\n")); // Add some space before the table

            // Write table data
            PdfPTable table = new PdfPTable(4);
            table.addCell("Total Budget");
            table.addCell("Expenses");
            table.addCell("Revenue");
            table.addCell("Year");
            
            for (Budget budget : budgetData) {
                table.addCell(String.valueOf(budget.getTotalBudget()));
                table.addCell(String.valueOf(budget.getExpenses()));
                table.addCell(String.valueOf(budget.getRevenue()));
                table.addCell(String.valueOf(budget.getYear()));
            }
            
            document.add(table);

            document.close();

            // Success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Budget report saved successfully as PDF.");
            alert.showAndWait();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML
private void downloadbudgetButtonOnActio(ActionEvent event) {
     exportToPDF();
}

}
