/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Control;

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
public class SignupController implements Initializable {

    @FXML
    private TextField emailTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private ComboBox<String> signupCombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          signupCombobox .getItems().addAll("Regulator","Administration","Management Officer",
         "Energy Producer and Distributor","Consumer","Financial Analyst",
         "Human Resource","Employee");
         signupCombobox.setValue("Select a user?");
    }    

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
        
        String useremail = emailTextfield.getText();
    String password = passwordTextfield.getText();
    int passwordlen=password.length();
    String userType = signupCombobox.getValue();

    // Validate the user input
    if (useremail.isEmpty() || password.isEmpty() || userType.isEmpty()) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Sign Up Issue");
        a.setHeaderText("Error");
        a.setContentText("Please enter all of the required fields!");
        a.showAndWait();
        
    }
    
    
//    //  email verification code to verify email and write in objectoutputstream
    
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    
     
                         
         if (Pattern.matches(regex, useremail) && passwordlen>=4 ) {
           emailTextfield.clear();
           passwordTextfield.clear();
           signupCombobox.setValue("Select a user?");
             User.createnewuser(useremail, password, userType);
              
                
             
        }
         
         else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
           emailTextfield.clear();
           passwordTextfield.clear();
           signupCombobox.setValue("Select a user?");
            alert.setTitle("Invalid Email Address");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid email address or enter 4 length passord!");
            alert.showAndWait();
              
         } 
        
        
        
        
        
        
    }

    @FXML
    private void signInButtonOnClick(ActionEvent event) throws IOException {
        
         // Load the FXML file of the main scene
    Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));

    // Get the current stage from the ActionEvent
    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Set the root of the current stage's scene to the main scene's root
    currentStage.setScene(new Scene(root));
    }
    
}
