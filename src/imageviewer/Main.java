/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
       new FramePrivate("");
       double freeMemory=Runtime.getRuntime().freeMemory()/ (1024.0 * 1024.0 * 1024.0);
       double totalMemory=Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0 * 1024.0);
       System.out.printf("Free Memory: %.3fGiB\n", freeMemory);
       System.out.printf("Total Memory: %.3fGiB\n", totalMemory);
       System.gc();
       freeMemory=Runtime.getRuntime().freeMemory()/ (1024.0 * 1024.0 * 1024.0);
       totalMemory=Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0 * 1024.0);
       System.out.printf("Free Memory: %.3fGiB\n", freeMemory);
       System.out.printf("Total Memory: %.3fGiB\n", totalMemory);
    }
}
