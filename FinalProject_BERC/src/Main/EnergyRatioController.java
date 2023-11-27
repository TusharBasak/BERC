/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Useratio;
import Model.ManageEnergyPricelinechart;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class EnergyRatioController implements Initializable {

    
    @FXML
    private PieChart piechart;
 Useratio phlc=new  Useratio();
 ArrayList<String> Data = new ArrayList<>();
 ArrayList<Useratio> userTypeList = new ArrayList<>();
  private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
 int cnt1=0;
 int cnt2=0;
 int cnt3=0;
 int cnt4=0;
 int cnt5=0;
 int cnt6=0;
 int cnt7=0;
 int cnt8=0;
    @FXML
    private Label statuslabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
      
       
        
    
      // ArrayList<String> userTypeList = loadDataFromFile();
  
      Data = phlc.loadDataFromFile();
      

       
        for(String d:Data){
           if(d.equals("Regulator")){
                cnt1+=1;
           }
           else if(d.equals("Administration")){
               cnt2+=1;
           }
           else if(d.equals("Management Officer")){
               cnt3+=1;
           }
           else if(d.equals("Energy Producer and Distributor")){
               cnt4+=1;
           }
           else if(d.equals("Consumer")){
               cnt5+=1;
           }
           else if(d.equals("Financial Analyst")){
               cnt6+=1;
           }
           else if(d.equals("Human Resource")){
               cnt7+=1;
           }
           else if(d.equals("Employee")){
               cnt8+=1;
           }
        
        

        
         piechart.getData().clear();
        list.add( new PieChart.Data("Regulator",cnt1) );
        list.add( new PieChart.Data("Administration",cnt2) );
        list.add( new PieChart.Data("Management Officer",cnt3) );
        list.add( new PieChart.Data("Energy Producer and Distributor",cnt4) );
        list.add( new PieChart.Data("Consumer",cnt5) );
        list.add( new PieChart.Data("Financial Analyst",cnt6) );
        list.add( new PieChart.Data("Human Resource",cnt7) );
        list.add( new PieChart.Data("Employee",cnt8) );
        
        
        piechart.setData(list);
        
        for(PieChart.Data data: piechart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statuslabel.setText(String.valueOf(data.getPieValue()));
             
                }
            }
            );
    
}
       
        }
    
    cnt1=0;cnt2=0; cnt3=0;cnt4=0; cnt5=0;cnt6=0; cnt7=0;cnt8=0;
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
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

        
    

