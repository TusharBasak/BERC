/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISLAM
 */
public class Pricehikelinechart {
    private String usertype;
    private double existingprice;
    private double newprice;

    public Pricehikelinechart() {
    }

    public Pricehikelinechart(String usertype, double existingprice, double newprice) {
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
    
  public ArrayList<Pricehikelinechart> loadDataFromFile()  {
    ArrayList<Pricehikelinechart> priceData = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String userType = parts[0];
                double existingPrice = Double.parseDouble(parts[1]);
                double newPrice = Double.parseDouble(parts[2]);

                priceData.add(new Pricehikelinechart(userType, existingPrice, newPrice));
            }
        }
    } catch (FileNotFoundException ex) {
        
    } catch (IOException ex) {
        
    }

    return priceData;
}


}