
package Main;

import Model.Commission;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class DetailedpersonviewController implements Initializable {

    @FXML
    private Label positionlabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    Commission selectedPerson =new Commission();
     //private Person selectedPerson;
    
   
    public void initData(Commission p){
        selectedPerson = p;
        positionlabel.setText(selectedPerson.getPosition());
         nameLabel.setText(selectedPerson.getName());
       emailLabel.setText(selectedPerson.getEmail());
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gobackOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CommissionMembers.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
    
}
