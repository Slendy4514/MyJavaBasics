/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManualTest;

import Files.FilesActions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matías
 */
public class FilesTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File F = new File("Test.txt");
        File F2 = new File("Test2.txt");
        ArrayList<String> S = new ArrayList();
        for (int i = 0; i<100000; i++){
            S.add("Prueba"+i);
        }
        try {
            F.createNewFile();
            FilesActions.Save(F,S);
        } catch (IOException ex) {}
    }
    
}
