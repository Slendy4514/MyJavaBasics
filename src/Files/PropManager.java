/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Matías
 */
public class PropManager {
    
    String File, Ext;
    public Properties prop;
    
     public PropManager(String File, String Ext){
        this.File = File;
        this.Ext = Ext;
        prop = new Properties();  
    }
     
     public void SaveProp(String Config, String Value){
        try{
            prop.setProperty(Config,Value);
            prop.store(new FileOutputStream(File+"."+Ext), null);
        }catch(IOException e){
            System.out.println("IO Error");
        }
    }
     
     public String ReadProp(String Config){
        String Setting = "";
        try{
            prop.load(new FileInputStream(File+"."+Ext));
            Setting = prop.getProperty(Config);
        }catch(IOException e){
            System.out.println("IO Error");
        }
        return Setting;
    }
    
}
