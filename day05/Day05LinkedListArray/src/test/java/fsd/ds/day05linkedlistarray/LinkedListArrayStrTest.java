/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.day05linkedlistarray;

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
public class LinkedListArrayStrTest {

    public LinkedListArrayStrTest() {
    }

    /**
     * Test of add method, of class LinkedListArray.
     */
    @Test
    public void testAddSize() {
        System.out.println("add");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");

        // size
        int expRes = 1;
        int res = instance.getSize();
        assertEquals(expRes, res);

        instance.add("world");
        instance.add("hello world");
        expRes = 3;
        res = instance.getSize();
        assertEquals(expRes, res);
    }

    @Test
    public void testAddGetValues() {
        System.out.println("add");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");

        String expRes = "hello";
        String res = instance.get(0);
        assertEquals(expRes, res);

        instance.add("world");
        instance.add("hello world");
        expRes = "hello world";
        res = instance.get(2);
        assertEquals(expRes, res);
    }

    /**
     * Test of insertValueAtIndex method, of class LinkedListArray.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");

        instance.insertValueAtIndex("hello insert", 2);
        System.out.println("inserted 1");

//        String expRes = "hello, world, hello insert, hello world";
//        String res = instance.toString();
//        assertEquals(expRes, res);
//            System.out.println("asserted insert 1");


        instance.insertValueAtIndex("hello insert", 0);
                    System.out.println("inserted 2");


        String expRes = "hello insert, hello, world, hello insert, hello world";
        String res = instance.toString();
        assertEquals(expRes, res);

    }

    /**
     * Test of replaceValueAtIndex method, of class LinkedListArray.
     */
    @Test
    public void testReplaceValueAtIndex() {
        System.out.println("replaceValueAtIndex");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");

        instance.replaceValueAtIndex("world!!", 1);
        String expRes = "hello, world!!, hello world";
        String res = instance.toString();
        assertEquals(expRes, res);

        instance.replaceValueAtIndex("hello!!", 0);
        expRes = "hello!!, world!!, hello world";
        res = instance.toString();
        assertEquals(expRes, res);

        instance.replaceValueAtIndex("hello world!!", 2);
        expRes = "hello!!, world!!, hello world!!";
        res = instance.toString();
        assertEquals(expRes, res);
    }

    /**
     * Test of deleteByIndex method, of class LinkedListArray.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");

        instance.deleteByIndex(0);
        String expRes = "world, hello world";
        String res = instance.toString();
        assertEquals(expRes, res);

        instance.deleteByIndex(1);
        expRes = "world";
        res = instance.toString();
        assertEquals(expRes, res);

        instance.deleteByIndex(0);
        expRes = "";
        res = instance.toString();
        assertEquals(expRes, res);
    }

    /**
     * Test of deleteByValue method, of class LinkedListArray.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");

        instance.deleteByValue("hello");
        String expRes = "world, hello world";
        String res = instance.toString();
        assertEquals(expRes, res);

        instance.deleteByValue("hello world");
        expRes = "world";
        res = instance.toString();
        assertEquals(expRes, res);

        instance.deleteByValue("world");
        expRes = "";
        res = instance.toString();
        assertEquals(expRes, res);

    }

    /**
     * Test of getSize method, of class LinkedListArray.
     */
    @Test
    public void testGetDeleteSize() {
        System.out.println("getSize");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");

        instance.deleteByValue("hello");
        int expRes = 2;
        int res = instance.getSize();
        assertEquals(expRes, res);

        instance.deleteByValue("hello world");
        expRes = 1;
        res = instance.getSize();
        assertEquals(expRes, res);

        instance.deleteByValue("world");
        expRes = 0;
        res = instance.getSize();
        assertEquals(expRes, res);
    }

    /**
     * Test of toString method, of class LinkedListArray.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");
        String expResult = "hello, world, hello world";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toArray method, of class LinkedListArray.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");
        String[] expResult = {"hello", "world", "hello world"};
        String[] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testThrowEx() {
        LinkedListArrayStr instance = new LinkedListArrayStr();
        instance.add("hello");
        instance.add("world");
        instance.add("hello world");

        IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(3);
        });

        String expRes = "index out of bounds!";
        String res = ex.getMessage();
        assertEquals(expRes, res);

        ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.deleteByIndex(3);
        });

        expRes = "index out of bounds!";
        res = ex.getMessage();
        assertEquals(expRes, res);
        
        ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.insertValueAtIndex("hello", 3);
        });

        expRes = "index out of bounds!";
        res = ex.getMessage();
        assertEquals(expRes, res);
        
                ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.replaceValueAtIndex("hello", 3);
        });

        expRes = "index out of bounds!";
        res = ex.getMessage();
        assertEquals(expRes, res);
    }
}
