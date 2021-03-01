/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Folder implements Serializable {

    private final String girlName;
    private String path;

    private static transient final String[] extentions = {".jpg", ".jpeg", ".jpe", ".png", ".gif"};

    private transient File folder;
    private transient File[] files;

    private int indexLastImages;

    private transient int[] randomIndexes;

    public Folder(String name, String path) {
        this.girlName = name;
        this.path = path;
        onLoad();
    }
    
    public final void onLoad(){
        setFolder(path);
        setFiles();
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public final void setFolder(String path) {
        folder = new File(path);
    }

    public final void setFiles() {
        this.files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                for (String extention : extentions) {
                    if (file.getName().contains(extention)) {
                        return true;
                    }
                }
                return false;
            }
        });
//        filterFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File t, File t1) {
                double s = extractNumber(t.getName());
                double b = extractNumber(t1.getName());
                return (int) (s - b);
            }

            private double extractNumber(String name) {
                double number = 0.0;
                try {
                    number = Double.parseDouble(name.substring(name.indexOf('(') + 1, name.lastIndexOf(')')));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Something went wront!\n" + e.getCause() + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                return number;
            }
        });
        System.gc();
    }

//    public boolean checkFile(String toCheck) {
//        for (String extention : Folder.extentions) {
//            if (toCheck.endsWith(extention)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public final void filterFiles() {
//        for (int i = 0; i < files.length; i++) {
//            if (!checkFile(files[i].getName())) {
//                removeFromList(i);
//                i--;
//            }
//        }
//    }
//
//    public final void removeFromList(int i) {
//        LinkedList<File> copy;
//        copy = new LinkedList<>();
//        for (File file : files) {
//            copy.add(file);
//        }
//        copy.remove(i);
//        files = new File[files.length - 1];
//
//        for (int j = 0; j < copy.size(); j++) {
//            files[j] = copy.get(j);
//        }
//        System.gc();
//    }

    public void setIndex(int index) {
        this.indexLastImages = index;
    }

    public final ImageIcon[] getNextImages() {
        ImageIcon[] imagesToReturn = new ImageIcon[6];
        URL url = null;
        for (int i = 0; i < imagesToReturn.length; i++) {
            if (files[indexLastImages].getName().endsWith(".gif")) {
                try {
                    url = new URL(files[indexLastImages].getPath());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(null, "URL problem.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                imagesToReturn[i] = new ImageIcon(url);
            } else {
                imagesToReturn[i] = new ImageIcon(files[indexLastImages].getPath());
            }
            if (indexLastImages + 1 == files.length) {
                indexLastImages = 0;
            } else {
                indexLastImages++;
            }

        }
        System.gc();
        imagesToReturn = scaleImages(imagesToReturn);
        return imagesToReturn;
    }

    public final ImageIcon[] getPreviousImages() {
        ImageIcon[] imagesToReturn = new ImageIcon[6];
        URL url = null;
        for (int i = 0; i < imagesToReturn.length; i++) {
            if (files[indexLastImages].getName().endsWith(".gif")) {
                try {
                    url = new URL(files[indexLastImages].getPath());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(null, "URL problem.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                imagesToReturn[i] = new ImageIcon(url);
            } else {
                imagesToReturn[i] = new ImageIcon(files[indexLastImages].getPath());
            }
            if (indexLastImages - 1 == 0) {
                
                indexLastImages = files.length - 1;
            } else {
                indexLastImages--;
            }

        }
        System.gc();
        imagesToReturn = scaleImages(imagesToReturn);
        return imagesToReturn;
    }

    public final ImageIcon[] getRandomImages() {
        ImageIcon[] imagesToReturn = new ImageIcon[6];
        URL url = null;
        Random r = new Random();
        randomIndexes = new int[6];
        for (int i = 0; i < imagesToReturn.length; i++) {
            randomIndexes[i] = r.nextInt(files.length);
            if (files[randomIndexes[i]].getName().endsWith(".gif")) {
                try {
                    url = new URL(files[randomIndexes[i]].getPath());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(null, "URL problem.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                imagesToReturn[i] = new ImageIcon(url);
            } else {
                imagesToReturn[i] = new ImageIcon(files[indexLastImages].getPath());
            }

        }
        System.gc();
        imagesToReturn = scaleImages(imagesToReturn);
        return imagesToReturn;
    }

    public ImageIcon[] scaleImages(ImageIcon[] icons) {
        Image[] images = new Image[icons.length];
        for (int i = 0; i < images.length; i++) {
            images[i] = icons[i].getImage();
            images[i] = images[i].getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        }
        ImageIcon[] returnImages = new ImageIcon[images.length];
        for (int i = 0; i < returnImages.length; i++) {
            returnImages[i] = new ImageIcon(images[i]);
        }
        System.gc();
        return returnImages;
    }

    public String[] getNextPaths() {
        String[] toReturn = new String[6];
        int returnIndex = indexLastImages;
        for (int i = 0; i < 6; i++) {
            if (returnIndex - 1 < 0) {
                returnIndex=files.length-1;
            } else {
                returnIndex--;

            }
        }
        for (int i = 0; i < 6; i++) {
            toReturn[i] = files[returnIndex].getPath();
            if (returnIndex + 1 == files.length) {
                returnIndex = 0;
            } else {
                returnIndex++;
            }
        }
        return toReturn;
    }

    public String[] getPreviousPaths() {
        String[] toReturn = new String[6];
        int returnIndex = indexLastImages;
        for (int i = 0; i < 6; i++) {
            if (returnIndex + 1 == files.length) {
                returnIndex=0;
            } else {
                returnIndex++;

            }
        }
        for (int i = 0; i < 6; i++) {
            toReturn[i] = files[returnIndex].getPath();
            if (returnIndex - 1 < 0) {
                returnIndex = files.length - 1;
            } else {
                returnIndex--;
            }
        }
        return toReturn;
    }

    public String[] getRandomPaths() {
        String[] toReturn = new String[6];
        for (int i = 0; i < 6; i++) {
            toReturn[i] = files[randomIndexes[i]].getPath();
        }
        return toReturn;
    }
    @Override
    public String toString(){
        return this.girlName;
    }
    
    public File[] getFiles(){
        return files;
    }
    
    public final String[] getRandImages() {
        String[] imagesToReturn = new String[6];
        Random r = new Random();
        randomIndexes = new int[6];
        for (int i = 0; i < imagesToReturn.length; i++) {
            randomIndexes[i] = r.nextInt(files.length);
            imagesToReturn[i]=files[randomIndexes[i]].getPath();
        }
        return imagesToReturn;
    }
}
