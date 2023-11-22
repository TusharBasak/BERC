/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Control;

import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class ChangepasswordController implements Initializable {

    @FXML
    private TextField emailTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private ComboBox<String> userCombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          userCombobox .getItems().addAll("Regulator","Administration","Management Officer",
         "Energy Producer and Distributor","Consumer","Financial Analyst",
         "Human Resource","Employee");
         userCombobox.setValue("Select a user?");
    }    

    @FXML
    private void changepasswordOnClick(ActionEvent event) {
            User.changepassword(emailTextfield.getText(),passwordTextfield.getText(),userCombobox.getValue());
             emailTextfield.clear();
           passwordTextfield.clear();
           userCombobox.setValue("Select a user?");
        
    }

    @FXML
    private void backtoMainScene(ActionEvent event) {
        
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(ChangepasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
