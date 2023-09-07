/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day01arraycross;

/**
 *
 * @author mer
 */
public class Day01ArrayCross {

    public static void main(String[] args) {
        int[][] data2D = {
            {1, 3, 6, 8},
            {7, 1, 2, 3},
            {8, 3, 2, 1},
            {1, 7, 1, 9}
        };

        int[][] data2Djagged = {
            {1, 3, 6, 8, 9, 1},
            {7, 1, 2, 3},
            {8, 3, 2},
            {1, 7, 1, 9}
        };

        sumOfCross(data2D, 2, 6);
        
        print2D(data2Djagged);
    }

    static int getIfExists(int[][] data, int row, int col) {
        // If exists, return the element, otherwise return 0

        if (data.length >= row && data[row - 1].length >= col) {



            return data[row - 1][col - 1];

        } else {

            return 0;
        }

    }

    static int sumOfCross(int[][] data, int row, int col) {
        // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it
        int center = getIfExists(data, row, col);
        int top = getIfExists(data, row - 1, col);
        int bottom = getIfExists(data, row + 1, col);
        int left = getIfExists(data, row, col - 1);
        int right = getIfExists(data, row, col + 1);

        return center + top + bottom + left + right;

    }

    // useful helper for debugging
    static void print2D(int[][] data) {

        int longest = 1;

        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data[i].length; j++) {

                int value = data[i][j];
                int length = 0;
                long temp = 1;

                if (value < 0) {

                    temp = -1;

                    length = 1;

                    while (temp >= value) {
                        length++;
                        temp *= 10;
                    }

                } else if (value > 0) {

                    while (temp <= value) {
                        length++;
                        temp *= 10;
                    }
                }

                if (length > longest) {

                    longest = length;
                }
            }

        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {

                int value = data[i][j];
                int length = 0;
                long temp = 1;

                if (value < 0) {

                    temp = -1;

                    length = 1;

                    while (temp >= value) {
                        length++;
                        temp *= 10;
                    }

                } else if (value > 0) {

                    while (temp <= value) {
                        length++;
                        temp *= 10;
                    }
                }

                int diff = longest - length;

                for (int k = 0; k < diff; k++) {

                    System.out.print(" ");
                }

                System.out.print(value);

                if (j < data[i].length - 1) {

                    System.out.print(", ");

                } else {
                    System.out.print("\n");
                }
            }
        }

    
    }

     // duplicate a jagged array
    static int[][] duplicateEmptyArray2D(int[][] orig2d) {
        
        return orig2d;
    }
}
