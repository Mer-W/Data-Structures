/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.midtermdspristackgen;

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
public class PriorityStackTest {

    public PriorityStackTest() {

    }

    // to make sure generic behaviour is well implemented we use this custom class
    class Person {

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;

        @Override
        public String toString() {
            return name + "^" + age;
        }

        @Override
        public boolean equals(Object obj) {
            Person other = (Person) obj;
            return name.equals(other.name) && (age == other.age);
        }

    }

    // For full marks: write at least 4 additional tests, as described below.
    // Midterm TODO: To obtain full marks for the task you must write at least
    // one test for every case where code will throw NoSuchElementException (3 cases, min 3 tests)
    // methods: pop() popPriority() removeValue()
    // also a test for Iterable/Iterator functionality
    // NOTE: These tests are accurate to the best of teacher's knowledge.
    // However, if something doesn't seem right with a test you must consult the teacher
    // *during* the midterm, not after.
    @Test
    public void PushTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4, instance.getSize());
        assertEquals("[Barry:N,Larry:P,Terry:N,Jerry:N]", instance.toString());
    }

    @Test
    public void PushPopTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4, instance.getSize());
        String res1 = instance.pop();
        assertEquals("Barry", res1);
        String res2 = instance.pop();
        assertEquals("Larry", res2);
        assertEquals("[Terry:N,Jerry:N]", instance.toString());
    }

    @Test
    public void PushPopPushTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4, instance.getSize());
        String res1 = instance.pop();
        assertEquals("Barry", res1);
        String res2 = instance.pop();
        assertEquals("Larry", res2);
        assertEquals(2, instance.getSize());
        assertEquals("[Terry:N,Jerry:N]", instance.toString());
        instance.push("Eva", true);
        instance.push("Martha");
        instance.push("Ruth");
        assertEquals(5, instance.getSize());
        assertEquals("[Ruth:N,Martha:N,Eva:P,Terry:N,Jerry:N]", instance.toString());
    }

    @Test
    public void PopPriorityTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4, instance.getSize());
        String res1 = instance.popPriority();
        assertEquals("Larry", res1);
        assertEquals(3, instance.getSize());
        String res2 = instance.popPriority();
        assertEquals("Barry", res2);
        assertEquals(2, instance.getSize());
        assertEquals("[Terry:N,Jerry:N]", instance.toString());
    }

    @Test
    public void PopPriorityTest2FromTop() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Barry");
        instance.push("Larry", true);
        assertEquals(4, instance.getSize());
        String res1 = instance.popPriority();
        assertEquals("[Barry:N,Terry:N,Jerry:N]", instance.toString());
    }

    @Test
    public void HasValueTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4, instance.getSize());
        assertEquals("[Barry:N,Larry:P,Terry:N,Jerry:N]", instance.toString());
        int res1 = instance.hasValue("Eva");
        assertEquals(-1, res1);
        int res2 = instance.hasValue("Terry");
        assertEquals(2, res2);
    }

    @Test
    public void HasValueRemoveValueTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        assertEquals(4, instance.getSize());
        assertEquals("[Barry:N,Larry:P,Terry:N,Jerry:N]", instance.toString());
        int res1 = instance.hasValue("Eva");
        assertEquals(-1, res1);
        int res2 = instance.hasValue("Terry");
        assertEquals(2, res2);
        String res3 = instance.removeValue("Jerry");
        assertEquals("Jerry", res3);
        String res4 = instance.removeValue("Barry");
        assertEquals("Barry", res4);
        String res5 = instance.pop();
        assertEquals("Larry", res5);
        String res6 = instance.pop();
        assertEquals("Terry", res6);
        assertEquals("[]", instance.toString());
        assertEquals(0, instance.getSize());
    }

    @Test
    public void ReorderByPriorityTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Jerry", false);
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        instance.push("Eva", true);
        instance.push("Martha");
        instance.push("Ruth");
        assertEquals(7, instance.getSize());
        instance.reorderByPriority();
        assertEquals("[Eva:P,Larry:P,Ruth:N,Martha:N,Barry:N,Terry:N,Jerry:N]", instance.toString());
        String res1 = instance.pop();
        assertEquals("Eva", res1);
        String res2 = instance.pop();
        assertEquals("Larry", res2);
        String res3 = instance.pop();
        assertEquals("Ruth", res3);
        assertEquals(4, instance.getSize());
        assertEquals("[Martha:N,Barry:N,Terry:N,Jerry:N]", instance.toString());
    }

    @Test
    public void CustomEqualsTest1() {
        PriorityStack<Person> instance = new PriorityStack<>(new Person[0]);
        instance.push(new Person("Jerry", 33));
        Person p1 = new Person("Maria", 22);
        instance.push(p1, true);
        instance.push(new Person("Tom", 44));
        instance.push(new Person("Eva", 55));
        assertEquals("[Eva^55:N,Tom^44:N,Maria^22:P,Jerry^33:N]", instance.toString());
        int res1 = instance.hasValue(new Person("Tom", 44));
        assertEquals(1, res1);
        Person res2 = instance.removeValue(new Person("Maria", 22));
        assertEquals(p1, res2); // this checks if p1.equals(res2) return true
        assertEquals(true, p1 == res2); // must return exactly the object that was originally pushed
    }

    // REMIDER: If you implemented toArray() but not toArrayReversed() then
