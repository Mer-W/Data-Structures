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

    /**
     * Test of size method, of class CustomArray.
     */
    @Test
    public void testSize() {

        // test initial add
        System.out.println("size");
        CustomArray instance = new CustomArray();
        instance.add(4);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);

        // more adds
        instance.add(4);
        instance.add(4);
        expResult = 3;
        result = instance.size();
        assertEquals(expResult, result);

        // delete 1
        instance.deleteByIndex(0);
        expResult = 2;
        result = instance.size();
        assertEquals(expResult, result);

        // delete to size 1
        instance.deleteByIndex(0);
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

        // delete to size 0
        instance.deleteByIndex(0);

        expResult = 0;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class CustomArray.
     */
    @Test
    public void testAddLengthDoubled() {
        System.out.println("add");

        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(23);

        instance.add(2);

        // array length
        int expResult = 4;

        int result = instance.getData().length;
        assertEquals(expResult, result);
    }

    @Test
    public void testAddLengthNotDoubled() {
        System.out.println("add");

        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(23);

        // array length
        int expResult = 2;

        int result = instance.getData().length;
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteByIndex method, of class CustomArray.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");

        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(23);

        instance.add(2);
        instance.deleteByIndex(0);

        int[] expResult = {23, 2, 0, 0};

        int[] result = instance.getData();

        for (int i = 0; i < result.length; i++) {

            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of deleteByValue method, of class CustomArray.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(23);

        instance.add(2);
        instance.deleteByValue(2);

        int[] expResult = {23, 2, 0, 0};

        int[] result = instance.getData();

        for (int i = 0; i < result.length; i++) {

            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of insertValueAtIndex method, of class CustomArray.
     */
    @Test
    public void testInsertValueNotDoubled() {
        System.out.println("insertValueAtIndex");
        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(23);

        instance.add(2);
        instance.insertValueAtIndex(5, 0);

        int[] expResult = {5, 2, 23, 2};

        int[] result = instance.getData();

        for (int i = 0; i < result.length; i++) {

            assertEquals(expResult[i], result[i]);
        }
    }
    
        @Test
    public void testInsertValueDoubled() {
        System.out.println("insertValueAtIndex");
        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(23);
        instance.add(7);
        instance.add(2);
        instance.insertValueAtIndex(5, 0);

        int[] expResult = {5, 2, 23, 7, 2, 0, 0, 0};

        int[] result = instance.getData();

        for (int i = 0; i < result.length; i++) {

            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of get method, of class CustomArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        CustomArray instance = new CustomArray();
        instance.add(2);
        int expResult = 2;
        int result = instance.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSlice method, of class CustomArray.
     */
    @Test
    public void testGetSlice() {
        System.out.println("getSlice");
        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(5);
        instance.add(10);
        instance.add(28);
        instance.add(2);

        int[] expResult = {10, 28, 2};
        
        int[] result = instance.getSlice(2, 3);
        
        for (int i = 0; i < result.length; i++) {

            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of toString method, of class CustomArray.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(5);
        instance.add(10);
        instance.add(28);
        instance.add(2);

        String expResult = "2, 5, 10, 28, 2";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of sliceStr method, of class CustomArray.
     */
    @Test
    public void testSliceStr() {
        System.out.println("sliceStr");
  
        CustomArray instance = new CustomArray();
        instance.add(2);
        instance.add(5);
        instance.add(10);
        instance.add(28);
        instance.add(2);
        int[] slice = instance.getSlice(2, 3);

        String expResult = "10, 28, 2";
        String result = instance.sliceStr(slice);
        assertEquals(expResult, result);
    }

}
