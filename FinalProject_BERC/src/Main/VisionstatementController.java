/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Vision;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class VisionstatementController implements Initializable {

    @FXML
    private TableView<Vision> vissionTableview;
    @FXML
    private TableColumn<Vision,String> vissiontablecolumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
             // Repopulate the table with updated data
    vissiontablecolumn.setCellValueFactory(new PropertyValueFactory<>("vision"));
             // Repopulate the table with updated data
  ArrayList<Vision> vision = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("vision.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            Vision visionstatement = new Vision(line);
            vision.add(visionstatement);
        }
    } catch (FileNotFoundException e) {
       
    } catch (IOException e) {
        
    }

    Vision[] visionArray = new Vision[vision.size()];
    vision.toArray(visionArray);

    vissionTableview.getItems().clear(); // Clear the existing items

    for (Vision visionstatement : visionArray) {
        vissionTableview.getItems().add(visionstatement );
    }
        // TODO
    }    

    @FXML
    private void backtomainScene(ActionEvent event) {
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
