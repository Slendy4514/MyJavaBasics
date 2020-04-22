/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matías
 */
public class BStringTest {
    
    public BStringTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of conv method, of class BString.
     */
    @Test
    public void testConv() {
        System.out.println("conv");
        String text = "";
        BString expResult = null;
        BString result = BString.conv(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substring method, of class BString.
     */
    @Test
    public void testSubstring_String_String() {
        System.out.println("substring");
        String inicio = "";
        String fin = "";
        BString instance = null;
        String expResult = "";
        String result = instance.substring(inicio, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substring method, of class BString.
     */
    @Test
    public void testSubstring_3args_1() {
        System.out.println("substring");
        int pos = 0;
        String inicio = "";
        String fin = "";
        BString instance = null;
        String expResult = "";
        String result = instance.substring(pos, inicio, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substring method, of class BString.
     */
    @Test
    public void testSubstring_3args_2() {
        System.out.println("substring");
        String inicio = "";
        String fin = "";
        int pos = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.substring(inicio, fin, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substring method, of class BString.
     */
    @Test
    public void testSubstring_4args() {
        System.out.println("substring");
        String inicio = "";
        String fin = "";
        int posI = 0;
        int posF = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.substring(inicio, fin, posI, posF);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substring method, of class BString.
     */
    @Test
    public void testSubstring_String() {
        System.out.println("substring");
        String Regex = "";
        BString instance = null;
        String expResult = "";
        String result = instance.substring(Regex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substring method, of class BString.
     */
    @Test
    public void testSubstring_String_int() {
        System.out.println("substring");
        String Regex = "";
        int find = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.substring(Regex, find);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_int_int() {
        System.out.println("removeString");
        int i = 0;
        int f = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(i, f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_int() {
        System.out.println("removeString");
        int i = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_String_String() {
        System.out.println("removeString");
        String inicio = "";
        String fin = "";
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(inicio, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_3args_1() {
        System.out.println("removeString");
        int pos = 0;
        String inicio = "";
        String fin = "";
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(pos, inicio, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_3args_2() {
        System.out.println("removeString");
        String inicio = "";
        String fin = "";
        int pos = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(inicio, fin, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_4args_1() {
        System.out.println("removeString");
        String inicio = "";
        String fin = "";
        int posI = 0;
        int posF = 0;
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(inicio, fin, posI, posF);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeString method, of class BString.
     */
    @Test
    public void testRemoveString_4args_2() {
        System.out.println("removeString");
        int posI = 0;
        int posF = 0;
        String inicio = "";
        String fin = "";
        BString instance = null;
        String expResult = "";
        String result = instance.removeString(posI, posF, inicio, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beforestring method, of class BString.
     */
    @Test
    public void testBeforestring() {
        System.out.println("beforestring");
        String separador = "";
        BString instance = null;
        String expResult = "";
        String result = instance.beforestring(separador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afterstring method, of class BString.
     */
    @Test
    public void testAfterstring() {
        System.out.println("afterstring");
        String separador = "";
        BString instance = null;
        String expResult = "";
        String result = instance.afterstring(separador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ContainsIgnoreCase method, of class BString.
     */
    @Test
    public void testContainsIgnoreCase() {
        System.out.println("ContainsIgnoreCase");
        String Contenido = "";
        BString instance = null;
        Boolean expResult = null;
        Boolean result = instance.ContainsIgnoreCase(Contenido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timesMatch method, of class BString.
     */
    @Test
    public void testTimesMatch() {
        System.out.println("timesMatch");
        String Regex = "";
        BString instance = null;
        int expResult = 0;
        int result = instance.timesMatch(Regex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NumDelete method, of class BString.
     */
    @Test
    public void testNumDelete() {
        System.out.println("NumDelete");
        BString instance = null;
        String expResult = "";
        String result = instance.NumDelete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUppercases method, of class BString.
     */
    @Test
    public void testGetUppercases() {
        System.out.println("getUppercases");
        BString instance = null;
        int expResult = 0;
        int result = instance.getUppercases();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
