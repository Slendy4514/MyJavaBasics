/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Matías
 */
public class PropManager {
    
    private final String File;
    private final String Ext;
    private final String dir;
    private final Properties prop;
    
     public PropManager(String File, String Ext){
        this.File = File;
        this.Ext = Ext;
        this.dir = "";
        prop = new Properties();  
    }
     
     public PropManager(String dir, String File, String Ext){
        this.File = File;
        this.Ext = Ext;
        this.dir = dir;
        prop = new Properties();  
    }
     
    public String directory(){
        return dir+File+"."+Ext;
    }
     
     public boolean exists(){
         File P = new File(directory());
         return P.exists();
     }
     
     /**
      * @param Config
      * @param Value
     * @return 
      */
     public boolean SaveProp(String Config, String Value){
        try{
            prop.load(new FileInputStream(directory()));
            prop.setProperty(Config,Value);
            prop.store(new FileOutputStream(directory()), null);
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
     
     public String ReadProp(String Config){
        String Setting = null;
        try{
            prop.load(new FileInputStream(directory()));
            Setting = prop.getProperty(Config);
        }catch(IOException e){
            e.printStackTrace();
        }
        return Setting;
    }
    
}
