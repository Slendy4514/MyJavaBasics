/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 *
 * @author Matías
 */
public class FilesActions {
    
    private File F;
    
    private FilesActions(File F){
        this.F = F;
    }
        
    public static Predicate<String> ByCondition(int arg, String condition, boolean discriminante, char c){
        return (discriminante) ? s -> s.split(c+"")[arg].equalsIgnoreCase(condition):s -> !s.split(c+"")[arg].equalsIgnoreCase(condition);
    }
    
    /**
     * Lector (Normal): Solo lee texto.
     * @param file El archivo a leer
     * @return Un ArrayList con todas las lineas de texto.
     */
    public static ArrayList<String> Lector(File file){
        ArrayList<String> lineas;
        lineas = new ArrayList();
        BufferedReader Lect = null;
        try{
            Lect = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = Lect.readLine()) != null){   
                lineas.add(line);
                }
        
            }catch (IOException e){
                System.out.println("Error");
            }finally{
                try{
                    Lect.close();
                }catch(IOException IO){System.out.println("Error lect");}
            }
        return lineas;
        }
    
    /**
     * Lector (Discriminante): Solo lee texto.
     * @param file El archivo a leer.
     * @param Pred La condición con la que se filtrarán lines del archivo
     * @return Un ArrayList con todas las lineas de texto.
     */
    public static ArrayList<String> Lector(File file, Predicate<String> Pred){ //discrimina las opciones que cumplen con el argumento
        ArrayList<String> lineas;
        lineas = new ArrayList();
        BufferedReader Lect = null;
        try{
            Lect = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = Lect.readLine()) != null){
                if (Pred.test(line)){lineas.add(line);}
                }
            }catch (IOException e){
                System.out.println("Error");
            }finally{
                try{
                    Lect.close();
                }catch(IOException IO){System.out.println("Error lect");}
            }
        return lineas;
    }
    
    public static ArrayList<String> Lector(File file, String condition){ //discrimina las opciones que cumplen con el argumento
        ArrayList<String> lineas;
        lineas = new ArrayList();
        BufferedReader Lect = null;
        try{
            Lect = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = Lect.readLine()) != null){
                if (!line.equalsIgnoreCase(condition)){lineas.add(line);}
                }
        
            }catch (IOException e){
                System.out.println("Error");
            }finally{
                try{
                    Lect.close();
                }catch(IOException IO){System.out.println("Error lect");}
            }
        return lineas;
    }
    
    public static ArrayList<String> Lector(File file, int arg){ //Solo la informacion del numero de argumento
        ArrayList<String> lineas;
        lineas = new ArrayList();
        BufferedReader Lect = null;
        try{
            Lect = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = Lect.readLine()) != null){
                lineas.add(line.split(" ")[arg]);
                }
        
            }catch (IOException e){
                System.out.println("Error");
            }finally{
                try{
                    Lect.close();
                }catch(IOException IO){System.out.println("Error lect");}
            }
        return lineas;
    }
    
    public static void Save(File file,String Save) throws IOException{
        try (FileWriter fw = new FileWriter(file,true)) {
            Save = Save.replaceAll("\n", "");
            fw.write(Save+System.lineSeparator());
        }
    }
    
    public static void Save(File file, Collection<String> Save) throws IOException{
        try (FileWriter fw = new FileWriter(file,true)) {
            for(String S : Save){
                S = S.replaceAll("\n", "");
                fw.write(S+System.lineSeparator());
            }
        }
    }
    
    public static void Remove (File file, String Remove) throws FileNotFoundException{
        PrintWriter pw;
        ArrayList lista = Lector(file,Remove);
        pw = new PrintWriter(file);
        for(int i = 0; i<= lista.size()-1; ++i){
        pw.println(lista.get(i));}
        pw.close();
    }
    
    public static void Remove (File file, Predicate<String> Pred) throws FileNotFoundException{
        PrintWriter pw;
        ArrayList lista = Lector(file,Pred.negate());
        pw = new PrintWriter(file);
        for(int i = 0; i<= lista.size()-1; ++i){
        pw.println(lista.get(i));}
        pw.close();
    }
    
    public static void Edit(File file, int line, String Text) throws FileNotFoundException{
        PrintWriter pw;
        ArrayList lista = Lector(file);
        if (lista.size() == line){lista.add(Text);}
        else{lista.set(line, Text);}
        pw = new PrintWriter(file);
        for(int i = 0; i<= lista.size()-1; ++i){
        pw.println(lista.get(i));}
        pw.close();
    }
    
    public static int Lines(File file){
        int i = 0;
        BufferedReader Lect = null;
        try{
            Lect = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = Lect.readLine()) != null){
                i++;
                }
        
            }catch (IOException e){
                System.out.println("Error");
            }finally{
                try{
                    Lect.close();
                }catch(IOException IO){System.out.println("Error lect");}
            }
        return i;
        }
    
}
