/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Scarecrow
 */
public class ManagementOfficerController implements Initializable {

    @FXML
    private BorderPane managementOfficerBorderpane;
    SceneSwitching newSceneOpener = new SceneSwitching();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void maintenanceMenuItemOnClick(ActionEvent event) {
                try {
            Parent root = FXMLLoader.load(getClass().getResource("maintenanceManagementOfficerScene.fxml"));
            Scene newScene = new Scene(root);
            Stage newStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            newStage.setScene(newScene);
            newStage.show();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
    }

    @FXML
    private void gridManagementMenuItemOnClick(ActionEvent event) {
                 try {
            Parent root = FXMLLoader.load(getClass().getResource("/Main/gridManagementManagementOfficerScene.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
    

    @FXML
    private void policyManagementMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("PolicyManagementOfficerScene.fxml"));
    }

    @FXML
    private void substationManagementMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void RenewableEnergyMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void consumerAdvocacyMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void tariffCalculationMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void billCalculationMenuItemOnClick(ActionEvent event) {
    }
    
}
