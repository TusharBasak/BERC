/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Commission;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class AddcommissionMemberController implements Initializable {

    @FXML
    private TextField Nametextfield;
    @FXML
    private TextField emailtextfield;
    @FXML
    private ComboBox<String> positionComboBox;
    Commission cm =new Commission();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        positionComboBox.getItems().addAll("Chaiman","Director","Deputy Director",
                "Secretary","Assistant Secretary","Director","Member");
        positionComboBox.setValue("Select a Position");
    }    


    @FXML
    private void submitButtonOnClick(ActionEvent event) {
          String position =positionComboBox.getValue();
          String name =Nametextfield.getText();
          String email= emailtextfield.getText();

    
         if( position.isEmpty() || name.isEmpty() || email.isEmpty()){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
         }
    
//    //  email verification code to verify email and write in objectoutputstream
    
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    
     
                         
         if (Pattern.matches(regex, email) ) {
              positionComboBox.setValue("Select a Position");
              Nametextfield.clear();
              emailtextfield.clear();
               cm.updateinfo(position, name, email);
             
        }
         
         else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
           positionComboBox.setValue("Select a Position");
              Nametextfield.clear();
              emailtextfield.clear();
            alert.setTitle("Invalid Email Address");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid email address or enter 4 length passord!");
            alert.showAndWait();
              
         } 
        
        
    }

    @FXML
    private void backtoDashboardOnClick(ActionEvent event) {
        
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
