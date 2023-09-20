/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.day10bintree;

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
public class BinaryTreeOfIntsTest {

    public BinaryTreeOfIntsTest() {
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
     * Test of put method, of class BinaryTreeOfInts.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        //int value = 0;
        BinaryTreeOfInts instance = new BinaryTreeOfInts();
        instance.put(0);
        instance.put(1);
        instance.put(5);
        instance.put(2);
        instance.put(7);
        assertEquals(5, instance.getSize());
        assertEquals(0, instance.getRootVal());

        assertThrows(IllegalArgumentException.class, () -> {
            instance.put(7);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            instance.put(0);
        });
    }

    /**
     * Test of getSize method, of class BinaryTreeOfInts.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        BinaryTreeOfInts instance = new BinaryTreeOfInts();
        instance.put(0);
        instance.put(1);
        instance.put(5);
        instance.put(2);
        instance.put(7);
        assertEquals(5, instance.getSize());
    }

    /**
     * Test of hasValue method, of class BinaryTreeOfInts.
     */
    @Test
    public void testHasValue() {
        System.out.println("hasValue");
        BinaryTreeOfInts instance = new BinaryTreeOfInts();
        instance.put(0);
        instance.put(1);
        instance.put(5);
        instance.put(2);
        instance.put(7);
        assertEquals(true, instance.hasValue(0));
        assertEquals(true, instance.hasValue(1));
        assertEquals(true, instance.hasValue(5));
        assertEquals(true, instance.hasValue(2));
        assertEquals(true, instance.hasValue(7));
        assertEquals(false, instance.hasValue(10));
        assertEquals(false, instance.hasValue(3));
    }

    /**
     * Test of getSumOfAllValues method, of class BinaryTreeOfInts.
     */
    @Test
    public void testGetSumOfAllValues() {
        System.out.println("getSumOfAllValues");
        BinaryTreeOfInts instance = new BinaryTreeOfInts();
        instance.put(0);
        instance.put(1);
        instance.put(5);
        instance.put(2);
        instance.put(7);
        int expResult = 15;
        int result = instance.getSumOfAllValues();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValuesInOrder method, of class BinaryTreeOfInts.
     */
    @Test
    public void testGetValuesInOrder() {
        System.out.println("getValuesInOrder");
        BinaryTreeOfInts instance = new BinaryTreeOfInts();
        instance.put(0);
        instance.put(1);
        instance.put(5);
        instance.put(2);
        instance.put(7);
        int[] expResult = {0, 1, 2, 5, 7};
        int[] result = instance.getValuesInOrder();
        assertArrayEquals(expResult, result);
    }

}
