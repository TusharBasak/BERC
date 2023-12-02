/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * FXML Controller class
 *
 * @author ISLAM
 */
public class CreateArchieveController implements Initializable {

    @FXML
    private TextArea subjectTextarea;
    @FXML
    private TextArea contentTextarea;
    @FXML
    private TextArea endtextarea;
    @FXML
    private TextField filetextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createButtonOnClick(ActionEvent event) throws IOException {
        
         String filename =filetextfield.getText();
        String subject= subjectTextarea.getText();
        String message = contentTextarea.getText();
        String end=endtextarea.getText();
       
      String Filename = filename;
      String subtext=subject;
      String Message = message;
      String endtext= end;

  PDDocument doc = new PDDocument();

try {
    PDPage page = new PDPage();
    doc.addPage(page);

    // Set font and leading
    PDFont font = PDType1Font.TIMES_BOLD;
    

    PDPageContentStream contents = new PDPageContentStream(doc, page);
    contents.setFont(font, 14);
    contents.setLeading(14); // Adjust leading to match font size
    contents.beginText();
    contents.newLineAtOffset(50, 700);
    //Subject
    // Wrap text to specified width (e.g., 500 characters)
    int lineWidth = 90;
    String currentLine = "";
    String[] words = subtext.split(" ");

    for (String word : words) {
        // Check if adding the current word would exceed the line width
        if (currentLine.length() + word.length() + 1 > lineWidth) {
            // Add the current line to the PDF and start a new line
            contents.showText(currentLine);
            contents.newLine();

            // Clear the current line to start a new one
            currentLine = "";
        }

        // Append the word to the current line
        currentLine += word + " ";
    }
    
    contents.showText(currentLine);
    contents.newLine();
     contents.newLine();
      contents.newLine();
   // System.out.println();
    //Message
    // Wrap text to specified width (e.g., 500 characters)
    int lineWidth1 = 90;
    String currentLine1 = "";
    String[] words1 = message.split(" ");

    for (String word : words1) {
        // Check if adding the current word would exceed the line width
        if (currentLine1.length() + word.length() + 1 > lineWidth1) {
            // Add the current line to the PDF and start a new line
            contents.showText(currentLine1);
            contents.newLine();

            // Clear the current line to start a new one
            currentLine1 = "";
        }

        // Append the word to the current line
        currentLine1 += word + " ";
    }
    
    // Add the remaining words to the PDF
    contents.showText(currentLine1);
    contents.newLine();
    contents.newLine();
    contents.newLine();
    
   //  System.out.println();
    //end
    //Message
    // Wrap text to specified width (e.g., 500 characters)
    int lineWidth2 = 90;
    String currentLine2 = "";
    String[] words2 = endtext.split(" ");

    for (String word : words2) {
        // Check if adding the current word would exceed the line width
        if (currentLine2.length() + word.length() + 1 > lineWidth2) {
            // Add the current line to the PDF and start a new line
            contents.showText(currentLine2);
            contents.newLine();

            // Clear the current line to start a new one
            currentLine2 = "";
        }

        // Append the word to the current line
        currentLine2 += word + " ";
    }
    contents.showText(currentLine2);
    contents.newLine();
     contents.newLine();
      contents.newLine();
    contents.endText();
    contents.close();

    doc.save(filename);
} catch (IOException ex) {
    System.err.println("Error creating PDF: " + ex.getMessage());
} finally {
    doc.close();
}

    
      
          
       filetextfield.clear();
        subjectTextarea.clear();
        contentTextarea.clear();
        endtextarea.clear();
        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            // Load the FXML file of the main scene
            Parent root = FXMLLoader.load(getClass().getResource("Regulator.fxml"));
            
            // Get the current stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the root of the current stage's scene to the main scene's root
            currentStage.setScene(new Scene(root));
        } catch (IOException ex) {
            
        }
    }
    
}
