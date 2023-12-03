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
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("maintenanceManagementOfficerScene.fxml"));
    }

    @FXML
    private void gridManagementMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("gridManagementManagementOfficerScene.fxml"));
    }
    

    @FXML
    private void policyManagementMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("PolicyManagementOfficerScene.fxml"));
    }

    @FXML
    private void substationManagementMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("SubstationManagementManagementOfficerScene.fxml"));
    }

    @FXML
    private void RenewableEnergyMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("RenewableManagementManagementOfficerScene.fxml"));
    }

    @FXML
    private void consumerAdvocacyMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("ConsumerAdvocacyManagementOfficerScene.fxml"));
    }

    @FXML
    private void tariffCalculationMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("TariffCalculationManagementOfficerSceene.fxml"));
    }

    @FXML
    private void billCalculationMenuItemOnClick(ActionEvent event) {
        managementOfficerBorderpane.setCenter(newSceneOpener.getSceneRoot("BillCalculationManagementOfficerScene.fxml"));
    }
    
}
