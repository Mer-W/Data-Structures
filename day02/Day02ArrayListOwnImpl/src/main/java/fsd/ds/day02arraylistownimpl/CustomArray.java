/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day02arraylistownimpl;

/**
 *
 * @author mer
 */
public class CustomArray {

    private int[] data = new int[2]; // only grows by doubling size, never shrinks
    private int size = 0; // how many items do you really have

    public int size() {
        return size;
    }

    public void add(int value) {

        if (size >= data.length) {

            int[] newArr;

            if (size == 0) {

                newArr = new int[4];

            } else {

                newArr = new int[size * 2];
            }

            for (int i = 0; i < size; i++) {

                newArr[i] = data[i];
            }

            data = newArr;

        }

        data[size] = value;

        size++;
    }

    public void deleteByIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds!");
        }

        size--;

        for (int i = 0; i < data.length - 1; i++) {

            if (i >= index) {

                data[i] = data[i + 1];
            }
        }
    }

    public boolean deleteByValue(int value) {  // delete first value matching, true if value found, false otherwise

        boolean found = false;

        for (int i = 0; i < size; i++) {

            if (data[i] == value) {

                found = true;

                deleteByIndex(i);

                break;
            }
        }

        return found;
    }

    public void insertValueAtIndex(int value, int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds!");
        }

        int[] newArr;
        
        size++;

        if (size >= data.length) {

            newArr = new int[size * 2];

        } else {

            newArr = data;
        }
        

        int temp1 = data[index];
        int temp2;

        for (int i = 0; i < size; i++) {

            if (i < index) {                // index < 3

                newArr[i] = data[i];        // no change

            } else if (i == index) {        // index 3

                newArr[i] = value;          // data[3] = 7

            } else {                        // index 4

                temp2 = data[i];            // save data[4] = 5                
                newArr[i] = temp1;         // data[4] = 4
                temp1 = temp2;
            }
        }

        data = newArr;
    }

    public void clear() {
        size = 0;
    }

    public int get(int index) { // may throw ArrayIndexOutOfBoundsException

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds!");

        }

        return data[index];
    }

    public int[] getSlice(int startIdx, int length) { // may throw ArrayIndexOutOfBoundsException

        if (startIdx < 0 || startIdx + length > size) {

            throw new IndexOutOfBoundsException("you may not slice beyond the bounds of your array!");
        }

        int[] slice = new int[length];

        for (int i = 0; i < slice.length; i++) {

            slice[i] = data[i + startIdx];
        }

        return slice;
    }

    @Override
    public String toString() {  // returns String similar to: [3, 5, 6, -23]

        StringBuilder str = new StringBuilder();

       // for (int i = 0; i < data.length; i++) {
            for (int i = 0; i < size; i++) {

            if (i > 0) {

                str.append(", ");
            }

            str.append(data[i]);
        }

        return str.toString();
    }

    public String sliceStr(int[] slice) {  // returns String similar to: [3, 5, 6, -23]

        StringBuilder str = new StringBuilder();

        // for (int i = 0; i < data.length; i++) {
        for (int i = 0; i < slice.length; i++) {

            if (i > 0) {

                str.append(", ");
            }

            str.append(slice[i]);
        }

        return str.toString();
    }
}
