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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mortar max
 */
public class FinancialDashboardFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOutOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("/Control/Mainscene.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
        
    }

    @FXML
    private void sendReportOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("SendReportFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void addConsumerOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("FinancialLicenseFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void FinancialDataOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("FinancialDataFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void eLicenseOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("FinancialApproveElicenseFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void tariffOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("FinancialTariffFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void distributorOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("FinancialDistributorFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void reportOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("SendReportFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void goalsOnClick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("FinancialSetGoalsFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }
    
}
