/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it_manager;


import ModelClass.User;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
public class RegistrationSceneController implements Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User,String> emailColumn;
    @FXML
    private TableColumn<User,String> roleColumn;
    @FXML
    private TableColumn<User,LocalDate> datrofBirthColumn;
    @FXML
    private TableColumn<User,String> genderColumn;
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
         datrofBirthColumn.setCellValueFactory(new PropertyValueFactory<User,LocalDate>("dateofjoin"));
         genderColumn.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
         roleColumn.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
         
    }    


    private void backOnActionButton(ActionEvent event) throws IOException {
        Parent singup=FXMLLoader.load(getClass().getResource("IT_ManagerDashboardScene.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }

    @FXML
    private void userOnActionButton(ActionEvent event) {
        try {
            
   
        FileReader f= new FileReader("LoginUserDetails.txt");
        BufferedReader reader = new BufferedReader(f);

        String line;
            while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] fields = line.split(";");
            String email = fields[0];
            String role = fields[2];
            String gender = fields[3];
            LocalDate dateOfjoin = LocalDate.parse(fields[4]);
            
            User user = new User(email, dateOfjoin, gender, role);
            tableView.getItems().add(user);
        }

            } catch (Exception e) {
        }
    }

    @FXML
    private void downloadReportOnActionButton(ActionEvent event) {
                        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("User_Report.pdf");
           
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            Stage stage = (Stage) borderPane.getScene().getWindow();
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                createPDFReport(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void passwordhistoryOnActionButton(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("IT_ManagerUserPassMonitor.fxml"));
        Scene newScene = new Scene(back);
        Stage stg1 = (Stage) menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
        
    }

    @FXML
    private void back1OnActionButton(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("IT_ManagerDashboardScene.fxml"));
        Scene newScene = new Scene(back);
        Stage stg1 = (Stage) menuBar.getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
      private void createPDFReport(File file) throws IOException, DocumentException {
          
        try (FileOutputStream fos = new FileOutputStream(file)) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, fos);
            document.open();

            // Write header
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 24, Font.BOLD);
            Chunk titleChunk = new Chunk("User Registration Report", titleFont);
            Paragraph titleParagraph = new Paragraph(titleChunk);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);
            document.add(new Paragraph("\n")); // Add some space before the table

            // Write table data
            PdfPTable table = new PdfPTable(4);
            table.addCell("Email");
            table.addCell("Role");
            table.addCell("Gender");
            table.addCell("Date of Birth");

            for (User user : tableView.getItems()) {
                table.addCell(user.getEmail());
                table.addCell(user.getRole());
                table.addCell(user.getGender());
               table.addCell(user.getDateofjoin().toString());

            }

            document.add(table);
            document.close();

            // Success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("User registration report saved successfully as PDF.");
            alert.showAndWait();
        }
    }
    
}
