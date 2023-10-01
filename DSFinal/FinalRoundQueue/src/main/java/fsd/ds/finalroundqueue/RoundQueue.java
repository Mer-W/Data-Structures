/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.finalroundqueue;

import java.util.Iterator;

/**
 *
 * @author mer
 * @param <T>
 */
public class RoundQueue<T extends Comparable> implements Iterable<T> {

    private class Node {

        T value;
        Node next;
        Node prev; // to enable grow
        int debugId; // optional, for debugging only
    }

    private Node enqueue, dequeue;
    private int size;
    private int maxSize; // maxSize is assigned in the constructor
    T[] template;

    public RoundQueue(int maxSize, T[] template) {

        if (maxSize < 1) { // prohibit instantiation with max size 0 or neg

            throw new IllegalArgumentException("max size must be greater than zero");
        }

        this.maxSize = maxSize;
        this.template = template;
        enqueue = dequeue = new Node();
        // * allocate maxSize of Nodes and as you're doing it
        // * link them up with next references
        // * point enqueue & dequeue to one of these nodes
        // 
        // Suggestion: for debugging purposes give each Node a debugId (0, 1, 2...)
        // so that when you're looking at data in memory or printing them out
        // you can tell which Node is which
        //
        // Suggestion: use debugger to verify that you ineed have linked up all nodes in a circle
        // before continuing with this task. If you did not then the rest of your code won't work.
        Node node = dequeue;
        for (int i = 0; i < maxSize - 1; i++) {

            node.debugId = i;
            node.next = new Node();
            node.next.prev = node;
            node = node.next;
        }
        node.debugId = maxSize - 1;
        node.next = dequeue;
        dequeue.prev = node;
    }

    public void printQueue() {
        // for debugging only but required as a part of your solution
        // print out each Node's content on a separate line
        // starting with eneuque reference, following next reference maxSize (or probably maxSize-1) times.
        // after the loop is done you should be back at eneuque - check that and if you're not
        // throw new RuntimeException("Internal error: queue may not be circular");
        // example line of output for node with debugId=2, value="Joe" (String type):
        // Node #0: Joe
        Node node = enqueue;
        for (int i = 0; i < maxSize; i++) {
            System.out.print("id: " + node.debugId + ", val: ");
            System.out.println(node.value != null ? node.value.toString() : "null");
            node = node.next;
        }
        // debug test reversal by prev chain
        /*
        node = enqueue;
        System.out.println("reversed (prev):");
        for (int i = 0; i < maxSize; i++) {
            System.out.print("id: " + node.debugId + ", val: ");
            System.out.println(node.value != null ? node.value.toString() : "null");
            node = node.prev;
        }
         */
    }

    // puts value into the queue
    // throws RuntimeException("No space in the queue") if queue is full
    // unless "grow" is set to true, in which case you can create a new Node so you can insert more than current maxSize
    // if you do - you need to update maxSize as well.
    public void enqueue(T value, boolean grow) {

        if (size == maxSize && grow == false) {

            throw new RuntimeException("queue is full");

        } else if (size == maxSize && grow == true) {

            Node newNode = new Node();
            newNode.value = value;
            newNode.debugId = maxSize;
            enqueue.prev.next = newNode;
            newNode.prev = enqueue.prev;
            newNode.next = enqueue;
            enqueue.prev = newNode;
            maxSize++;

        } else {

            enqueue.value = value;
            enqueue = enqueue.next;
        }
        size++;
    }

    // removes and returns value from the queue (in FIFO order)
    // throws RuntimeException("Queue is empty") if queue is empty
    // sets value reference to null of the Node whose value will be returned
    public T dequeue() {

        if (size == 0) {
            throw new RuntimeException("queue is empty");
        }

        T result = dequeue.value;
        dequeue.value = null;
        dequeue = dequeue.next;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    // returns array of "size" number of elements with most recently enqueued elements first (following "next" references)
    public T[] toArray() {

        if (size == 0) {
            throw new RuntimeException("queue is empty");
        }

        T[] result = (T[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);

        for (int i = 0; i < size; i++) {
            count = 0;
            Node node = getNode(dequeue, size - i);
            result[i] = node.value;
            // debug
            //System.out.println(result[i]);
        }
        return result;
    }

    // recursive helper method and field to get values in order without using prev references
    private int count;

    private Node getNode(Node node, int n) {

        count++;

        if (count == n) {

            return node;
        }

        return getNode(node.next, n);
    }

    // checks if value is present in Queue and returns the number of occurrences of that value (0 if not found)
    // must use n.compareTo(v) == 0, not equals()
    public int countValues(T value) {

        if (size == 0) {
            return 0;
        }

        int valCount = 0;
        Node node = dequeue;

        for (int i = 0; i < size; i++) {

            if (value.compareTo(node.value) == 0) {

                valCount++;
            }
            node = node.next;
        }
        return valCount;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            T[] values = toArray();

            int index = 0;

            @Override
            public boolean hasNext() {
                return (index < values.length);
            }

            @Override
            public T next() {
                return values[index++];
            }

        };
    }

}
