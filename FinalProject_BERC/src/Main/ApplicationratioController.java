/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.ApplicationRatio;
import Model.Useratio;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class ApplicationratioController implements Initializable {

    @FXML
    private PieChart userPieChart;
    @FXML
    private Label lablepiechart;

    ApplicationRatio phlc=new  ApplicationRatio();
 ArrayList<String> Data = new ArrayList<>();
 ArrayList<ApplicationRatio> userTypeList = new ArrayList<>();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void showPieChartOnClick(ActionEvent event) {
        
         Data = phlc.loadDataFromFile();
         for(String d:Data){
           if(d.equals("Single Stove")){
                cnt1+=1;
           }
           else if(d.equals("Double Stove")){
               cnt2+=1;
           }
           else if(d.equals("Commercial")){
               cnt3+=1;
           }
           else if(d.equals("Power Plant")){
               cnt4+=1;
           }
          
           else if(d.equals("Large Industry")){
               cnt5+=1;
           }
           else if(d.equals("SME Industry")){
               cnt6+=1;
           }
           else if(d.equals("Fertiliser")){
               cnt7+=1;
           }
//          searchComboBox.getItems().addAll("Single Stove","Double Stove","Commercial",
//               "Power Plant","Large Industry","SME Industry","Fertiliser");
        
    }
         
      userPieChart.getData().clear();
        list.add( new PieChart.Data("Single Stove",cnt1) );
        list.add( new PieChart.Data("Double Stove",cnt2) );
        list.add( new PieChart.Data("Commercial",cnt3) );
        list.add( new PieChart.Data("Power Plant",cnt4) );
        list.add( new PieChart.Data("Large Industry",cnt5) );
        list.add( new PieChart.Data("SME Industry",cnt6) );
        list.add( new PieChart.Data("Fertiliser",cnt7) );
      
        
        
        userPieChart.setData(list);
        
        for(PieChart.Data data: userPieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                 lablepiechart.setText(String.valueOf(data.getPieValue()));
             
                }
            }
            );
    
}
       
        
    
    cnt1=0;cnt2=0; cnt3=0;cnt4=0; cnt5=0;cnt6=0; cnt7=0;   
       
         
         
    }
    @FXML
    private void DashboardOnClick(ActionEvent event) {
        
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
