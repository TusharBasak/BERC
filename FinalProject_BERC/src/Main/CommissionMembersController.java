/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Commission;
import Model.Vision;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
public class CommissionMembersController implements Initializable {

    @FXML
    private TableView<Commission> tableviewcommissionmembers;
    @FXML
    private TableColumn<Commission,String> positiontablecolumn;
    @FXML
    private TableColumn<Commission,String> nameTableColumn;
    @FXML
    private TableColumn<Commission,String> emailTableColumn;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // Repopulate the table with updated data
     positiontablecolumn.setCellValueFactory(new PropertyValueFactory<>("position"));
       nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
       emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
             // Repopulate the table with updated data
  ArrayList<Commission> vision = new ArrayList<>();
 // CommissionMembers.txt textfile has position,name,email please stored it in array and populated in tableview
    // Create an ArrayList to store the Commission objects
ArrayList<Commission> commissionList = new ArrayList<>();

// Read data from the file and store it in the ArrayList
try (BufferedReader reader = new BufferedReader(new FileReader("CommissionMembers.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String position = data[0];
        String name = data[1];
        String email = data[2];

        Commission commission = new Commission(position, name, email);
        commissionList.add(commission);
    }
} catch (IOException e) {
    
}
// Set the data of the table to the ArrayList
         tableviewcommissionmembers.setItems(FXCollections.observableArrayList(commissionList));
    }    

    @FXML
    private void seeDetailsOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Detailedpersonview.fxml"));
        Parent personViewParent;
       
            personViewParent = loader.load();
        

        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene personViewScene = new Scene(personViewParent);
        
        //access the controller
        DetailedpersonviewController controller = loader.getController();
        //PersonViewSceneController controller = new PersonViewSceneController();
        controller.initData(tableviewcommissionmembers.getSelectionModel().getSelectedItem());
                
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void backtomainSceneOnClick(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/Control/Mainscene.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
    
}
