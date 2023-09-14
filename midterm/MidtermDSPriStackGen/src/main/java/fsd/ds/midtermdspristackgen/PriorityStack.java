/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.midtermdspristackgen;

import java.util.Iterator;

/**
 *
 * @author mer
 */
public class PriorityStack<T> implements Iterable<T> {

    // you may add a constructor if you like (but I don't see why)
    private class Container {
// add a constructor and/or toString if you like

        T value;
        boolean hasPriority;
        Container nextBelow;
// you are NOT allowed to add "previousAbove" reference
    }

    private Container top; // top of the stack element

    private int size;

    private T[] template;

    public PriorityStack(T[] template) {
        this.template = template;
    }

    public void push(T value) {
        push(value, false);

    }

    public void push(T value, boolean hasPriority) {

        Container newItem = new Container();
        newItem.value = value;
        newItem.hasPriority = hasPriority;

        if (top != null) {

            newItem.nextBelow = top;

        }

        top = newItem;
        size++;
    }

    public T pop() {
        // remove and return the top item
        // if no item found (size == 0) then throw NoSuchElementException
        if (top == null) {

            throw new NoSuchElementException("no items found");
        }
        Container popped = top;
        top = top.nextBelow;
        size--;
        return popped.value;
    }

    public T popPriority() {
        // find an item with priority starting from the top, remove it and return it
        // if no priority item found then remove and return the top item
        // if stack is empty then throw NoSuchElementException
        if (top == null) {

            throw new NoSuchElementException("no items found");
        }

        if (top.hasPriority) {

            return pop();
        }

        Container item = top;

        for (int i = 0; i < size - 1; i++) {

            if (item.nextBelow.hasPriority) {

                Container popped = item.nextBelow;
                item.nextBelow = item.nextBelow.nextBelow;
                size--;
                return popped.value;
            }

            item = item.nextBelow;
        }

        return pop();

    }

    public int hasValue(T value) {
        // this code only looks for the *first* occurence of the value, starting from top
        // WARNING: you must call value.equals(item.value) to determine whether
        // two values are equal, just like you would do for a String
        // returning value 0 means the value is on top of the stack,
        // 1 means 1 below the top, and so on...
        // returns -1 if value is not on the stack

        Container item = top;

        for (int i = 0; i < size; i++) {

            if (item.value.equals(value)) {

                return i;
            }

            item = item.nextBelow;
        }
        return -1;
    }

    public T removeValue(T value) {
        // removes the first item from top containing the value and returns the value
        // if item with value is not found throw NoSuchElementException
        Container item = top;

        for (int i = 0; i < size - 1; i++) {

            if (i == 0 && item.value.equals(value)) {

                return pop();
            }

            if (item.nextBelow.value.equals(value)) {

                Container popped = item.nextBelow;
                item.nextBelow = item.nextBelow.nextBelow;
                size--;
                return popped.value;
            }

            item = item.nextBelow;
        }

        throw new NoSuchElementException("value not found");

    }

    public int getSize() {
        return size;
    }

    public void reorderByPriority() {
        // reorder items (re-create a new stack, if you like)
        // where all priority items are on top and non-priority items are below them
        // Note: order within the priority items group and non-priority items group must remain the same
        // Suggestion: instead of reordering the existing stack items
        // it may be easier to re-create a new stack with items in the order you need

        Container newTop = new Container();
        Container item = top;

        for (int i = 0; i < size; i++) {

            if (item.hasPriority) {

                newTop.value = item.value;
                newTop.hasPriority = item.hasPriority;
                item = item.nextBelow;

                break;
            }

            item = item.nextBelow;
        }

        Container newItem = newTop;

        for (int i = 0; i < size && item.nextBelow != null; i++) {

            if (item.hasPriority) {

                for (int j = 0; j < size; j++) {

                    if (newItem.nextBelow == null) {

                        newItem.nextBelow = new Container();
                        newItem.nextBelow.value = item.value;
                        newItem.nextBelow.hasPriority = item.hasPriority;

                        break;
                    }
                    newItem = newItem.nextBelow;
                }
            }

            item = item.nextBelow;
        }

        item = top;
        newItem = newTop;

        for (int i = 0; i < size; i++) {

            if (!item.hasPriority) {

                for (int j = 0; j < size; j++) {

                    if (newItem.nextBelow == null) {

                        newItem.nextBelow = new Container();
                        newItem.nextBelow.value = item.value;
                        newItem.nextBelow.hasPriority = item.hasPriority;

                        break;
                    }
                    newItem = newItem.nextBelow;
                }
            }

            item = item.nextBelow;
        }

        top = newTop;
    }

    @Override
    public String toString() {
        // return string describing the contents of the stack, starting from the top
        // Use value.toString() to conver values kept in the stack to strings.
        // Format exactly like this (assuming T is a String to keep it simple):
        // "[Jerry:N,Terry:N,Martha:P,Tom:P,Jimmy:N]" 
        // N means item has no priority, P means item has priority
        // For full marks you must use StringBuilder, no + (string concatenation) allowed.

        StringBuilder str = new StringBuilder();

        str.append("[");

        Container item = top;

        for (int i = 0; i < size; i++) {

            if (i != 0) {

                str.append(",");
            }

            str.append(item.value.toString());
            str.append(":");
            str.append(item.hasPriority ? "P" : "N");

            item = item.nextBelow;
        }

        str.append("]");

        return str.toString();

    }

// you may need these fields to implement toArrayReversed
    private T[] reversed;

    private int reversedCount;

    private Container getContainer(Container item, int n) {

        reversedCount++;

        if (reversedCount == n) {

            return item;
        }

        return getContainer(item.nextBelow, n);

    }

    public T[] toArrayReversed() { // Note: this is "the twist"
        // return array with items on the stack
        // WARNING: element 0 of the array must be the BOTTOM of the stack
        // NOTE: To obtain full marks for this method you must use recursion.
        // Collect items on your way back, just before returning from each method call.
        // This case is similar to when constructors of parent classes are called (Programming II course).
        T[] result = (T[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);

        for (int i = 0; i < size; i++) {

            reversedCount = 0;
            Container item = getContainer(top, size - i);

            result[i] = item.value;

        }

        return result;

    }

// NOTE: *ONLY* implement this method if you can't implement toArrayReversed.
// Make sure to add a unit test for it later.
    /*
    public T[] toArray() {

        //template = reversed;
        T[] result = (T[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);
        Container item = top;

        for (int i = 0; i < size; i++) {

            result[i] = item.value;

            item = item.nextBelow;
        }
        return result;
    }
*/

    // NOTE: you are only allowed to add private methods and private fields (if needed)
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            T[] values = toArrayReversed();
           // T[] values = toArray();

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
