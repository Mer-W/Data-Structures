/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.day10bintree;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mer
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
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
     * Test of put method, of class BinaryTree.
     */
    @Test
    public void testPutAndSize() {
        System.out.println("put");
        BinaryTree<String, Integer> instance = new BinaryTree<>();
        instance.put("a", 0);
        instance.put("c", 1);
        instance.put("b", 5);
        instance.put("d", 2);
        instance.put("e", 7);
        assertEquals(5, instance.getSize());
        instance.put("e", 8);
        assertEquals(5, instance.getSize());

    }

    /**
     * Test of getValByKey method, of class BinaryTree.
     */
    @Test
    public void testGetValByKey() {
        System.out.println("getValByKey");
        BinaryTree<String, Integer> instance = new BinaryTree<>();
        instance.put("a", 0);
        instance.put("c", 1);
        instance.put("b", 5);
        instance.put("d", 2);
        instance.put("e", 7);
        assertEquals(5, instance.getValByKey("b"));
        instance.put("e", 8);
        assertEquals(1, instance.getValByKey("c"));
    }

    /**
     * Test of printAllKeyValPairs method, of class BinaryTree.
     */
    @Test
    public void testPrintAllKeyValPairs() {
        System.out.println("printAllKeyValPairs");
        BinaryTree<String, Integer> instance = new BinaryTree<>();
        instance.put("a", 0);
        instance.put("c", 1);
        instance.put("b", 5);
        instance.put("d", 2);
        instance.put("e", 7);
        String exp = "\na => 0\n"
                + "c => 1\n"
                + "b => 5\n"
                + "d => 2\n"
                + "e => 7\n";
        //PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        instance.printAllKeyValPairs();
         assertEquals(exp, outputStreamCaptor.toString());
    }
    
    @Test
    public void testIterator() {
        BinaryTree<String, Integer> instance = new BinaryTree<>();
        instance.put("a", 0);
        instance.put("c", 1);
        instance.put("b", 5);
        instance.put("d", 2);
        instance.put("e", 7); 
                StringBuilder str = new StringBuilder();

        for (Pair item : instance) {

            str.append(item.key);
            str.append(" => ");
            str.append(item.val);
            str.append(" ");
        }
        String exp = "a => 0 "
                + "b => 5 "
                + "c => 1 "
                + "d => 2 "
                + "e => 7 ";
        String res = str.toString();
        assertEquals(exp, res);
    }
    
}
