/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mortar max
 */
public class ConsumerEnquiriesFXMLController implements Initializable {

    @FXML
    private TextField messageTextField;
    @FXML
    private RadioButton complaintRadioButton;
    @FXML
    private RadioButton feedbackRadioButton;
    @FXML
    private RadioButton enquiryRadioButton;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackOnClick(MouseEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
    }
    
}
