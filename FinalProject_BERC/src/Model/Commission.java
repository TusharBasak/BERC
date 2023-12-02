/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author ISLAM
 */
public class Commission {
    private String position,Name,email;

    public Commission() {
    }

    public Commission(String position, String Name, String email) {
        this.position = position;
        this.Name = Name;
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public  void  updateinfo(String position,String name,String email){
         

    
    try {
        // Create a FileOutputStream object for the text file
        FileOutputStream fileOutputStream = new FileOutputStream("CommissionMembers.txt", true);

        // Convert data to string format
        String data = position + "," + name+ "," +email + "\n";

        // Write data to the file
        byte[] dataBytes = data.getBytes();
        fileOutputStream.write(dataBytes);

        // Close the FileOutputStream object
        fileOutputStream.close();

      //  System.out.println("Data saved successfully");
    } catch (IOException e) {
        
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Person Added");
        alert.setHeaderText("Successful");
        alert.setContentText("You Successfully added this person's information!");
        alert.showAndWait();

    } 
    
    public  void  delete(String email){
         

     // Read the file contents into a list of lines
    ArrayList<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("CommissionMembers.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }   catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
          
        }

    // Check if the email address exists in the file
    boolean emailFound = false;
    int lineIndex = -1;
    for (int i = 0; i < lines.size(); i++) {
        String line = lines.get(i);
        String[] data = line.split(",");
        if (data[2].equals(email)) { // Check the email in the third column
            emailFound = true;
            lineIndex = i;
            break;
        }
    }

    // If the email address is found, delete the corresponding line
    if (emailFound) {
        lines.remove(lineIndex);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("person Delted");
            alert.setHeaderText("successful");
            alert.setContentText("You Successfully deleted this person!");
            alert.showAndWait();
        
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Email Address");
            alert.setHeaderText("Error");
            alert.setContentText("YYour email is not found!");
            alert.showAndWait();
    }

  
  // Rewrite the updated lines to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("CommissionMembers.txt"))) {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
    }   catch (IOException ex) {
           
        }
       

       

  

    
    }
    
     public  void  editinfo(String position,String name,String email){
         // Read the file contents into a list of lines
    ArrayList<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("CommissionMembers.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }   catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }

    // Check if the email address exists in the file
    boolean emailFound = false;
    int lineIndex = -1;
    for (int i = 0; i < lines.size(); i++) {
        String line = lines.get(i);
        String[] data = line.split(",");
        if (data[2].equals(email)) { // Check the email in the third column
            emailFound = true;
            lineIndex = i;
            break;
        }
    }

    // If the email address is found, update the corresponding line
    if (emailFound) {
        String updatedLine = position + "," + name + "," + email;
        lines.set(lineIndex, updatedLine);

        // Rewrite the updated lines to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CommissionMembers.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
           
        }

        // Display confirmation message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Updated");
        alert.setHeaderText("Successful");
        alert.setContentText("You Successfully updated this person's information!");
        alert.showAndWait();
    } else {
        // Display error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Email Address");
        alert.setHeaderText("Error");
        alert.setContentText("Your email is not found!");
        alert.showAndWait();
    }
         
     }
     }
     
     
