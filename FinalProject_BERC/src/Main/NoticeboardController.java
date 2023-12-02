/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Notice;
import Model.URLTableCell;
import java.awt.Desktop;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class NoticeboardController implements Initializable {

  
    @FXML
    private TextArea noticeTextArea;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       noticeTextArea.setEditable(false);

ObservableList<URL> notices = FXCollections.observableArrayList();

try (BufferedReader reader = new BufferedReader(new FileReader("pdf_addresses.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        File pdfFile = new File(line);
        URL pdfURL = pdfFile.toURI().toURL();
        notices.add(pdfURL);
    }
} catch (IOException e) {
    // Handle any exceptions that occur while reading the file
}

// Update UI on the JavaFX Application Thread
    Platform.runLater(() -> {
        for (URL url1 : notices) {
            Hyperlink hyperlink = new Hyperlink(url1.toString());
            hyperlink.setOnAction(event -> {
                try {
                    Desktop.getDesktop().browse(url1.toURI()); // Open the URL in the default web browser
                } catch (IOException | URISyntaxException e) {
                  
                }
            });

            noticeTextArea.appendText(hyperlink.getText() + "\n"); // Append the hyperlink text to the text area
        }
    });

    
   
   
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Control/Mainscene.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }

    
    }   
                    
    

   

     

   



    

