/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;

/**
 *
 * @author ISLAM
 */
public class Archieveinfo {
    File pdf;

    public Archieveinfo() {
    }

    public Archieveinfo(File pdf) {
        this.pdf = pdf;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }
    
    
     public  void  Archieveinfo(java.io.File pdfFile){
         
      
    String pdfAddress = pdfFile.getAbsolutePath();

    // Write the PDF address to a text file
    try {
        FileWriter writer = new FileWriter("Archieve_addresses.txt", true);
        writer.write(pdfAddress + "\n");
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
        

   Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("publish");
        alert.setHeaderText("Successful");
        alert.setContentText("You Successfully publish");
        alert.showAndWait();
       
   

     }
}
