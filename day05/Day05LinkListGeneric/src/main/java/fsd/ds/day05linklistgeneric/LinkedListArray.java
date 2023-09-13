/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day05linklistgeneric;

/**
 *
 * @author mer
 */
public class LinkedListArray<T> {

    private class Container {

        Container next;
        T value;
    }

    private Container start, end;

    private int size = 0;

    public void add(T value) {

        Container elem = new Container();
        elem.value = value;

        if (size == 0) {

            start = end = elem;

        } else {

            end.next = elem;
            end = end.next;
        }
        size++;
    }

    public T get(int index) {

        checkIndex(index);

        Container elem = start;

        T result = null;

        for (int i = 0; i < size; i++) {

            if (i == index) {

                result = elem.value;
            }

            elem = elem.next;
        }

        return result;
    }

    public void insertValueAtIndex(T value, int index) {

        checkIndex(index);

        Container insert = new Container();
        insert.value = value;

        if (index == 0) {

            insert.next = start;

            start = insert;

        } else {

            Container elem = start;

            for (int i = 0; i < index; i++) {

                if (i == index - 1) {

                    insert.next = elem.next;

                    elem.next = insert;
                }

                elem = elem.next;
            }
        }  
               size++;
    }

    public void replaceValueAtIndex(T value, int index) {

        checkIndex(index);

        Container elem = start;

        for (int i = 0; i <= index; i++) {

            if (i == index) {

                elem.value = value;
            }

            elem = elem.next;
        }
    }

    public void deleteByIndex(int index) {

        checkIndex(index);

        Container elem = start;

        if (index == 0) {

            start = elem.next;

        } else {

            for (int i = 0; i < index; i++) {

                if (i == index - 1) {

                    elem.next = elem.next.next;
                }

                elem = elem.next;
            }
        }

        size--;

        checkDelete();
    }

    public boolean deleteByValue(T value) {

        Container elem = start;

        if (elem.value.equals(value)) {

            start = elem.next;

            size--;
            checkDelete();
            return true;

        } else {

            for (int i = -1; i < size - 1; i++) {

                if (elem.next != null && elem.next.value != null && elem.next.value.equals(value)) {

                    elem.next = elem.next.next;
                    
                    if (elem.next == null) {
                        
                        end = elem;
                    }
                    size--;
                    checkDelete();
                    return true;
                }
                elem = elem.next;
            }
        }
        return false;
    }

    public int getSize() {

        return size;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "";
        }

        StringBuilder str = new StringBuilder();

        Container elem = start;

        for (int i = 0; i < size; i++) {

            if (i != 0) {

                str.append(", ");
            }

            str.append(elem.value);

            elem = elem.next;
        }

        return str.toString();
    }

    public T[] toArray(T[] arr) {

        Container elem = start;

        for (int i = 0; i < size; i++) {

            arr[i] = elem.value;

            elem = elem.next;
        }

        System.out.println();

        return arr;
    }

    public void checkDelete() {

        if (size == 0) {

            start = null;
            end = null;
        }
    }

    public void checkIndex(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("index out of bounds!");
        }
    }
}
