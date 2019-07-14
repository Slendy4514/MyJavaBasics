/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.util.ArrayList;

/**
 *
 * @author Matías
 */
public class HTable extends Table implements HashTable{
    
    public HTable(HFTModel TM){
        super(TM);
    }

    @Override
    public void add(String Info, String At) {
        this.set(Info,asHF(TM).getID(At));
    }

    @Override
    public void addComplex(ArrayList A, String At) {
        TTable Sub = Table.complex(A);
        this.set(Sub+"",asHF(TM).getID(At));
    }

    @Override
    public void addDinamic(String Info, String in, String At) {
        this.setDinamic(Info, asHF(TM).getDinID(in,At));
    }
    
}
