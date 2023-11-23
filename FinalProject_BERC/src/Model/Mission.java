/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ISLAM
 */
public class Mission {
    String mission;

    public Mission() {
    }

    public Mission(String mission) {
        this.mission = mission;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
    
    
     public  void  updatemissionfile(String mission){
         

    
         String[] missionArray = mission.split("\n"); 
   
     
    // Add the vision text to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mission.txt", true))) {
        for (String visionLine : missionArray) {
            writer.write(visionLine + "\n");
        }
    } catch (IOException e) {
        
    }


  

    
    }
}
