/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import Model.Pricehikelinechart;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class UpdateenergytarifflinechartController implements Initializable {

    @FXML
    private LineChart<String,Number> linechart;
    @FXML
    private Label labellinechart;
    @FXML
    private ComboBox<String> searchComboBox;
     Pricehikelinechart phlc=new  Pricehikelinechart();
 ArrayList<Pricehikelinechart> Data = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         searchComboBox.getItems().addAll("Single Stove","Double Stove","Commercial",
               "Power Plant","Large Industry","SME Industry","Fertiliser");
       searchComboBox.setValue("Select Types of User");
    }    

   

    @FXML
    private void submitbuttonOnClick(ActionEvent event) {
        String search =searchComboBox.getValue();
        Double existingPrice=0.0,newPrice=0.0;
        String userType;
      Data= phlc.loadDataFromFile();
    for (Pricehikelinechart data : Data) {
           userType = data.getUsertype();
           if(userType.equals(search)){
             existingPrice = data.getExistingprice();
             newPrice = data.getNewprice();
             break;
           }
        
    }
    
    linechart.getData().clear();
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.getData().add(new XYChart.Data<String,Number>("Existing Price",existingPrice));
        
        series1.setName("Existing Price");
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.getData().add(new XYChart.Data<String,Number>("New Price",newPrice));
      
        series2.setName("New Price");
         linechart.getData().addAll(series1,series2);
      
          for(XYChart.Data<String,Number> data: series1.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    labellinechart.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
          
          for(XYChart.Data<String,Number> data: series2.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                   labellinechart.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
    } 
    }
    
     @FXML
    private void backtodashbuttonOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Administration.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
    
}
