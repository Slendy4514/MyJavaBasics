/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Matías
 */
public class QTModel extends FTModel{
    
    final HashMap<String,Table> Storage = new HashMap(); //HashMap ... N
    
    QTModel(int[] Cplx, int[] Cod, int[] canNull, int atr, char sep, HashMap D, int[] keys, File table){
        super(Cplx,Cod,canNull,atr,sep,D,keys,table);
    }
    
    private void Load(){
        
    }
    
    @Override
    public void Save(Table T){
        
    }
}
