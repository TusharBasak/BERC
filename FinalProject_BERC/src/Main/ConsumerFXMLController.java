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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author mortar max
 */
public class ConsumerFXMLController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private Button EnergyConservationButton;
    @FXML
    private TextArea notificationTextArea;
    @FXML
    private Button tariffupdatesButton;
    @FXML
    private Button payBills;
    @FXML
    private Button billsAndConsumpButton;
    @FXML
    private Button inboxButton;
    @FXML
    private Button distriutorsButton;
    @FXML
    private Button safetyRulesButton;
    @FXML
    private Button enquiriesButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logoutOnClick(MouseEvent event) {
    }

    @FXML
    private void energyConservationOnClick(MouseEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerEnergyFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
        
    }   

    @FXML
    private void tariffOnClick(MouseEvent event) throws IOException {
        Parent sceneC = FXMLLoader.load(getClass().getResource("ConsumerTariffFXML.fxml"));
        Scene sceneD = new Scene(sceneC);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneD);
        stg.show();
        
    }

    @FXML
    private void payBillOnMouseClick(MouseEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerPayBills.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
        
        
        
        
        
    }

    @FXML
    private void billsOnMouseClick(MouseEvent event)  {
        
    }

    @FXML
    private void inboxOnMouseClick(MouseEvent event) throws IOException {
         Parent sceneA = FXMLLoader.load(getClass().getResource("inboxFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void distributorsOnMouseClick(MouseEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerDistDetailsFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void safetyOnMouseClick(MouseEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerSafetyFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void enquiryOnMouseClick(MouseEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerEnquiriesFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }

    @FXML
    private void billsdetailsonclick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("BillsFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }
    
}
