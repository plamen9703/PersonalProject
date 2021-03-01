/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class LabelImageManeger extends MouseAdapter {
    private String path;
    public LabelImageManeger(String path){
        this.path=path;
    }
    
    @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        File f = new File(path);
                        if (f.exists()) {
                            try {
                                Process pr = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
                                pr.waitFor();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "I/O error.", "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (InterruptedException ex) {
                                JOptionPane.showMessageDialog(null, "Interupted error.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "File does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
}
