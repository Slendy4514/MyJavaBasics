/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matías
 */
public class BArrey {
    
    static ArrayList ArrList;
    
    public BArrey(ArrayList A){
        ArrList = A;
    }
    
    public static <T> T[] Concat(T[]... concats){
        ArrayList<T> both = new ArrayList();
        for (T[] Array : concats){
            both.addAll(ToList(Array));
        }
        return both.toArray(concats[0]);
    }
    
    public static int[] IntegerToInt(List<Integer> integers){
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++){
            ret[i] = integers.get(i);
        }
        return ret;
    }
    
    public static <T> ArrayList<T> ToList(T ...toList){
        return new ArrayList<>(Arrays.asList(toList));
    }
    
    public static ArrayList<Integer> ToList(int[] toList){
        ArrayList<Integer> L = new ArrayList();
        for(int i:toList){
            L.add(i);
        }
        return L;
    }
    
    public static boolean hasDuplicates(){
        boolean duplicate = false;
        for (Object o:ArrList){
            if (ArrList.indexOf(o) == ArrList.lastIndexOf(o)){duplicate = true;}
            if(duplicate){break;}
        }
        return duplicate;
    }
    
}
