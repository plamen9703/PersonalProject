/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveimagesfromurl;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author user
 */
public class SavePanel extends JPanel{
    public static final int SAVE_PANEL_WIDTH = 350;
    public static final int SAVE_PANEL_HEIGHT = 450;
    
    private static JLabel[] labels;
    private static JTextField[] textField;
    private static JButton[] buttons;
    
    public SavePanel(){
        setLayout(null);
        setSize(SAVE_PANEL_WIDTH,SAVE_PANEL_HEIGHT);
        
        addLabels();
        
        addTextFields();
        
        addButtons();
    }
    
    public final void addLabels(){
        String[] textLabel={"url:", "name:", "save to:"};
        labels=new JLabel[3];
        for (int i = 0; i < labels.length; i++) {
            labels[i]=new JLabel(textLabel[i]);
            labels[i].setSize(70, 20);
            labels[i].setLocation(50, i*(labels[i].getHeight()+20)+50);
            labels[i].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[i].setVerticalAlignment(SwingConstants.CENTER);
            add(labels[i]);
        }
    }
    
    public final void addTextFields(){
        textField=new JTextField[3];
        for (int i = 0; i < labels.length; i++) {
            textField[i]=new JTextField();
            textField[i].setSize(200, 30);
            textField[i].setLocation(60+ labels[i].getWidth(), i*(labels[i].getHeight()+20)+50);
            add(textField[i]);
        }
    }
    
    public final void addButtons(){
        String[] textButtons={"Add", "Save"};
        buttons=new JButton[2];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i]=new JButton(textButtons[i]);
            buttons[i].setSize(75, 50);
            buttons[i].setLocation(i*(buttons[i].getWidth()+50)+100, 200);
            buttons[i].addActionListener(new ButtonAction(i+1));
            add(buttons[i]);
        }
    }
    
    public static String getTextFieldText(int index){
        String retur=textField[index].getText();
        textField[index].setText("");
        return retur;
    }
}
