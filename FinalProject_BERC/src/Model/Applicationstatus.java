/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Main.RegulatorController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class Applicationstatus {
    String usertype;
    String nid;
    String address;
    String email;
    boolean notification1=false,notification2;
    int cnt=0;
     private int prevcount=0;
     private int newcount2=0;
     private int newcount3=0;

    public Applicationstatus() {
    }

    public Applicationstatus(String usertype, String nid, String address, String email) {
        this.usertype = usertype;
        this.nid = nid;
        this.address = address;
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPrevcount() {
        return prevcount;
    }

    public void setPrevcount(int prevcount) {
        this.prevcount = prevcount;
    }

    

    
    

    
    
    
        

    
   public  void  updateinfo(String usertype,String nid,String address,String email){
         

    

    
        
            
       
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Sucessful");
            a.setHeaderText("Sucessful");
            a.setContentText("Successfully Submission");
            a.showAndWait();

         // Convert data to string format
         // Create a FileOutputStream object for the text file
             FileOutputStream fileOutputStream = null ;
        try {
            fileOutputStream = new FileOutputStream("Application.txt",true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Applicationstatus.class.getName()).log(Level.SEVERE, null, ex);
        }
             // Convert data to string format
             String data = usertype + "," + nid + "," +address+","+email+ "\n";
             // Write data to the file
             byte[] dataBytes = data.getBytes();
        try {
            fileOutputStream.write(dataBytes);
            // Close the FileOutputStream object
        } catch (IOException ex) {
            Logger.getLogger(Applicationstatus.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
       try (BufferedReader reader = new BufferedReader(new FileReader("Application.txt"));
     FileWriter writer = new FileWriter("Destination2.txt",true)) {
    String line;
    while ((line = reader.readLine()) != null) {
        writer.append(line + "\n");
    }
} catch (IOException e) {
    System.err.println("Error: I/O exception:");
   
}
        
        
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Application.txt"));
     FileWriter writer = new FileWriter("Destination.txt",true)) {
    String line;
    while ((line = reader.readLine()) != null) {
        writer.append(line + "\n");
    }
} catch (IOException e) {
    System.err.println("Error: I/O exception:");
   
}
        
   
   
   }
            
           






 
 
  

       
    
   
   

       

  

    
   
  

        
public void notification (){   
    
   
      ArrayList<String> userTypes = new ArrayList<>();
//1111
    try (BufferedReader reader = new BufferedReader(new FileReader("Application.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split(",");
            String userType = splitLine[0];

            userTypes.add(userType);
        }
    } catch (FileNotFoundException ex) {
        // Handle FileNotFoundException
    } catch (IOException ex) {
        // Handle IOException                1

    }

    int currentCount = userTypes.size(); // Get the current count of applications

    if ( currentCount > prevcount) {
        // New application arrived
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText("Application Status");
        alert.setContentText("Please Check a new application arrived");
        alert.showAndWait();
        // prevcount = currentCount;
        // Update prevcount and newcount3 after the notification
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Application.txt"))) {
       writer.write("");
} catch (IOException e) {
    e.printStackTrace();
}
      //  newcount3 = currentCount;
    }
    
      
      //new File("EmpObjects.bin").delete();  
    
   }
}