
package Control;

import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SigninController implements Initializable {

    @FXML
    private TextField emailtextfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private ComboBox<String> signupCombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          signupCombobox.getItems().addAll("Regulator","Administration","Management Officer",
         "Energy Producer and Distributor","Consumer","Financial Analyst",
         "Human Resource","Employee");
         signupCombobox.setValue("Select a user?");
    }    

    @FXML
    private void signupButtonOnClick(ActionEvent event) throws ClassNotFoundException {
        
         String useremail =emailtextfield .getText();
        String password =  passwordtextfield.getText();
        String userType = signupCombobox.getValue();
        
        if (useremail.isEmpty() || password.isEmpty() || userType.isEmpty()) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Sign Up Issue");
        a.setHeaderText("Error");
        a.setContentText("Please enter all of the required fields!");
        a.showAndWait();
        
        
    }
        
         //  email verification code to verify email and write in objectoutputstream
    
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    
     
                         
         if (Pattern.matches(regex, useremail)) {
            
              User.signin(useremail, password, userType, event);
        }
         
         else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Email Address");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid email address!");
            alert.showAndWait();
              
         } 
        
    }

    @FXML
    private void signinOnClick(ActionEvent event)  {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void changebuttonOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Changepassword.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    
}
