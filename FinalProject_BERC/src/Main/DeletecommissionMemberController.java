/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Commission;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class DeletecommissionMemberController implements Initializable {

    @FXML
    private TextField emailtextfield;

    Commission cm=new Commission();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
         String email=emailtextfield.getText();
         
          if(email.isEmpty()){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
         }
          
         String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    
     
                         
         if (Pattern.matches(regex, email) ) {
             
              emailtextfield.clear();
              cm.delete(email);
             
        }
         
         else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
           
              emailtextfield.clear();
            alert.setTitle("Invalid Email Address");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid email address or enter 4 length passord!");
            alert.showAndWait();
              
         } 
        
    }

    @FXML
    private void goBackOnClick(ActionEvent event) {
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
