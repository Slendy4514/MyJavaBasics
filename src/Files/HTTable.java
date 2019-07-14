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
public class HTTable extends TTable implements HashTable{
    
    public HTTable(HTTModel TM){
        super(TM);
//        for (int i = 0; i; )
    }

    @Override
    public void add(String Info, String At) {
        this.set(Info,asHT(TM).getID(At));
    }

    @Override
    public void addComplex(ArrayList A, String At) {
        TTable Sub = Table.complex(A);
        this.set(Sub+"",asHT(TM).getID(At));
    }

    @Override
    public void addDinamic(String Info, String in, String At) {
        this.setDinamic(Info, asHT(TM).getDinID(in,At));
    }
    
}
