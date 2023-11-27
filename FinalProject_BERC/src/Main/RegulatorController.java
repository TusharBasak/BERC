/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Applicationstatus;
import Model.ManageEnergyPricelinechart;
import Model.Pricetariffhikelinechart;
import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class RegulatorController implements Initializable {

    @FXML
    private MenuBar adminMenuBar;
    @FXML
    private AnchorPane anchorpane;
    boolean notification=false;
    private String usertype;
    private int nid;
    private String address;
    private String email;
   
    // ArrayList<String> Data = new ArrayList<>();
    Applicationstatus app=new Applicationstatus();
    /**
     * Initializes the controller class.
     */
//     String usertype;
//    int nid;
//    String address;
//    String email;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // app.updateinfo(usertype,nid, address, email);
   
          app.notification();

         


    }
       //app.notification(notification);
       

  
//    public void notification(boolean notification){
//         notification=notification;
//         if(notification){
//           Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Notification");
//        alert.setHeaderText("Application Status");
//        alert.setContentText("Please Check a new application arrived");
//        alert.showAndWait();
//       }
//    
//    } 
  
//  if(notification){
//           Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Notification");
//        alert.setHeaderText("Application Status");
//        alert.setContentText("Please Check a new application arrived");
//        alert.showAndWait();
        

   

    @FXML
    private void logOutOnClick(ActionEvent event)  {
       
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

  
    @FXML
    private void updateEnergyTariffOnClick(ActionEvent event) {
         try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("UpdateenergyTariff.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
    }

    @FXML
    private void updateEnergyPriceOnClick(ActionEvent event) {
        
         try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("ManageEnergyTarifflinechart.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
    }

    @FXML
    private void viewUserRatioOnClick(ActionEvent event) {
        
         try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Energy Ratio.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
        
    }

    @FXML
    private void viewApplicationOnClick(ActionEvent event) {
        
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Viewapplication.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
    }

    @FXML
    private void ApplicationratioOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Applicationratio.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) adminMenuBar.getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
              
        }
        
    }
    
}
