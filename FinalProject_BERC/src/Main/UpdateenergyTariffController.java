/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Pricehikelinechart;
import Model.UpdateTariff;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class UpdateenergyTariffController implements Initializable {

    @FXML
    private TextField ExistingpriceTextfield;
    @FXML
    private TextField NewPriceTextfield;
 
    @FXML
    private ComboBox<String> userCombobox;
    UpdateTariff uptariff = new UpdateTariff();
    Pricehikelinechart phlc=new  Pricehikelinechart();
    private LineChart<String,Number> linechart;
    private ComboBox<String> searchcombobox;
     ArrayList<Pricehikelinechart> Data = new ArrayList<>();
     
    @FXML
    private AnchorPane anchorpane;
    private Label linechartLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       userCombobox.getItems().addAll("Single Stove","Double Stove","Commercial",
               "Power Plant","Large Industry","SME Industry","Fertiliser");
       userCombobox.setValue("Select Types of User");
       
       
    }    

    @FXML
    private void pricehikebuttonOnClick(ActionEvent event) {
          String usertype=userCombobox.getValue();
          Double existingprice =Double.parseDouble(ExistingpriceTextfield.getText());
          Double NewPrice =Double.parseDouble(NewPriceTextfield.getText());
          uptariff.updateinfo(usertype, existingprice, NewPrice);
          userCombobox.setValue("Select Types of User");
          ExistingpriceTextfield.clear();
          NewPriceTextfield.clear();
        //open this textfile data.txt and 
    }

    
        
     



    
    
        
    

    @FXML
    private void backtodashboardbuttonOnClick(ActionEvent event) {
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
