/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManualTest;

import Basics.StringConnector;

/**
 *
 * @author Mat�as
 */
public class TestStringConnector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringConnector SC = new StringConnector.builder().addString("Hola ").addReplace("Name")
                .addString(", �c�mo estas?\nTu email es: ").addReplace("email").addString(".").build();
        for(int i=0; i < 100; i++){
            SC.connect().with("Name", "Mat�as"+i).with("email", "mail"+i+"@gmail.com").println();
        }
        
    }
    
}
