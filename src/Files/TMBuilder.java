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
public class TMBuilder {
    
    private TModels TM;
    private int[] Cod = {};
    private int[] Cplex = {};
    private int[] canNull = {};
    private int[] keys = {};
    private int atr;
    private char sep;
    private File table;
    private final HashMap<Integer,HashMap<String,Integer>> Din = new HashMap();
    
    public TMBuilder setCod(int ... Cod){
        this.Cod = Cod;
        return this;
    }
    
    public enum TModels{
        TTM,HTTM,FTM,HFTM,QTM,HQTM;
    }
    
    //TTM
    
    public TMBuilder setTM(TModels TM){
        this.TM = TM;
        return this;
    }
    
    public TMBuilder setCplx(int ... Cplx){
        this.Cplex = Cplx;
        return this;
    }
    
    public TMBuilder setNulls(int ... canNull){
        this.canNull = canNull;
        return this;
    }
    
    public TMBuilder setAtributes(int atr){
        this.atr = atr;
        return this;
    }
    
    public TMBuilder setSep(TModel.Separators Separator){
        this.sep = Separator.get();
        return this;
    }
    
    TMBuilder setCplexSeparator(){
        this.sep = TTModel.complexChar;
        return this;
    }
    
    public TMBuilder addDin(int pos, String value, int add){
        if (!Din.containsKey(pos))
            Din.put(pos,new HashMap());
        Din.get(pos).put(value, add);
        return this;
    }
    
    //FTM
    
    public TMBuilder setKeys(int ... Keys){
        this.keys = Keys;
        return this;
    }
    
    public TMBuilder setFile(File F){
        table = F;
        return this;
    }
    
    //Hash
    
    public TMBuilder addField(String Field){
        return this;
    }
    
    public TModel build(){
        switch(TM){
            case TTM:
                return new TTModel(Cplex,Cod,canNull,atr,sep,Din);
            case FTM:
                return new FTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
            case QTM:
                return new QTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
            case HTTM:
                return new HTTModel(Cplex,Cod,canNull,atr,sep,Din);
            case HFTM:
                return new HFTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
            case HQTM:
                return new HQTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
            default:
                return null;
        }
    }
    
    public TTModel buildAsTTM(){
        return new TTModel(Cplex,Cod,canNull,atr,sep,Din);
    }
    
    public HTTModel buildAsHTTM(){
        return new HTTModel(Cplex,Cod,canNull,atr,sep,Din);
    }
    
    public FTModel buildAsFTM(){
        return new FTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
    }
    
    public FTModel buildAsHFTM(){
        return new HFTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
    }
    
    public QTModel buildAsQTM(){
        return new QTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
    }
    
    public HQTModel buildAsHQTM(){
        return new HQTModel(Cplex,Cod,canNull,atr,sep,Din,keys,table);
    }    
    
}
