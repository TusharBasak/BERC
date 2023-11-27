/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ISLAM
 */
public class ManageEnergyPrice {
     private String usertype;
     private double existingprice;
     private double newprice;

    public ManageEnergyPrice() {
    }

    public ManageEnergyPrice(String usertype, double existingprice, double newprice) {
        this.usertype = usertype;
        this.existingprice = existingprice;
        this.newprice = newprice;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public double getExistingprice() {
        return existingprice;
    }

    public void setExistingprice(double existingprice) {
        this.existingprice = existingprice;
    }

    public double getNewprice() {
        return newprice;
    }

    public void setNewprice(double newprice) {
        this.newprice = newprice;
    }
   
    
     public  void  updateinfo(String user,Double existingprice,Double newprice){
         

    
    try {
        // Create a FileOutputStream object for the text file
        FileOutputStream fileOutputStream = new FileOutputStream("Energypricedata.txt", true);

        // Convert data to string format
        String data = user + "," + existingprice + "," + newprice + "\n";

        // Write data to the file
        byte[] dataBytes = data.getBytes();
        fileOutputStream.write(dataBytes);

        // Close the FileOutputStream object
        fileOutputStream.close();

        System.out.println("Data saved successfully");
    } catch (IOException e) {
        
    }


       

  

    
    }
    
    
     
    
}
