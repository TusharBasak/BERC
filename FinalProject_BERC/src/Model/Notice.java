/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Main.NoticeboardController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author ISLAM
 */
public class Notice {
    NoticeboardController nbc =new NoticeboardController();
    private File pdf;

    public Notice() {
    }

    public Notice(File pdf) {
        this.pdf = pdf;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }
   

   

   
  

  
    
     public  void  noticeinfo(File pdfFile){
         
      
    String pdfAddress = pdfFile.getAbsolutePath();

    // Write the PDF address to a text file
    try {
        FileWriter writer = new FileWriter("pdf_addresses.txt", true);
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
     
//     public String extractPDFFilePath(String line) {
//    String pattern = "(?i)\\bpdf\\:\\s*(.*)\\b"; // Regex pattern to match "pdf:" followed by a file path
//    Matcher matcher = Pattern.compile(pattern).matcher(line);
//    if (matcher.find()) {
//        return matcher.group(1); // Extract the captured file path
//    } else {
//        return null; // No PDF file path found in the line
//    }
}
    

