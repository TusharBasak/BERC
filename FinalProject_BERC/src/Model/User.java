/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.text.AbstractDocument.Content;




/**
 *
 * @author ISLAM
 */
public class User implements Serializable{
    protected String useremail;
    protected String password;
    protected String userType;
  

    public User() {
    }

    public User(String useremail, String password, String userType) {
        this.useremail = useremail;
        this.password = password;
        this.userType = userType;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

   public static final void createnewuser(String useremail,String Password,String usertype){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
           Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        
        try {
            f = new File("EmpObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            
            
            
 // Check if the email already exists in the file
boolean emailExists = false;
FileInputStream fis = null;
ObjectInputStream ois = null;
try {
    fis = new FileInputStream("EmpObjects.bin");
    ois = new ObjectInputStream(fis);

    while (true) {
        User existingUser = (User) ois.readObject();
        if (existingUser.getUseremail().equals(useremail)) {
            emailExists = true;
            break;
        }
    }
}
 catch (EOFException e) {
    // Reached the end of the file without finding the email
} catch (IOException | ClassNotFoundException e) {
    // Handle exceptions
    
}
            
    if (emailExists) {
    // Email already exists, inform the user
     a = new Alert(Alert.AlertType.WARNING);
    a.setTitle("Email Already Registered");
    a.setHeaderText("Error");
    a.setContentText("The provided email address is already registered. Please use a different email.");
    a.showAndWait();
    return;
} else {
    
      
            
            
            
            
          User u=new User(
                useremail,
                Password,
                usertype
          
          
          
          );
          
          
         
           
          oos.writeObject(u);
          a.setTitle("Signup  successful");
                    a.setHeaderText("Congratulations");
                    a.setContentText("Welcome");
                    a.showAndWait();
        
    }     

       } catch (IOException ex) {
         
       } finally {
           try {
                
                if(oos != null) oos.close();
           } catch (IOException ex) {
               
            }
        }  

       } 

   
//   "Regulator","Administration","Management Officer",
//         "Energy Producer and Distributor","Consumer","Financial Analyst",
//         "Human Resource","Employee"
   public  void setUserScene(String type,ActionEvent event) throws IOException  {
        Parent root = null;
        switch (type) {
             case "Regulator":
                root = FXMLLoader.load(getClass().getResource("/Main/Regulator.fxml"));
                break;
            case "Administration":
                root = FXMLLoader.load(getClass().getResource("/Main/Administration.fxml"));
                break;
            case "Contain Manager":
                root = FXMLLoader.load(getClass().getResource(""));
               break;
            case "Customer Care":
                root = FXMLLoader.load(getClass().getResource(""));
                break;
            case "Legal Advisor":
                root = FXMLLoader.load(getClass().getResource(""));
                break;
                case "Financial Analyst":
                root = FXMLLoader.load(getClass().getResource(""));
                break;
               case "Subscriber":
                root = FXMLLoader.load(getClass().getResource(""));
                break;
               case"CEO":
                    root = FXMLLoader.load(getClass().getResource(""));
                break;
                    
            default:
                throw new IOException("Invalid user type");
                 
        }
        
        
      Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Set the root of the current stage's scene to the main scene's root
    currentStage.setScene(new Scene(root));
//Scene scene2 = new Scene(root);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//        window.setScene(scene2);
//        window.show();  

   
    }
        
  public static final void signin(String useremail,String Password,String usertype,ActionEvent event)   {
       
   Alert a = new Alert(Alert.AlertType.INFORMATION);
    File f = new File("EmpObjects.bin");

    try(FileInputStream fis = new FileInputStream(f) ;
            ObjectInputStream ois = new ObjectInputStream(fis))  {
    //FileInputStream fis = new FileInputStream(f) ;
     //ObjectInputStream ois = new ObjectInputStream(fis);
    ArrayList<User> userList = new ArrayList<>();
    boolean loggedin = false;

    User user;
    while ((user = (User) ois.readObject()) != null) {
        userList.add(user);

        if (user.getUseremail().equals(useremail) &&
                user.getPassword().equals(Password) &&
                user.getUserType().equals(usertype)) {
            loggedin = true;
              
              user.setUserScene(usertype, event);
            break;
        }
    }

    if (!loggedin) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText("Invalid Credentials");
        alert.setContentText("Please check your username, password, and user type and try again.");
        alert.showAndWait();
    }
} catch (ClassNotFoundException e) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Missing Class");
    alert.setContentText("The User class was not found. Please ensure that the User class is included in the classpath.");
    alert.showAndWait();
} catch (FileNotFoundException e) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("File Not Found");
    alert.setContentText("The EmpObjects.bin file was not found. Please ensure that the file exists in the correct location.");
    alert.showAndWait();
} catch (IOException e) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Input/Output Error");
    alert.setContentText("An unexpected error occurred while reading from the EmpObjects.bin file.");
    alert.showAndWait();
}
    

  
    
    

   
}

    
       
   


  
  
  
   public static final void changepassword(String useremail,String Password,String usertype) {
   
    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
    try (FileInputStream fis = new FileInputStream("EmpObjects.bin");
        // FileOutputStream fos = new FileOutputStream("TempEmpObjects.bin");
         ObjectInputStream ois = new ObjectInputStream(fis);
        // ObjectOutputStream oos = new ObjectOutputStream(fos)) 
            ){

        List<User> updatedUserList = new ArrayList<>();
        boolean userFound = false;

        while (true) {
            try {
                User user = (User) ois.readObject();
                updatedUserList.add(user);

                if (user.getUseremail().equals(useremail) && user.getUserType().equals(usertype)) {
                    user.setPassword(Password);
                    userFound = true;
                    break; // Stop iterating once the user is found
                }
            } catch (EOFException e) {
                // Reached the end of the file, break out of the loop
                break;
            } catch (IOException e) {
               
            } catch (ClassNotFoundException ex) {
                
            }
        }

        if (userFound) {
            // Close both file streams before proceeding
          //  oos.close();
            fis.close();

            // Delete the original file
            new File("EmpObjects.bin").delete();

            // Create a new output stream for the original file
            FileOutputStream originalFos = new FileOutputStream("EmpObjects.bin");
            ObjectOutputStream originalOos = new ObjectOutputStream(originalFos);

            // Write the updated user records to the original file
            for (User user : updatedUserList) {
                originalOos.writeObject(user);
            }

            // Close the original file stream to ensure proper data flushing
            originalOos.close();

            // Rename the temporary file if necessary
//            File tempFile = new File("TempEmpObjects.bin");
//            if (tempFile.exists()) {
//                tempFile.delete();
//            }

            a.setTitle("Password Changed  successfully");
                    a.setHeaderText("Congratulations");
                    a.setContentText("Weldone");
                    a.showAndWait();
                    
                    
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("password change Failed");
        alert.setHeaderText("Invalid Credentials");
        alert.setContentText("Please check your username, password, and user type and try again.");
        alert.showAndWait();
        }
    } catch (IOException e) {
       
    }
}

   
}

    
    



    



















    

  


       
   
     
    
    




     



      
        
  

     
   
        

    
  
 
      




 
            


        
  

  
     
       


    
    
           


   




       



    
  


     
    
    



  
      
  

      
      
      
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

 
           
           






   
        
    
   
    



        

        

      

    
   


         
  
     

               








   
        
    
   
    

    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   











    

  


       
   
     
    
    




     



      
        
  

     
   
        

    
  
 
      




 
            


        
  

  
     
       


    
    
           


   




       



    
  


     
    
    



  
      
  

      
      
      
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

 
           
           






   
        
    
   
    



        

        

      

    
   


         
  
     

               








   
        
    
   
    

    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   
        
          
   
    
    
    
    
   

