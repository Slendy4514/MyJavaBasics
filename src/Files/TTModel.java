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
public class TTModel extends TModel{
    
    final static char complexChar = ':';
    
    TTModel(int[] Cplx, int[] Cod, int[] canNull, int atr, char sep, HashMap D){
        super(Cplx,Cod,canNull,atr,sep,D);
    }
    
    private TTModel(){
        super(null,null,null,-1,TTModel.complexChar,new HashMap());
    }
    
    protected static TTModel ComplexTable(){
        return new TTModel();
    }
    
}
