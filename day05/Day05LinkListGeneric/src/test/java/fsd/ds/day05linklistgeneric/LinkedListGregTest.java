/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.day05linklistgeneric;

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
public class LinkedListGregTest {
    

    class Person {

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        String name;
        int age;

        @Override
        public String toString() {
            return String.format("Person(%s,%d)", name, age);
        }
        
        @Override
        public boolean equals(Object o) {
            Person p = (Person) o;
            return (p.name.equals(name) && (p.age == age));
        }
        
    }
    
    @Test
    public void testAddToStringToArray() {
        System.out.println("add toString toArray");
        LinkedListGreg<Person> instance = new LinkedListGreg<>();
        instance.add(new Person("Jerry", 33));
        instance.add(new Person("Terry", 23));
        instance.add(new Person("Barry", 55));
        assertEquals(3, instance.getSize());
        assertEquals("[Person(Jerry,33),Person(Terry,23),Person(Barry,55)]", instance.toString());
    }
    
    @Test
    public void testToArray() {
        System.out.println("add toString toArray");
        Person[] expected = { new Person("Jerry", 33),
                            new Person("Terry", 23),
                            new Person("Barry", 55)};
        LinkedListGreg<Person> instance = new LinkedListGreg<>();
        instance.add(new Person("Jerry", 33));
        instance.add(new Person("Terry", 23));
        instance.add(new Person("Barry", 55));
        //Person[] arrayResult = instance.toArray(new Person[0]);
        Object[] arrayResult = instance.toArray(new Person[0]);
        // NOTE: this requires equals() to be correctly defined in Person
        assertArrayEquals(expected, arrayResult);
    }
}
