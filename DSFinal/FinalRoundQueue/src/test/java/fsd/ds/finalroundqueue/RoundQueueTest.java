/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fsd.ds.finalroundqueue;

import java.util.Iterator;
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
public class RoundQueueTest {

    public RoundQueueTest() {
    }

    // class to test comparable objects
    class Car implements Comparable<Car> {

        private String makeModel;
        private double engineSizeL;
        private int prodYear;

        public Car(String makeModel, double engineSize, int prodYear) {
            this.makeModel = makeModel;
            this.engineSizeL = engineSize;
            this.prodYear = prodYear;
        }

        public String getMakeModel() {
            return makeModel;
        }

        public double getEngineSizeL() {
            return engineSizeL;
        }

        public int getProdYear() {
            return prodYear;
        }

        @Override
        public String toString() {
            return "Make and model: " + makeModel + "\n" + "Engine size: " + engineSizeL + "L\n" + "Year: " + prodYear + "\n\n";
        }

        @Override
        public int compareTo(Car car) {
            return makeModel.compareTo(car.getMakeModel());
        }
    }

    /**
     * Test of printQueue method, of class RoundQueue.
     */
    @Test
    public void testPrintQueue() {
        System.out.println("printQueue");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        instance.printQueue();
    }

    /**
     * Test of enqueue method, of class RoundQueue.
     */
    @Test
    public void testEnqueueInteger() {
        System.out.println("enqueue");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);

        instance.enqueue(5, false);
        instance.enqueue(7, false);
        assertEquals(2, instance.size());
        assertEquals(7, instance.toArray()[0]);
        assertEquals(5, instance.toArray()[1]);
        assertEquals(2, instance.toArray().length);

        instance.enqueue(9, false);
        instance.enqueue(2, false);
        instance.enqueue(4, false);
        assertEquals(5, instance.size());

