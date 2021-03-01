/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveimagesfromurl;

import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class SaveFrame extends JFrame {
    public SaveFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
        add(new SavePanel());
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setSize(SavePanel.SAVE_PANEL_WIDTH, SavePanel.SAVE_PANEL_HEIGHT);
    }
}
