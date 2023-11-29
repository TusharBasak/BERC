/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISLAM
 */
public class Ratingpiechart {
    private String rating;

    public Ratingpiechart() {
    }

    public Ratingpiechart(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
     public ArrayList<String> loadDataFromFile() {
 
        ArrayList<String> destinationData = new ArrayList<>();
         FileInputStream fileInputStream = null;
        try {
            //open Rating.txt file and append single charecter one by one in arraylist
            
            
            // Open the file for reading
            fileInputStream = new FileInputStream("Rating.txt");
            // Initialize variables for reading and storing file contents
            int ch; // Current character being read
            // Read the file character by character
            while ((ch = fileInputStream.read()) != -1) {
                // Convert the current character to a String and add it to the ArrayList
                destinationData.add(String.valueOf((char) ch));
            }   // Close the file
            fileInputStream.close();
          //  return destinationData;
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
          
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                
            }
        }
     
      return destinationData;
 
          

    
}
}

