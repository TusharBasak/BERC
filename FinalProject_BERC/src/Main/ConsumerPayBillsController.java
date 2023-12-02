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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mortar max
 */
public class ConsumerPayBillsController implements Initializable {

    @FXML
    private Label monthLabel;
    @FXML
    private Label dueAmountLabel;
    @FXML
    private TextField monthInputTextfield;
    @FXML
    private TextField amountEnterTextfield;
    @FXML
    private TextField cardNoTextfield;
    @FXML
    private Button makePaymentButton;
    
    
    @FXML
    private DatePicker dop;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
    }    

    @FXML
    private void DatePickOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void enterBillOnClick(MouseEvent event) throws IOException {
        
        
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerBillsFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
        
              
              
                
        
    }

    @FXML
    private void backbuttonOnclick(ActionEvent event) throws IOException {
        Parent sceneA = FXMLLoader.load(getClass().getResource("ConsumerFXML.fxml"));
        Scene sceneB = new Scene(sceneA);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(sceneB);
        stg.show();
        
    }
    
}
