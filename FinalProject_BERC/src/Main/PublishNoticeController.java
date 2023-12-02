/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Notice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class PublishNoticeController implements Initializable {

     Notice notice =new Notice();
     File pdfFile;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void choosepdfOnClick(ActionEvent event) {
        FileChooser fc = new FileChooser();
    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

    File selectedFile = fc.showOpenDialog(null);

    if (selectedFile != null) {
        // Save the selected PDF file to a variable
        pdfFile = selectedFile;

     
    }
    }

    @FXML
    private void publishOnClick(ActionEvent event) {
     
       notice.noticeinfo(pdfFile);
       
       
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Regulator.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
        
    }
    
}
