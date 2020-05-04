/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matías
 */
public class StringConnector {
    
    public static class builder{
        private final ArrayList<String> MainStringB;
        private final ArrayList<String> OrderB;
        private final HashMap<String,String> ReplacesB;
        private String def = "";
        
        public builder(){
            MainStringB = new ArrayList();
            ReplacesB = new HashMap();
            OrderB = new ArrayList();
        }
        
        public builder addString(String S){
            if(!S.equals(""))
                MainStringB.add(S);
            return this;
        }
        
        public builder addReplace(String Key){
            MainStringB.add("");
            ReplacesB.put(Key, def);
            OrderB.add(Key);
            return this;
        }
        
        public StringConnector build(){
            return new StringConnector(MainStringB,ReplacesB,OrderB);
        }
        
    }
    
    public static class connector{
        
        StringConnector SC;
                
        public connector(StringConnector SC){
            this.SC = SC;
        }
        
        public connector with(String key, String As){
            SC.Replaces.put(key, As);
            return this;
        }
        
        @Override
        public String toString(){
            String Connected = "";
            int o = 0;
            for (String S : SC.MainString) {
                if (S.equals("")){
                    Connected += SC.Replaces.get(SC.Order.get(o));
                    o++;
                }else{
                    Connected += S;
                }
            }
            return Connected;
        }
        
        public void print(){
            System.out.print(this);
        }
        
        public void println(){
            System.out.println(this);
        }
    }
    
    private final ArrayList<String> MainString;
    private final HashMap<String,String> Replaces;
    private final ArrayList<String> Order;
    
    private StringConnector(ArrayList<String> MainString, HashMap<String,String> Replaces, ArrayList<String> Order){
        this.MainString = MainString;
        this.Replaces = Replaces;
        this.Order = Order;
    }
    
    public connector connect(){
        return new connector(this);
    }
    
    private void replaceKey(String K, String V){
        
    }
    
}
