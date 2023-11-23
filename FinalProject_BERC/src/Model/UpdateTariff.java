/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ISLAM
 */
public class UpdateTariff {
    private String user;
    Double existingprice,Newprice;

    public UpdateTariff() {
    }

    public UpdateTariff(String user, Double existingprice, Double Newprice) {
        this.user = user;
        this.existingprice = existingprice;
        this.Newprice = Newprice;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getExistingprice() {
        return existingprice;
    }

    public void setExistingprice(Double existingprice) {
        this.existingprice = existingprice;
    }

    public Double getNewprice() {
        return Newprice;
    }

    public void setNewprice(Double Newprice) {
        this.Newprice = Newprice;
    }
    public  void  updateinfo(String user,Double existingprice,Double newprice){
         

    
    try {
        // Create a FileOutputStream object for the text file
        FileOutputStream fileOutputStream = new FileOutputStream("data.txt", true);

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
