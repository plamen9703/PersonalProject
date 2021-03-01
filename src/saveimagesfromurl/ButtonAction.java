/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveimagesfromurl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ButtonAction implements ActionListener {

    private final int buttonCase;

    public ButtonAction(int buttonCase) {
        this.buttonCase = buttonCase;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (buttonCase) {
            case 1:
                ImageHandler.addUrlPath();

                break;
            case 2:
                URL urls = null;
                InputStream in = null;
                ByteArrayOutputStream out;
                byte[] buf = new byte[50000000];
                String[] urlsPaths;
                String extention="";
                urlsPaths = ImageHandler.getUrlPaths();
                FileOutputStream fos;
                byte[] responce;
                String saveTo;
                String nameToSave;
                saveTo = ImageHandler.getSaveToPath();
                nameToSave = ImageHandler.getSaveName();
                for (int i = 0; i < urlsPaths.length; i++) {
                    try {
                        urls = new URL(urlsPaths[i]);
                        if (urlsPaths[i].contains(".gif")) {
                            extention=".gif";
                        }else{
                            extention=".jpg";
                        }
                        
                        in = new BufferedInputStream(urls.openStream());
                        out = new ByteArrayOutputStream();
                        int n = 0;
                        while (-1 != (n = in.read(buf))) {
                            out.write(buf, 0, n);
                        }
                        responce = out.toByteArray();
                        out.close();
                        in.close();

                        fos = new FileOutputStream(saveTo + "\\" + nameToSave + " (" + (i + 1) + ")"+extention);
                        fos.write(responce);
                        fos.close();
                    } catch (MalformedURLException ex) {
                        JOptionPane.showMessageDialog(null, "URL error.", "Error.", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "I/O error.", "Error.", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }

                }
                System.gc();
                break;
        }
    }

}
