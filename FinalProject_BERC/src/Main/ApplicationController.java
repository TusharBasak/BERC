/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Applicationstatus;
import Model.Useratio;
import Model.Pricetariffhikelinechart;
import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class ApplicationController implements Initializable {

    @FXML
    private ComboBox<String> searchComboBox;
    @FXML
    private TextField Nidtextfield;
    @FXML
    private TextArea addressTextArea;
    Applicationstatus app=new Applicationstatus();
    RegulatorController notification = new RegulatorController();
    @FXML
    private TextField emailTextField;
    boolean notification1,notification2;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchComboBox.getItems().addAll("Single Stove","Double Stove","Commercial",
               "Power Plant","Large Industry","SME Industry","Fertiliser");
       searchComboBox.setValue("Select Types of User");
     
    }    

    @FXML
    private void submitButtonONClick(ActionEvent event) {
        String usertype=searchComboBox.getValue();
       // int nid  = Integer.parseInt(Nidtextfield.getText());
        String len=Nidtextfield.getText();
       
        String  address=addressTextArea.getText();
        String email=emailTextField.getText();
         String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
         if (Pattern.matches(regex, email)&&(len.length()==10)) {
            app.updateinfo(usertype, len, address, email);
              
   
     //new File("Application.txt").delete();
              
        }
                
                
         else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Email Address or NID");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid email addressor NID!");
            alert.showAndWait();
              
         } 
         
         searchComboBox.setValue("Select Types of User");
         Nidtextfield.clear();
         addressTextArea.clear();
         emailTextField.clear();
       
//        Alert a = new Alert(Alert.AlertType.WARNING);
        
     
    }

    @FXML
    private void backtodashboardOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("/Control/Mainscene.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
      
         
    
    } 
   
    

