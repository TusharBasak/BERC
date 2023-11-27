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
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISLAM
 */
public class Useratio {
    String usertype;

    public Useratio() {
    }

    public Useratio(String usertype) {
        this.usertype = usertype;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
   
    
    
 public ArrayList<String> loadDataFromFile() {
      ArrayList<String> userTypes = new ArrayList<>();

    try (FileInputStream fis = new FileInputStream(new File("EmpObjects.bin"));
       ObjectInputStream ois = new ObjectInputStream(fis)) {

      while (true) {
        User user = (User) ois.readObject();

        if (user != null) {
          String userType = user.getUserType();
          userTypes.add(userType);
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("Error: File not found: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Error: I/O exception: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      System.err.println("Error: Class not found: " + e.getMessage());
    }

    return userTypes;
    }
}
