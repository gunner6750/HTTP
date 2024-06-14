/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author ACER
 */
public class draft {
    public static void main(String[] args) {
        try
{
    String filename= "www/index.html";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
    fw.write("add a line\n");//appends the string to the file
    fw.close();
}
catch(IOException ioe)
{
    System.err.println("IOException: " + ioe.getMessage());
}
        
    }
}
