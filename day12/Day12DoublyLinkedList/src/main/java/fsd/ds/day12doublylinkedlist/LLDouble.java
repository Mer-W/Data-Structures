/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day12doublylinkedlist;

/**
 *
 * @author mer
 */
public class LLDouble<T> {

    private class Container {

        Container next;
        Container prev;
        T val;
    }

    private Container start, end;
    private int size;

    public int getSize() {
        return size;
    }

    public void addStart(T val) {

        Container newStart = new Container();
        newStart.val = val;

        if (size == 0) {
            start = end = newStart;
        } else {

            start.prev = newStart;
            newStart.next = start;
            start = newStart;
        }

        size++;
    }

    public void addEnd(T val) {

        Container newEnd = new Container();
        newEnd.val = val;

        if (size == 0) {
            start = end = newEnd;

        } else {

            newEnd.prev = end;
            end.next = newEnd;
            end = newEnd;
        }

        size++;
    }

    public T get(int index) {

        checkIndex(index);
        T result = null;

        if (index < size / 2) {

            Container elem = start;

            for (int i = 0; i < size / 2; i++) {

                if (i == index) {

                    result = elem.val;
                    break;
                }

                elem = elem.next;
            }

        } else {

            Container elem = end;

            for (int i = size - 1; i >= size / 2; i--) {

                if (i == index) {

                    result = elem.val;
                    break;
                }

                elem = elem.prev;
            }
        }
        return result;
    }

    public void insertAt(T val, int index) {

        checkIndex(index);

        if (index == 0) {
            addStart(val);
            return;
        }

        Container newElem = new Container();
        newElem.val = val;

        if (index < size / 2) {

            Container elem = start.next;

            for (int i = 1; i < size / 2; i++) {

                if (i == index) {

                    elem.prev.next = newElem;
                    newElem.prev = elem.prev;
                    newElem.next = elem;
                    elem.prev = newElem;
                    break;
                }

                elem = elem.next;
            }

        } else {

            Container elem = end;

            for (int i = size - 1; i >= size / 2; i--) {

                if (i == index) {

                    elem.prev.next = newElem;
                    newElem.prev = elem.prev;
                    newElem.next = elem;
                    elem.prev = newElem;
                    break;
                }

                elem = elem.prev;
            }
        }
        size++;
    }

    public void replaceAt(T val, int index) {

        if (index < size / 2) {

            Container elem = start;

            for (int i = 0; i < size / 2; i++) {

                if (i == index) {

                    elem.val = val;
                    break;
                }

                elem = elem.next;
            }

        } else {

            Container elem = end;

            for (int i = size - 1; i >= size / 2; i--) {

                if (i == index) {

                    elem.val = val;
                    break;
                }

                elem = elem.prev;
            }
        }

    }

    public void removeBeg() {

    }

    public void removeEnd(T val) {

    }

    public void deleteAt(int index) {

    }

    public boolean deleteVal(T val) {
        return false;
    }

    public void checkDelete() {

        if (size == 0) {

            start = null;
            end = null;
        }
    }

    @Override
    public String toString() {

        if (size == 0) {
            return null;
        }

        StringBuilder str = new StringBuilder();
        Container elem = start;

        for (int i = 0; i < size; i++) {
            str.append(i == 0 ? "" : ", ");

            str.append(elem.val.toString());

            elem = elem.next;
        }

        return str.toString();
    }

    public T[] toArray() {
        return null;
    }

    public void checkIndex(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("index out of bounds!");
        }
    }
}
