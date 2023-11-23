/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author ISLAM
 */
public class Vision {
    private String vision;
   

    public Vision() {
    }

    public Vision(String vision) {
        this.vision = vision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }
    

   
 public  void  updatevisionfile(String vision){
         

    
         String[] visionArray = vision.split("\n"); 
   
     
    // Add the vision text to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("vision.txt", true))) {
        for (String visionLine : visionArray) {
            writer.write(visionLine + "\n");
        }
    } catch (IOException e) {
        
    }


  

    
    }
    
//     public  void  updatemissionfile(String missionstatement){
//         
//
//    
//         String[] missionArray = missionstatement.split("\n"); 
//   
//     
//    // Add the vision text to the file
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mission.txt", true))) {
//        for (String missionLine : missionArray) {
//            writer.write(missionLine +"\n");
//        }
//    } catch (IOException e) {
//        
//    }
//
//
//  
//
//    
//    }
    
    
}
