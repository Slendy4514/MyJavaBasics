/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

/**
 *
 * @author Matías
 */
public class EventCounter {
    
    int start,actual,end;
    
    public EventCounter(){
        this.start = this.actual = 0;
    }
    
    public EventCounter(int actual){
        this.start = this.actual = actual;
    }
    
    public void add(){
        ++actual;
    }
    
    public void rest(){
        --actual;
    }
    
    public void plus(int num){
        actual = actual + num;
    }
    
    public void Set(int to){
        actual = to;
    }
    
    public void Reset(){
        actual = start;
    }
    
    public boolean Check(int end){
        return actual > end;
    }
    
    
    public void Reset(int end){
        if (Check(end))
        actual = 0;
    }
    
    public int get(){
        return actual;
    }
    
    @Override
    public String toString(){
        return this.get()+"";
    }
    
}
