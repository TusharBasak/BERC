/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ISLAM
 */
public class ApplicationRatio {
     String usertype;

    public ApplicationRatio() {
    }

    public ApplicationRatio(String usertype) {
        this.usertype = usertype;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
     
    public ArrayList<String> loadDataFromFile() {
    ArrayList<String> destinationData = new ArrayList<>();
  

    try (BufferedReader reader = new BufferedReader(new FileReader("Destination2.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
         String[] data = line.split(",");
        String userType = data[0]; // Extract the usertype from the line
            destinationData.add(userType);
        }
    } catch (IOException e) {
        System.err.println("Error: Could not read file:");
        
    }
    //new File("Destination.txt").delete();
    return destinationData;
}
}
