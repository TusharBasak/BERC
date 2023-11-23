/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class AdministrationController implements Initializable {

    @FXML
    private MenuBar adminMenuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void logoutOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("/Control/Mainscene.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(AdministrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

  
    
    
    
    
}

    
    

    @FXML
    private void visionOnClick(ActionEvent event) {
         try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Updatevisionstatement.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
    }

    @FXML
    private void missionOnClick(ActionEvent event) {
         try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("UpdatemissionStatement.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
    }

    @FXML
    private void viewEnergytariffOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Updateenergytarifflinechart.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
}
