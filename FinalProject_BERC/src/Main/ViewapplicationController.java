/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Authenticator;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class ViewapplicationController implements Initializable {

    @FXML
    private TextArea appinfotextarea;
    ArrayList<String> lines = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void acceptButtonOnClick(ActionEvent event) {
        
    try {
        String accepted=appinfotextarea.getText();
        
        //new File("Accepted.txt").delete();
        try (FileWriter writer = new FileWriter("Accepted.txt",true)) {
            writer.append(accepted + "\n");
            
            
        } 
        
    }catch (IOException e) {
            // Handle IOException
        }
                 
  appinfotextarea.clear();
    }

    @FXML
    private void rejectButtonOnClick(ActionEvent event) {
        appinfotextarea.clear();
    }

    @FXML
    private void seeApplicationButtonOnClick(ActionEvent event) {
       
   try (BufferedReader reader = new BufferedReader(new FileReader("Destination.txt"))) {
   
      String line;
    // Clear the textarea once before processing the file
    appinfotextarea.clear();

    while ((line = reader.readLine()) != null) {
        if (!lines.contains(line)) {
            // Add the unique line to the list and append it to the textarea
            
            lines.add(line);
            appinfotextarea.appendText(line + "\n"); // Add newline for proper formatting
            break;
        }
    }
   // appinfotextarea.clear();
} catch (FileNotFoundException ex) {
    
} catch (IOException ex) {
   
}
     
  
             
    new File("Destination.txt").delete();      
    
    
}

    @FXML
    private void backtoDashboardbuttonOnClick(ActionEvent event) {
        
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