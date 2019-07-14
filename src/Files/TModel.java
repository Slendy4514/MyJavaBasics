/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Matías
 */
public abstract class TModel {
    
    public enum Separators{
        Space(' '),UnderScore('_'),Slash('/'),Hyphen('-'),Dot('.'),Comma(','),Line('|'),Semicolon(';');
        
        final char s;
        
        Separators(char s){
            this.s = s;
        }
        
        protected char get(){
            return s;
        }
    }
    
    final int[] Cod;
    final int[] complex;
    final int[] canNull;
    final int atr;
    final char sep;
    final HashMap<Integer,HashMap<String,Integer>> Dinamics;
    
    TModel(int[] Cplx, int[] Cod, int[] canNull, int atr, char sep, HashMap Dinamics){
        this.Cod = Cod;
        this.complex = Cplx;
        this.canNull = canNull;
        this.sep = sep;
        this.atr = atr;
        this.Dinamics = Dinamics;
    }
    
    protected boolean isCod(int i){
        return Basics.BArrey.ToList(Cod).contains(i);
    }
    
    protected boolean isCplx(int i){
        return Basics.BArrey.ToList(complex).contains(i);
    }
    
    protected boolean canBeNull(int i){
        return Basics.BArrey.ToList(canNull).contains(i);
    }
    
    protected boolean isDin(int i, String value){
        return Dinamics.containsKey(i) && Dinamics.get(i).containsKey(value);
    }
    
    public static TMBuilder Builder(){
        return new TMBuilder();
    }
    
}
