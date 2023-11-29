/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Rate;
import Model.Ratingpiechart;
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
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class RatingPieChartController implements Initializable {

    @FXML
    private Label labelRating;
     Ratingpiechart phlc=new  Ratingpiechart();
     
 ArrayList<String> rating = new ArrayList<>();

  private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
 int cnt1=0;
 int cnt2=0;
 int cnt3=0;                                                                                                    
    
 int cnt4=0;
 int cnt5=0;
    @FXML
    private PieChart userPieChart;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
         rating= phlc.loadDataFromFile();
         for(String d:rating){
           if(d.equals("1")){
                cnt1+=1;
           }
           else if(d.equals("2")){
               cnt2+=1;
           }
           else if(d.equals("3")){
               cnt3+=1;
           }
           else if(d.equals("4")){
               cnt4+=1;
           }
          
           else if(d.equals("5")){
               cnt5+=1;
           }
          

        
    }
         
      userPieChart.getData().clear();
        list.add( new PieChart.Data("1",cnt1) );
        list.add( new PieChart.Data("2",cnt2) );
        list.add( new PieChart.Data("3",cnt3) );
        list.add( new PieChart.Data("4",cnt4) );
        list.add( new PieChart.Data("5",cnt5) );
     
      
        
        
        userPieChart.setData(list);
        
        for(PieChart.Data data: userPieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                 labelRating.setText(String.valueOf(data.getPieValue()));
             
                }
            }
            );
    
}
       
        
    
    cnt1=0;cnt2=0; cnt3=0;cnt4=0; cnt5=0;
    }

    @FXML
    private void backtodashboardOnClick(ActionEvent event) {
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
