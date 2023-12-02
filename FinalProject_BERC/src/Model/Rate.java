/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author ISLAM
 */
public class Rate {
    private String rate;

    public Rate() {
    }

    public Rate(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
    
     public  void  updaterate(String rating){
      

         // Convert data to string format
         // Create a FileOutputStream object for the text file
            // Convert data to string format
  String data = rating;

  // Create a FileOutputStream object for the text file
  try (FileOutputStream fileOutputStream = new FileOutputStream("Rating.txt", true)) {
    // Write data to the file
    byte[] dataBytes = data.getBytes();
    fileOutputStream.write(dataBytes);
  } catch (IOException ex) {
    // Handle the exception
  }
}
     
     
 


}