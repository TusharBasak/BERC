/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Mission;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class UpdatemissionStatementController implements Initializable {

    @FXML
    private TextArea missiontextarea;
     Mission mission = new Mission();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void submitbuttonOnClick(ActionEvent event) {
       
        String mision = missiontextarea.getText();
        mission.updatemissionfile(mision);
   

    // Clear the text area
       missiontextarea.clear();
    }

    @FXML
    private void backtodashboardOnClick(ActionEvent event) {
         try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Administration.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
    
}
