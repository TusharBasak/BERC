/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Applicationstatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class AcceptedapplicationController implements Initializable {

    @FXML
    private TableView<Applicationstatus> acceptedApplicanttableview;
    @FXML
    private TableColumn<Applicationstatus,String> accappUsertypecolumn;
    @FXML
    private TableColumn<Applicationstatus,String> accnidnumbercolumn;
    @FXML
    private TableColumn<Applicationstatus,String> addresstableviewcolumn;
    @FXML
    private TableColumn<Applicationstatus,String> emailtableviewcolumn;
private ObservableList<Applicationstatus> applications = FXCollections.observableArrayList();
//private ObservableList<Applicationstatus> applications = FXCollections.observableArrayList();

//     String usertype;
//    String nid;
//    String address;
//    String email;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       try {
            BufferedReader reader = new BufferedReader(new FileReader("Accepted.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // assuming comma-separated values
                if (data.length == 4) {
                    Applicationstatus application = new Applicationstatus(data[0], data[1], data[2], data[3]);
                    applications.add(application);
                }
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(AcceptedapplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        accappUsertypecolumn.setCellValueFactory(new PropertyValueFactory<>("usertype"));
        accnidnumbercolumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        addresstableviewcolumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailtableviewcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        acceptedApplicanttableview.setItems(applications);
       // new File("Application.txt").delete();   
       
          
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
    

