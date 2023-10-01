/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.day12doublylinkedlist;

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
public class LLDoubleTest {

    public LLDoubleTest() {
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
     * Test of getSize method, of class LLDouble.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        // LLDouble<Integer> instance = new LLDouble<>();
        LLDouble<String> instance = new LLDouble<>();

        instance.addStart("hello");
        instance.addStart("hello2");
        instance.addStart("hello3");
        int result = instance.getSize();
        assertEquals(3, result);
    }

    /**
     * Test of addBeg method, of class LLDouble.
     */
    @Test
    public void testAddEnd() {
        System.out.println("addEnd");
        LLDouble<String> instance = new LLDouble<>();
        instance.addEnd("hello");
        instance.addEnd("hello2");
        instance.addEnd("hello3");
        String result = instance.toString();
        assertEquals("hello, hello2, hello3", result);
    }

    /**
     * Test of addEnd method, of class LLDouble.
     */
    @Test
    public void testAddStart() {
        System.out.println("addBeg");
        LLDouble<String> instance = new LLDouble<>();
        instance.addStart("hello");
        instance.addStart("hello2");
        instance.addStart("hello3");
        String result = instance.toString();
        assertEquals("hello3, hello2, hello", result);
    }

    /**
     * Test of get method, of class LLDouble.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        LLDouble<String> instance = new LLDouble<>();
        instance.addEnd("hello");
        instance.addEnd("hello2");
        instance.addEnd("hello3");

        String result = instance.get(0);
        assertEquals("hello", result);
        result = instance.get(1);
        assertEquals("hello2", result);
        result = instance.get(2);
        assertEquals("hello3", result);

        instance.addEnd("hello4");
        result = instance.get(3);
        assertEquals("hello4", result);
    }

    /**
     * Test of insertAt method, of class LLDouble.
     */
    @Test
    public void testInsertAt() {
        System.out.println("insertAt");
        LLDouble<String> instance = new LLDouble<>();
        instance.addEnd("hello");
        instance.addEnd("hello2");
        instance.addEnd("hello3");

        instance.insertAt("insert", 0);
        assertEquals("insert", instance.get(0));
        assertEquals("hello", instance.get(1));

        instance.insertAt("insert2", 1);
        assertEquals("insert2", instance.get(1));
        assertEquals("hello", instance.get(2));
        assertEquals("hello2", instance.get(3));

        instance.insertAt("insert3", 4);
        assertEquals("insert3", instance.get(4));
        assertEquals("hello2", instance.get(3));
        assertEquals("hello3", instance.get(5));

    }

    /**
     * Test of replaceAt method, of class LLDouble.
     */
    @Test
    public void testReplaceAt() {
        System.out.println("replaceAt");
        LLDouble<String> instance = new LLDouble<>();
        instance.addEnd("hello");
        instance.addEnd("hello2");
        instance.addEnd("hello3");
        instance.replaceAt("replace0", 0);
                assertEquals("replace0", instance.get(0));


    }

    /**
     * Test of removeBeg method, of class LLDouble.
     */
    @Test
    public void testRemoveBeg() {
        System.out.println("removeBeg");
        LLDouble instance = new LLDouble();
        instance.removeBeg();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEnd method, of class LLDouble.
     */
    @Test
    public void testRemoveEnd() {
        System.out.println("removeEnd");
        Object val = null;
        LLDouble instance = new LLDouble();
        instance.removeEnd(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAt method, of class LLDouble.
     */
    @Test
    public void testDeleteAt() {
        System.out.println("deleteAt");
        int index = 0;
        LLDouble instance = new LLDouble();
        instance.deleteAt(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVal method, of class LLDouble.
     */
    @Test
    public void testDeleteVal() {
        System.out.println("deleteVal");
        Object val = null;
        LLDouble instance = new LLDouble();
        boolean expResult = false;
        boolean result = instance.deleteVal(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkDelete method, of class LLDouble.
     */
    @Test
    public void testCheckDelete() {
        System.out.println("checkDelete");
        LLDouble instance = new LLDouble();
        instance.checkDelete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class LLDouble.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        LLDouble instance = new LLDouble();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIndex method, of class LLDouble.
     */
    @Test
    public void testCheckIndex() {
        System.out.println("checkIndex");
        int index = 0;
        LLDouble instance = new LLDouble();
        instance.checkIndex(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
