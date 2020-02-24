/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.util.ArrayList;

/**
 *
 * @author Matías
 */
public class BInt {
    
    public static int IntExtract (String text){
        text = text.replaceAll("[^0-9]", "");
        if (!text.isEmpty()){
        int entero = Integer.parseInt(text);
        return entero;}else{return 0;}
    }
    
    public static int IntExtract (String text, int num){
        int i1, i2;
        i1 = i2 = 0;
        for (int i = 0; i < num; ++i){
        i1 = i2;
        while (i1 < text.length() && !Character.isDigit(text.charAt(i1))){
            ++i1;
        }
        i2 = i1;
        while (i2 < text.length() && Character.isDigit(text.charAt(i2))){
            ++i2;
        }
        }
        int Int = Integer.parseInt(text.substring(i1,i2));
        return Int;
    }
    
    public static int[] IntExtractArr (String text){
        int i1, i2;
        i1 = i2 = 0;
        ArrayList<Integer> List = new ArrayList();
        while (i2 < text.length() && i1 < text.length()){
            i1 = i2;
            while (i1 < text.length() && !(Character.isDigit(text.charAt(i1)) || text.charAt(i1) == '-')){
                ++i1;
            }
            i2 = i1;
            if (text.charAt(i1) == '-'){
                ++i2;
            }
            while (i2 < text.length() && Character.isDigit(text.charAt(i2))){
                ++i2;
            }
            if (i1 == i2){break;}
            int Int = Integer.parseInt(text.substring(i1,i2));
            List.add(Int);
        }
        int[] a = new int[List.size()];
        for (int Int = 0; Int<List.size(); Int++){
            a[Int] = List.get(Int);
        }
        return a;
    }
    
        public static ArrayList IntExtractArr (String text, int num){
        int i1, i2;
        i2 = 0;
        ArrayList List = new ArrayList();
        for (int i = 0; i < num; ++i){
            i1 = i2;
            while (i1 < text.length() && !Character.isDigit(text.charAt(i1))){
                ++i1;
            }
            i2 = i1;
            while (i2 < text.length() && Character.isDigit(text.charAt(i2))){
                    ++i2;
            }
            int Int = Integer.parseInt(text.substring(i1,i2));
            List.add(Int);
        }
        return List;
    }
        
    public static boolean contains(int c, int[] arr){
        int i = 0;
        while (i < arr.length && arr[i] != c){
            i++;
        }
        return i < arr.length;
    }
    
}
