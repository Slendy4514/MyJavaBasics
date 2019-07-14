/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Matías
 */
public class FTModel extends TModel{
    
    final int[] keys;
    final File table;
    
    FTModel(int[] Cplx, int[] Cod, int[] canNull, int atr, char sep, HashMap D, int[] keys, File table){
        super(Cplx,Cod,canNull,atr,sep,D);
        this.table = table;
        Arrays.sort(keys);
        this.keys = keys;
    }
    
    protected boolean isKey(int i){
        return Basics.BArrey.ToList(keys).contains(i);
    }
    
    public void Save(Table T){
        
    }
    
}
