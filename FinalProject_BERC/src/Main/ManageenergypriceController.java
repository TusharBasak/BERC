/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.ManageEnergyPrice;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class ManageenergypriceController implements Initializable {

    @FXML
    private TextField existingpriceTextField;
    @FXML
    private TextField NewPriceTextField;
    @FXML
    private ComboBox<String> Comboboxusertype;
    ManageEnergyPrice energyprice = new ManageEnergyPrice();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Comboboxusertype.getItems().addAll("Single Stove","Double Stove","Commercial",
               "Power Plant","Large Industry","SME Industry","Fertiliser");
       Comboboxusertype.setValue("Select Types of User");
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
           String usertype=Comboboxusertype.getValue();
          Double existingprice =Double.parseDouble(existingpriceTextField.getText());
          Double NewPrice =Double.parseDouble(NewPriceTextField.getText());
          
          energyprice.updateinfo(usertype, existingprice, NewPrice);
          Comboboxusertype.setValue("Select Types of User");
          existingpriceTextField.clear();
          NewPriceTextField.clear();
         
    } 
        
    

    @FXML
    private void backtoDashBoardOnClick(ActionEvent event) {
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
