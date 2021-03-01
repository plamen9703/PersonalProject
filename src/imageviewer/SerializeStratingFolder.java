/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SerializeStratingFolder {
    public static void main(String[] args) {
        Folder[] fiolder=null;
        Scanner scan=new Scanner(System.in);
        String path=scan.nextLine();
        scan.close();
        try {
            ObjectInputStream i=new ObjectInputStream(new FileInputStream("G:\\java girls serialization\\gilrsInformation.txt"));
            fiolder=(Folder[])i.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("I/O error.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class cannot be cast.");
        }
        System.out.println(fiolder[0].toString());
    }
}
