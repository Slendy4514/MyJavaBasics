/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.util.HashMap;

/**
 *
 * @author Matías
 */
public class HTTModel extends TTModel implements HashTableModel{
    
    HashMap<String,Integer> Fields = new HashMap();
    HashMap<String,HashMap<String,Integer>> DinFields = new HashMap();
    
    HTTModel(int[] Cplx, int[] Cod, int[] canNull, int atr, char sep, HashMap D){
        super(Cplx,Cod,canNull,atr,sep,D);
    }

    @Override
    public int getID(String Field) {
        Integer F = Fields.get(Field);
        if (F == null)
            return -1;
        return F;
    }
    
    @Override
    public int getDinID(String Field, String SubField) {
        Integer F = DinFields.get(Field).get(SubField);
        if (F == null)
            return -1;
        return F;
    }
    
}