        assertEquals(4, instance.toArray()[0]);
        assertEquals(2, instance.toArray()[1]);
        assertEquals(9, instance.toArray()[2]);
        assertEquals(7, instance.toArray()[3]);
        assertEquals(5, instance.toArray()[4]);
        assertEquals(5, instance.toArray().length);
    }

    /**
     * Test of enqueue method, of class RoundQueue.
     */
    @Test
    public void testEnqueueCar() {
        System.out.println("enqueue");
        RoundQueue<Car> instance = new RoundQueue(5, new Car[0]);
        Car car1 = new Car("Toyota Prius", 1.8, 2015);
        Car car2 = new Car("Toyota Corolla", 1.8, 2021);
        Car car3 = new Car("Kia Rio", 1.6, 2018);
        Car car4 = new Car("Honda Accord", 2.5, 2015);
        Car car5 = new Car("Honda Accord", 2.4, 2013);
        //Car car6 = new Car("Honda Civic", 1.5, 2017);
        //Car car7 = new Car("Honda Accord", 2.5, 2017);
        instance.enqueue(car1, false);
        instance.enqueue(car2, false);
        assertEquals(2, instance.size());
        assertEquals(car2, instance.toArray()[0]);
        assertEquals(car1, instance.toArray()[1]);
        assertEquals(2, instance.toArray().length);

        instance.enqueue(car3, false);
        instance.enqueue(car4, false);
        instance.enqueue(car5, false);

        assertEquals(car5, instance.toArray()[0]);
        assertEquals(car4, instance.toArray()[1]);
        assertEquals(car3, instance.toArray()[2]);
        assertEquals(car2, instance.toArray()[3]);
        assertEquals(car1, instance.toArray()[4]);
        assertEquals(5, instance.toArray().length);
    }

    /**
     * Test of enqueue method with grow == true and full queue .
     */
    @Test
    public void testGrow() {
        System.out.println("enqueue grow");
        RoundQueue<Integer> instance = new RoundQueue(2, new Integer[0]);
        instance.enqueue(5, true);
        instance.enqueue(7, false);
        instance.enqueue(9, true);
        instance.enqueue(2, true);
        instance.enqueue(4, true);
        instance.enqueue(6, true);
        assertEquals(6, instance.size());
        instance.enqueue(6, true);
        assertEquals(7, instance.size());
    }

    /**
     * Test of enqueue method with grow == false and full queue .
     */
    @Test
    public void testFullExc() {
        System.out.println("enqueue full exc");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        instance.enqueue(5, false);
        instance.enqueue(7, false);
        instance.enqueue(9, false);
        instance.enqueue(2, false);
        instance.enqueue(4, false);
        assertThrows(RuntimeException.class, () -> {
            instance.enqueue(6, false);
        });
    }

    /**
     * Test of dequeue method, of class RoundQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        instance.enqueue(5, false);
        instance.enqueue(7, false);
        instance.enqueue(9, false);
        instance.enqueue(2, false);

        assertEquals(5, instance.dequeue());
        assertEquals(3, instance.size());

        assertEquals(7, instance.dequeue());
        assertEquals(2, instance.size());

        assertEquals(9, instance.dequeue());
        assertEquals(1, instance.size());

        assertEquals(2, instance.dequeue());
        assertEquals(0, instance.size());

        instance.enqueue(4, false);
        assertEquals(1, instance.size());
    }

    /**
     * Test of dequeue method, of class RoundQueue.
     */
    @Test
    public void testDequeueEmptyExc() {
        System.out.println("dequeue on empty");

        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        assertThrows(RuntimeException.class, () -> {
            instance.dequeue();
        });

        instance.enqueue(5, false);
        instance.enqueue(7, false);
        instance.enqueue(9, false);
        instance.enqueue(2, false);

        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();

        assertThrows(RuntimeException.class, () -> {
            instance.dequeue();
        });
    }

    /**
     * Test of size method, of class RoundQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);

        assertEquals(0, instance.size());

        instance.enqueue(5, false);
        assertEquals(1, instance.size());

        instance.enqueue(7, false);
        assertEquals(2, instance.size());

        instance.enqueue(9, false);
        assertEquals(3, instance.size());

        instance.dequeue();
        assertEquals(2, instance.size());

        instance.dequeue();
        assertEquals(1, instance.size());

        instance.dequeue();
        assertEquals(0, instance.size());
    }

    /**
     * Test of exception for bad size instantiation.
     */
    @Test
    public void testInvalidNewExc() {
        System.out.println("invalid intantiation");

        assertThrows(IllegalArgumentException.class, () -> {
            RoundQueue<Integer> instance = new RoundQueue(0, new Integer[0]);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            RoundQueue<Integer> instance = new RoundQueue(-1, new Integer[0]);
        });
    }

    /**
     * Test of toArray method, of class RoundQueue.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);

        instance.enqueue(5, false);
        instance.enqueue(7, false);
        instance.enqueue(9, false);

        Integer[] arr = instance.toArray();
        assertEquals(3, arr.length);
        assertEquals(9, arr[0]);
        assertEquals(7, arr[1]);
        assertEquals(5, arr[2]);
    }

    /**
     * Test of toArray method on empty queue, of class RoundQueue.
     */
    @Test
    public void testToArrayEmptyExc() {
        System.out.println("toArray");
        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        assertThrows(RuntimeException.class, () -> {
            instance.toArray();
        });
    }

    /**
     * Test of countValues method, of class RoundQueue.
     */
    @Test
    public void testCountValuesInteger() {
        System.out.println("countValues");

        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        instance.enqueue(5, false);
        instance.enqueue(7, false);
        instance.enqueue(9, false);

        assertEquals(1, instance.countValues(5));
        assertEquals(1, instance.countValues(9));
        assertEquals(0, instance.countValues(1));

        instance.enqueue(5, false);
        assertEquals(2, instance.countValues(5));
    }

    /**
     * Test of countValues method, of class RoundQueue.
     */
    @Test
    public void testCountValuesCar() {
        System.out.println("countValues");
        RoundQueue<Car> instance = new RoundQueue(5, new Car[0]);
        Car car1 = new Car("Toyota Prius", 1.8, 2015);
        Car car2 = new Car("Toyota Corolla", 1.8, 2021);
        Car car3 = new Car("Kia Rio", 1.6, 2018);
        Car car4 = new Car("Honda Accord", 2.5, 2015);
        Car car5 = new Car("Honda Accord", 2.4, 2013);
        Car car6 = new Car("Honda Civic", 1.5, 2017);
        Car car7 = new Car("Honda Accord", 2.5, 2017);
        instance.enqueue(car1, true);
        instance.enqueue(car2, false);
        instance.enqueue(car3, false);
        instance.enqueue(car4, false);
        instance.enqueue(car5, false);
        instance.enqueue(car6, true);
        instance.enqueue(car7, true);

        assertEquals(1, instance.countValues(car1));
        assertEquals(3, instance.countValues(car4));
        assertEquals(0, instance.countValues(new Car("Toyota Camry", 2.2, 2001)));
    }

    /**
     * Test of iterator method, of class RoundQueue.
     */
    @Test
    public void testIteratorInteger() {
        System.out.println("iterator");

        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        instance.enqueue(5, false);
        instance.enqueue(7, false);
        instance.enqueue(9, false);

        StringBuilder str = new StringBuilder();
        int countItr = 0;
        int countVal = 0;
        for (Integer value : instance) {
            
            if (value != null) {
            str.append(value.toString());
            str.append(" ");
            countVal++;
            }
            countItr++;
        }

        String expRes = "9 7 5 ";
        String res = str.toString();
        assertEquals(expRes, res);
        assertEquals(3, countItr);
        assertEquals(3, countVal);

    }

    /**
     * Test of iterator method, of class RoundQueue.
     */
    @Test
    public void testIteratorCar() {
        System.out.println("iterator");

        RoundQueue<Car> instance = new RoundQueue(5, new Car[0]);
        Car car1 = new Car("Toyota Prius", 1.8, 2015);
        Car car2 = new Car("Toyota Corolla", 1.8, 2021);
        Car car3 = new Car("Kia Rio", 1.6, 2018);
        Car car4 = new Car("Honda Accord", 2.5, 2015);
        Car car5 = new Car("Honda Accord", 2.4, 2013);
        instance.enqueue(car1, true);
        instance.enqueue(car2, false);
        instance.enqueue(car3, false);
        instance.enqueue(car4, false);
        instance.enqueue(car5, false);

        StringBuilder str = new StringBuilder();
        int count = 0;
        for (Car value : instance) {

            str.append(value.prodYear);
            str.append(" ");
            count++;
        }

        String expRes = "2013 2015 2018 2021 2015 ";
        String res = str.toString();
        assertEquals(expRes, res);
        assertEquals(5, count);
    }

    /**
     * Test of iterator method on empty queue, of class RoundQueue.
     */
    @Test
    public void testIteratorEmptyExc() {
        System.out.println("iterator");

        RoundQueue<Integer> instance = new RoundQueue(5, new Integer[0]);
        assertThrows(RuntimeException.class, () -> {

            int count = 0;
            for (Integer value : instance) {
                count++;
            }
        });

    }
}
