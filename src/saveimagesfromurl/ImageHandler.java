/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveimagesfromurl;

/**
 *
 * @author user
 */
public class ImageHandler {
    private static String[] urlPaths=new String[0];
    private static String saveToPath;
    private static String saveName;
    
    public static void addUrlPath(){
        String[] copy=urlPaths;
        urlPaths=new String[urlPaths.length+1];
        for (int i = 0; i < copy.length; i++) {
            urlPaths[i]=copy[i];
        }
        urlPaths[urlPaths.length-1]=SavePanel.getTextFieldText(0);
    }
    
    public static void setSaveToPath(){
        ImageHandler.saveToPath=SavePanel.getTextFieldText(2);
    }
    
    public static void setSaveName(){
        ImageHandler.saveName=SavePanel.getTextFieldText(1);
    }
    
    public static String[] getUrlPaths(){
        return urlPaths;
    }
    
    public static String getSaveToPath(){
        ImageHandler.setSaveToPath();
        return saveToPath;
    }
    
    public static String getSaveName(){
        ImageHandler.setSaveName();
        return saveName;
    }
}
