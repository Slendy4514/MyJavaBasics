/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Matías
 */
public class BThreads {
    
    /**
     * Thread.Sleep without the try/catch stuff.
     * @param time in milliseconds
     */
    public static void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {}
    }
    
    /**
     * TimeUnit.Sleep without the try/catch stuff.
     * @param TU Nanoseconds,Milliseconds,Seconds,Minutes,Hours or Days.
     * @param time The time in the specified Type.
     */
    public static void Sleep (TimeUnit TU, int time){
        try {
            TU.sleep(time);
        } catch (InterruptedException ex) {System.out.print(ex);}
    }
}
