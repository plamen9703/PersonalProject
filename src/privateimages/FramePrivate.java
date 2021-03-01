/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateimages;

import javax.swing.*;

/**
 *
 * @author user
 */
public class FramePrivate extends JFrame{

//    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public FramePrivate(String path) {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
        
        setResizable(false);
        
        add(new PrivatePanel(path));
        pack();
        setSize(PrivatePanel.PANEL_PRIVATE_WIDTH,PrivatePanel.PANEL_PRIVATE_HEIGHT);
    }
}
