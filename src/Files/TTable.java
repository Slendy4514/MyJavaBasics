/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matías
 */
public class TTable {
    
    //Forma de la tabla y datos
    ArrayList<String> Data;
    TModel TM;
    int DataReturn = 0;
    int size = 0;
    int expectedSize;
    HashMap<Integer,ArrayList<String>> dinamics = new HashMap();
    
    public TTable(TModel TM){
        Data = new ArrayList();
        this.TM = TM;
        expectedSize = TM.atr;
    }
    
    //Bloqueo
    boolean lock = false;
    
    void CheckSize(){
        if (size == expectedSize)
            lock = true;
    }
    
    //Codificacion
    static final String CodTxt = "(?<!\\\\)";
    
    String Codif(String S){
        if (S == null) return null;
        if (S.endsWith("\\")){
            S = S+"$";
        }else{
            if (S.matches(".*\\\\\\$+$")){
                S = S.replaceFirst("(\\\\\\$+$)", "$1\\$");
            }
        }
        S = S.replaceAll(TM.sep+"", "\\\\"+TM.sep); //arreglar regex
        return S;
    }
    
    String DeCodif(String S){
        if (S.matches(".*\\\\\\$+$")){
                S = S.replaceFirst("\\$$", "");
        }
        S = S.replaceAll("\\\\"+TM.sep,TM.sep+"");
        return S;
    }
    
    //Setters
    
    private void beforeAdd(){
        if (lock)
            throw new IllegalStateException("This tuple is locked");
        size++;
    }
    
    private void checkExpected(String Info){
        if (TM.Dinamics.containsKey(Data.size()-1) && TM.Dinamics.get(Data.size()-1).containsKey(Info)){
            this.expectedSize += TM.Dinamics.get(Data.size()-1).get(Info);
        }
        this.CheckSize();
    }
    
    public void add(String Info){
        this.beforeAdd();
        Data.add(Info);
        this.checkExpected(Info);
    }
    
    void set(String Info, int i){
        this.beforeAdd();
        Data.set(i,Info);
        this.checkExpected(Info);
    }
    
    static TTable complex(ArrayList A){
        TModel SubTM = TTModel.ComplexTable();
        TTable Aux = new TTable(SubTM);
        ArrayList<Integer> NC = new ArrayList();
        for (int i = 0; i<A.size();i++){
            Aux.add(A.get(i).toString());
            if (A.get(i).toString().contains(TTModel.complexChar+""))
                NC.add(i);
        }
        SubTM = TModel.Builder().setTM(TMBuilder.TModels.TTM).setCod(Basics.BArrey.IntegerToInt(NC)).setCplexSeparator().build();
        TTable Sub = new TTable(SubTM);
        Sub.Data = Aux.Data;
        Sub.lock = true;
        return Sub;
    }
    
    public void addComplex(ArrayList A){
        if (!TM.isCplx(Data.size()))
            throw new IllegalStateException(Data.size()+" can´t hold complex values");
        TTable Sub = Table.complex(A);
        this.add(Sub+"");
    }
    
//    public void addDinComplex(ArrayList A){
//        TTable Sub = TTable.complex(A);
//        this.addDinamic(Sub+"");
//    }
    
    void setDinamic(String Info, int Pos){
        if (true)
            throw new IllegalArgumentException("Data "+(this.Size()-1)+" can't hold dinamyc values");
        this.beforeAdd();
        if (this.dinamics.get(Pos) == null)
            this.dinamics.put(Pos,new ArrayList());
        else
            this.dinamics.get(Pos).add(Info);
        this.checkExpected(Info);
    }  
    
    public void addDinamic(String Info){
        if (TM.Dinamics.containsKey(Data.size()-1) && TM.Dinamics.get(Data.size()-1).containsKey(Data.get(Data.size()-1))){
            this.beforeAdd();
            if (!this.dinamics.containsKey(Data.size()-1))
                this.dinamics.put(Data.size()-1,new ArrayList());
            this.dinamics.get(Data.size()-1).add(Info);
            this.checkExpected(Info);
        }else
            throw new IllegalArgumentException("Data "+(Data.size()-1)+" can't hold dinamyc values");
    }    
    
    public void reset(){
        this.CheckLocked();
        DataReturn = 0;
    }
    
    //Getters
    public int Size(){
        return size;
    }
    
    public String get(){
        this.CheckLocked();
        return this.get(DataReturn++);
    }
    
    public String get(int i){
        this.CheckLocked();
        if (i>=Data.size())
            throw new IndexOutOfBoundsException(i+"");
        return Data.get(i);
    }
    
    public ArrayList<String> getComplex(){
       return this.getComplex(DataReturn++); 
    }
    
    public ArrayList<String> getComplex(int i){
        this.CheckLocked();
        if (i>=Data.size())
            throw new IndexOutOfBoundsException(i+"");
        String[] L = Data.get(i).split(TTModel.complexChar+"");
        return Basics.BArrey.ToList(L);
    }
    
    public String getDin(int from, int pos){
        this.CheckLocked();
        if (TM.Dinamics.containsKey(pos) && TM.Dinamics.get(pos).containsKey(this.get(from)))
            return this.dinamics.get(from).get(pos);
        else
            throw new IllegalArgumentException("Data "+(Data.size()-1)+" dosn't hold dinamyc values");
    }
    
    //Extras
    
    protected void CheckLocked(){
        if (!lock)
            throw new IllegalStateException("Tuple is not locked");
    }
    
    @Override
    public String toString(){
        this.CheckLocked();
        String S = "";
        for (int i = 0; i < Data.size(); i++){
            S += (TM.isCod(i) && Data.get(i).contains(TM.sep+"")) ? Codif(Data.get(i))+TM.sep:Data.get(i)+TM.sep;
            if (TM.isDin(i,this.get(i))){
                for (String SubS : dinamics.get(i)){
                    S += SubS+TM.sep;
                }
            }
        }
        return S;
    }
    
    public static TTable From(TModel M, String Text){ //arreglar
        TTable T = new TTable(M);
        T.Data = Basics.BArrey.ToList(Text.split(CodTxt+M.sep));
        for (int i : M.Cod){
            if (T.Data.get(i).contains(M.sep+""))
                T.Data.set(i, T.DeCodif(T.Data.get(i)));
        }
        return T;
    }
    
    HTTModel asHT(TModel H){
        return (HTTModel) TM;
    }
    
    HFTModel asHF(TModel H){
        return (HFTModel) TM;
    }
    
    FTModel asFT(TModel H){
        return (FTModel) TM;
    }
}
