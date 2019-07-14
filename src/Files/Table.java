/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.util.function.Predicate;
/**
 *
 * @author Matías
 */
public class Table extends TTable{    
    
    public Table(FTModel TM){
        super(TM);
    }
    
    public void Save(){
        
    }
    
    public static Table getByKey(int ... keys){
        return null;
    }
    
    public static Table getByKey(Predicate P){
        return null;
    }
}
