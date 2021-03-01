/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateimages;


import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/**
 *
 * @author user
 */
public final class ImageManeger extends KeyAdapter implements Serializable {
    
    public final void setLabellacations() {
        
    }
    
    public void save(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oob = new ObjectOutputStream(fos);
            oob.close();
            fos.close();
       } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("I/O error.");
        }
    }

    public void load(String path) {
        try {
            FileInputStream fos = new FileInputStream(path);
            ObjectInputStream oob = new ObjectInputStream(fos);
            oob.readObject();
            oob.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("I/O error.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class cannot be cast.");
        }
    }

}
