/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.day02arraylistownimpl;

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
public class CustomArrayTest {
    
    public CustomArrayTest() {
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
     * Test of size method, of class CustomArray.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        CustomArray instance = new CustomArray();
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of add method, of class CustomArray.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int value = 0;
        CustomArray instance = new CustomArray();
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByIndex method, of class CustomArray.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        int index = 0;
        CustomArray instance = new CustomArray();
        instance.deleteByIndex(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByValue method, of class CustomArray.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        int value = 0;
        CustomArray instance = new CustomArray();
        boolean expResult = false;
        boolean result = instance.deleteByValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertValueAtIndex method, of class CustomArray.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        int value = 0;
        int index = 0;
        CustomArray instance = new CustomArray();
        instance.insertValueAtIndex(value, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CustomArray.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CustomArray instance = new CustomArray();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class CustomArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        CustomArray instance = new CustomArray();
        int expResult = 0;
        int result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSlice method, of class CustomArray.
     */
    @Test
    public void testGetSlice() {
        System.out.println("getSlice");
        int startIdx = 0;
        int length = 0;
        CustomArray instance = new CustomArray();
        int[] expResult = null;
        int[] result = instance.getSlice(startIdx, length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CustomArray.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CustomArray instance = new CustomArray();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sliceStr method, of class CustomArray.
     */
    @Test
    public void testSliceStr() {
        System.out.println("sliceStr");
        int[] slice = null;
        CustomArray instance = new CustomArray();
        String expResult = "";
        String result = instance.sliceStr(slice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
