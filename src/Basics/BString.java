/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Matías
 */
public class BString {
    
    private String Text = null;
    
    private BString(String text){
        Text = text;
    }
    
    public static BString conv (String text){
        return new BString(text);
    }
    
     /**
     * 
     * @param inicio char sequence after the substring
     * @param fin char sequence before the substring
     * @return 
     */
    
    public String substring (String inicio, String fin){
        return substring(inicio,fin,1,1);
    }
    
    public String substring (int pos,String inicio, String fin){
        return this.substring(inicio, fin, pos, 1);
    }
    
    public String substring (String inicio, String fin, int pos){
        return this.substring(inicio, fin, 1, pos);
    }
    
    public String substring(String inicio, String fin, int posI, int posF){
        int i,f;
        i = Text.indexOf(inicio);
        if (i >= 0){
            i += inicio.length();
            for (int j = 1; j<posI; j++){
                int newI = Text.indexOf(inicio,i)+inicio.length();
                if(i<newI){i = newI;}
                else{break;}
            }
            f = Text.indexOf(fin,i+1);
        }else{
            i = 0;
            f = Text.indexOf(fin);
        }
        for (int j = 1; j<posF; j++){
            int newF = Text.indexOf(fin,f+fin.length());
            if (f+fin.length() <= newF){f = newF;}
            else{break;}
        }
        if (f>0){return Text.substring(i,f);}
        else{return Text.substring(i);}
    }
    
    public String substring(String Regex){
        Pattern P = Pattern.compile(Regex);
        Matcher M = P.matcher(Text);
        if (M.find()){return M.group(1);}
        return null;
    }
    
    public String substring(String Regex, int find){
        Pattern P = Pattern.compile(Regex);
        Matcher M = P.matcher(Text);
        int i = 0;
        String found = null;
        while (M.find() && i <= find){
            found = M.group(1);
            i++;
        }
        return found;
    }
    
    public String removeString(int i, int f){
        if(i > f){throw new StringIndexOutOfBoundsException(i);}
        return Text.substring(0,i)+Text.substring(f);
    }
    
    public String removeString (String inicio, String fin){
        return removeString(inicio, fin, 1, 1);
    }
    
    public String removeString (int pos,String inicio, String fin){
        return removeString(inicio, fin, pos, 1);
    }
    
    public String removeString (String inicio, String fin, int pos){
        return removeString(inicio, fin, 1, pos);
    }
    
    public String removeString(String inicio, String fin, int posI, int posF){
        int i,f;
        i = Text.indexOf(inicio);
        if (i >= 0){
            i += inicio.length();
            for (int j = 1; j<posI; j++){
                int newI = Text.indexOf(inicio,i)+inicio.length();
                if(i<newI){i = newI;}
                else{break;}
            }
            f = Text.indexOf(fin,i+1);
        }else{
            i = 0;
            f = Text.indexOf(fin);
        }
        for (int j = 1; j<posF; j++){
            int newF = Text.indexOf(fin,f+fin.length());
            if (f+fin.length() <= newF){f = newF;}
            else{break;}
        }
        if (f>0){return Text.substring(0,i)+Text.substring(f);}
        else{return Text.substring(0,i);}
    }
    
    public String removeString(int posI, int posF,String inicio, String fin){
        int i,f;
        i = Text.indexOf(inicio);
        if (i >= 0){
            for (int j = 1; j<posI; j++){
                int newI = Text.indexOf(inicio,i+inicio.length());
                if(i<newI){i = newI;}
                else{break;}
            }
            f = Text.indexOf(fin,i+1);
        }else{
            i = 0;
            f = Text.indexOf(fin);
        }
        f += fin.length();
        for (int j = 1; j<posF; j++){
            int newF = Text.indexOf(fin,f)+fin.length();
            if (f+fin.length() <= newF){f = newF;}
            else{break;}
        }
        if (f>0){return Text.substring(0,i)+Text.substring(f);}
        else{return Text.substring(0,i);}
    }
    
    public String beforestring (String separador){
        String[] split = Text.split(separador, 2);
        if (split.length <= 1){return "";}
        return split[0];
    }
    
    public String afterstring (String separador){
        String[] split = Text.split(separador,2);
        if (split.length <= 1){return "";}
        return split[1];
    }
    
    public Boolean ContainsIgnoreCase(String Contenido){
        Text = Text.toLowerCase();
        Contenido = Contenido.toLowerCase();
        Boolean Contiene = Text.contains(Contenido);
        return Contiene;
    }
    
    public int timesMatch(String Regex){
        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(Text);
        int i = 0;
        while (matcher.find()){i++;}
        return i;
    }
    
    public String NumDelete (){
        String text = Text;
        text = text.replaceAll("[0-9]", "");
        return text;
    }
    
    public int getUppercases (){
        int CapitalLetters = 0;
        for (int i = 0; i < Text.length(); ++i){
            if (Character.isUpperCase(Text.charAt(i))){
                ++CapitalLetters;
            }
        }
        return CapitalLetters;
    }
}
