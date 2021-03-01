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
public class PrivatePanel extends JPanel {

//set panel size
    public static final int PANEL_PRIVATE_WIDTH = 2 * 350 + 450;
    public static final int PANEL_PRIVATE_HEIGHT = 750;

//set image labels specs 
    private JLabel[] imageLabels;
    private static final int IMAGELABEL_HEIGHT = 350;
    private static final int IMAGELABEL_WIDTH = 250;

//set button specs
    private JButton[] buttons;

//set label and textfield for new images specs
    private JLabel textLabels;
    private JTextField textFields;

//set girlobject
    private Folder[] folder;
    public static ObjectInputStream readSaveData;

    public PrivatePanel(String path) {
        try {
            readSaveData = new ObjectInputStream(new FileInputStream(path));
            folder = (Folder[]) readSaveData.readObject();
            folder[0].onLoad();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Missing girls file.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "I/O girls file error.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Folder file class cast exeption.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        setLayout(null);

        setSize(PANEL_PRIVATE_WIDTH, PANEL_PRIVATE_HEIGHT);

        addImageLabels();

        addButtons();

        buildTextLabelsAndFields();

    }

    public final void addImageLabels() {
        buildImageLabel();
        for (int i = 0; i < imageLabels.length; i++) {
            add(imageLabels[i]);

        }
    }

    public final void addButtons() {
        buildButtons();
        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
        }
    }

    public void buildImageLabel() {
        imageLabels = new JLabel[6];
        ImageIcon[] images = (ImageIcon[]) folder[0].getNextImages();
        String[] paths = folder[0].getNextPaths();
        for (int i = 0; i < imageLabels.length; i++) {
            imageLabels[i] = new JLabel();

            imageLabels[i].setSize(IMAGELABEL_WIDTH, IMAGELABEL_HEIGHT);

            imageLabels[i].setIcon(images[i]);

            imageLabels[i].addMouseListener(new LabelImageManeger((paths[i])));

        }
        int spaceH = 0;
        int spaceV = 0;
        for (int t = 0, r = 0; t < imageLabels.length; r++, t += 3) {
            for (int j = t, k = 0; j < t + 3; k++, j++) {
                imageLabels[j].setLocation(k * imageLabels[j].getWidth() + spaceH * 10 + 5, r * imageLabels[j].getHeight() + spaceV * 10 + 5);
                spaceH++;
            }
            spaceH = 0;
            spaceV++;
        }

    }

    public final void buildButtons() {
        final String[] butonsTexts = {"Next Pictures", "Previous pictures", "Random pictures", "Chose  person", "Updade purson link", "Add Person","Remove person", "Save inforamation"};

        buttons = new JButton[8];

        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton(butonsTexts[i]);
            buttons[i].setLocation(2 * 350 + 100, (70 + buttons[i].getHeight()) * (i + 1) + 80);
            buttons[i].setSize(250, 50);
            buttons[i].setVisible(true);
            switch (i + 1) {
                case 1:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            setNextImages();
                        }
                    });
                    break;
                case 2:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            setPreviousImages();
                        }
                    });
                    break;
                case 3:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            setRandomImages();
                        }
                    });
                    break;
                case 4:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            
                        }
                    });
                    break;
                case 5:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            
                        }
                    });
                    break;
                case 6:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            
                        }
                    });
                    break;
                case 7:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            
                        }
                    });
                    break;
                case 8:
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            
                        }
                    });
                    break;
            }
        }
    }

    public final void buildTextLabelsAndFields() {
        textLabels = new JLabel("url:");
        textLabels.setLocation(IMAGELABEL_WIDTH * 3 + 30, 70);
        textLabels.setSize(50, 20);
        textLabels.setHorizontalAlignment(SwingConstants.LEFT);
        textLabels.setVerticalAlignment(SwingConstants.CENTER);
        add(textLabels);
        textFields = new JTextField();
        textFields.setLocation(textLabels.getX() + textLabels.getWidth() - 20, textLabels.getY() - 5);
        textFields.setSize(250, 30);
        add(textFields);
    }

    public void setNextImages() {
        ImageIcon[] images;
        images = folder[0].getNextImages();
        for (int i = 0; i < 6; i++) {
            imageLabels[i].setIcon(images[i]);
        }
    }

    public void setPreviousImages() {
        ImageIcon[] images;
        images = folder[0].getPreviousImages();
        for (int i = 0; i < 6; i++) {
            imageLabels[i].setIcon(images[i]);
        }
    }

    public void setRandomImages() {
        ImageIcon[] images;
        images = folder[0].getRandomImages();
        for (int i = 0; i < 6; i++) {
            imageLabels[i].setIcon(images[i]);
        }
    }
}