// you must write your own unit test for that method or modify this one below
    @Test
    public void ReverseTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[]{});
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry");
        instance.push("Barry");
        Object[] result = instance.toArrayReversed();
        Object[] expected = {"Jerry", "Terry", "Larry", "Barry"};
        assertArrayEquals(expected, result);
    }

    /*
    @Test
    public void ArrayTest1() {
        PriorityStack<String> instance = new PriorityStack<>(new String[]{});
        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry");
        instance.push("Barry");
        String[] result = instance.toArray();
        String [] expected = {"Barry", "Larry", "Terry", "Jerry" };

        assertArrayEquals(expected, result);
    }
     */
    @Test
    public void RemoveValueEx() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);

        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            instance.removeValue("Barry");
        });

        String expRes = "value not found";
        String res = ex.getMessage();
        assertEquals(expRes, res);

        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry");

        ex = assertThrows(NoSuchElementException.class, () -> {
            instance.removeValue("Barry");
        });

        expRes = "value not found";
        res = ex.getMessage();
        assertEquals(expRes, res);

    }

    @Test
    public void ThrowExPopPriority() {

        PriorityStack<String> instance = new PriorityStack<>(new String[0]);

        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            instance.popPriority();
        });

        String expRes = "no items found";
        String res = ex.getMessage();
        assertEquals(expRes, res);

        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry");
        instance.pop();
        instance.pop();
        instance.pop();

        ex = assertThrows(NoSuchElementException.class, () -> {
            instance.popPriority();
        });

        expRes = "no items found";
        res = ex.getMessage();
        assertEquals(expRes, res);

    }

    @Test
    public void ThowExPop() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);

        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            instance.pop();
        });

        String expRes = "no items found";
        String res = ex.getMessage();
        assertEquals(expRes, res);

        instance.push("Jerry");
        instance.push("Terry");
        instance.push("Larry");
        instance.pop();
        instance.pop();
        instance.pop();

        ex = assertThrows(NoSuchElementException.class, () -> {
            instance.pop();
        });

        expRes = "no items found";
        res = ex.getMessage();
        assertEquals(expRes, res);

    }

    @Test
    public void Iterator() {
        PriorityStack<String> instance = new PriorityStack<>(new String[0]);
        instance.push("Terry");
        instance.push("Barry");
        instance.push("Martha");
        instance.push("Ruth");
        StringBuilder str = new StringBuilder();

        for (String value : instance) {

            str.append(value);
            str.append(" ");

        }

        String expRes = "Terry Barry Martha Ruth ";
        String res = str.toString();
        assertEquals(expRes, res);

    }

}
