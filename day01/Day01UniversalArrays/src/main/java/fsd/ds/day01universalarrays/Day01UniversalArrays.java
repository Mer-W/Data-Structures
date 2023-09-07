/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day01universalarrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mer
 */
public class Day01UniversalArrays {

    public static void main(String[] args) {

        int rowCount;
        int columnCount;

        int[] a1 = new int[]{1, 2, 4, 5, 3, 10};
        int[] a2 = new int[]{3, 3, 4, 7, 9, 10, 8};

        int[][] a3 = {
            {1, 6, 8},
            {7, 1, 2, 3},
            {3, 2, -99},
            {1, 7, 7, 88, 3}
        };

        int[][] a4 = {
            {1, 377, 8},
            {7, 3, 5},
            {8, -99},
            {17, 6}
        };

        //   findDuplicates(a1, a2);
        // printAutoCol(a3);
        // printArray(a2);
        // printArray(findDuplicates(a1, a2));
       printArray(findDuplicates(a3, a4));
  


        /*
        try {

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter number of rows:");

            rowCount = scan.nextInt();

            while (rowCount <= 0) {

                System.out.println("Try an integer greater than zero.");

                System.out.println("Enter number of rows:");

                rowCount = scan.nextInt();

            }

            if (rowCount == 1) {

                System.out.println("Enter number of columns: ");

                columnCount = scan.nextInt();

                while (columnCount <= 0) {

                    System.out.println("Try an integer greater than zero.");

                    System.out.println("Enter number of columns: ");

                    columnCount = scan.nextInt();
                }

                int[] array = new int[columnCount];

                inputArray(array, scan);

            } else {

                int[][] array = new int[rowCount][];
                inputArray(array, scan);
            }

            scan.close();

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Try again.");
        }
         */
    }

    static void inputArray(int[] array, Scanner scan) { // single dimensional

        int columnCount;

        for (int i = 0; i < array.length; i++) {

            System.out.println("Enter value for  column " + (i + 1) + ":");

            array[i] = scan.nextInt();
        }

        printArray(array);
    }

    static void inputArray(int[][] array, Scanner scan) {

        int columnCount;

        for (int i = 0; i < array.length; i++) {

            System.out.println("Enter number of columns for row " + (i + 1) + ":");

            columnCount = scan.nextInt();

            while (columnCount <= 0) {

                System.out.println("Try an integer greater than zero.");

                System.out.println("Enter number of columns: ");

                columnCount = scan.nextInt();
            }

            array[i] = new int[columnCount];

            for (int j = 0; j < array[i].length; j++) {

                System.out.println("Enter value for row " + (i + 1) + ", column " + (j + 1) + ":");

                array[i][j] = scan.nextInt();

            }
        }

        printArray(array);
    }

    static void printArray(int[] array) { // print on a single line, comma-separated

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);

            if (i < array.length - 1) {

                System.out.print(", ");
            }
        }
    }

    static void printArray(int[][] array) { // could be a *jagged* array

        int longest = 1;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                int value = array[i][j];
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

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                int value = array[i][j];
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

                if (j < array[i].length - 1) {

                    System.out.print(", ");

                } else {
                    System.out.print("\n");
                }
            }
        }

    }

    static void printAutoCol(int[][] array) {

        int rowWidth = array[0].length;

        for (int i = 0; i < array.length; i++) {

            if (array[i].length > rowWidth) {

                rowWidth = array[i].length;
            }
        }
        //  System.out.println("row length: " + rowWidth);

        int[] colWidths = new int[rowWidth];
        for (int col : colWidths) {
            col = 1;
        }

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                int value = array[i][j];
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

                if (length > colWidths[j]) {

                    colWidths[j] = length;
                }

            }

        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                int value = array[i][j];
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

                int diff = colWidths[j] - length;

                for (int k = 0; k < diff; k++) {

                    System.out.print(" ");
                }

                System.out.print(value);

                if (j < array[i].length - 1) {

                    System.out.print(", ");

                } else {
                    System.out.print("\n");
                }

            }
        }

    }

    static int[] findDuplicates(int[] a1, int[] a2) {
        int shortest;
        if (a1.length <= a2.length) {

            shortest = a1.length;

        } else {
            shortest = a2.length;
        }
        int[] duplicates = new int[shortest];
        int dupIndex = 0;
        for (int i : a1) {
            for (int j : a2) {

                if (i == j) {

                    int temp = 0;

                    for (int k : duplicates) {

                        if (i == k) {

                            temp++;
                            break;
                        }
                    }

                    if (temp == 0) {

                        duplicates[dupIndex] = i;
                        dupIndex++;
                    }
                }
            }
        }

        int[] duplicatesFinal = new int[dupIndex];

        for (int i = 0; i < duplicatesFinal.length; i++) {

            duplicatesFinal[i] = duplicates[i];
        }
        return duplicatesFinal;
    }

    static int[] findDuplicates(int[][] a1, int[][] a2) {

        int a1Max = 0;
        int a2Max = 0;

        int a1Count = 0;
        int a2Count = 0;

        for (int i = 0; i < a1.length; i++) {
            a1Max += a1[i].length;

        }
        for (int i = 0; i < a2.length; i++) {
            a2Max += a2[i].length;
        }

        int[] a1Vals = new int[a1Max];
        int[] a2Vals = new int[a2Max];
        
        for (int i = 0; i < a1.length; i++) {

            for (int j = 0; j < a1[i].length; j++) {


                int temp = 0;

                for (int k : a1Vals) {

                    if (a1[i][j] == k) {

                        temp++;
                        break;
                    }
                }
                
                if (temp == 0) {

                    a1Vals[a1Count] = a1[i][j];
                    a1Count++;
                }
            }
        }

        for (int i = 0; i < a2.length; i++) {
            
            for (int j = 0; j < a2[i].length; j++) {

                int temp = 0;

                for (int k : a2Vals) {

                    if (a2[i][j] == k) {

                        temp++;
                        break;
                    }
                }
                
                if (temp == 0) {

                    a2Vals[a2Count] = a2[i][j];
                    a2Count++;
                }
            }
        }

        int[] a1ValsFinal = new int[a1Count];

        for (int i = 0; i < a1ValsFinal.length; i++) {

            a1ValsFinal[i] = a1Vals[i];
        }

        
        int[] a2ValsFinal = new int[a2Count];

        for (int i = 0; i < a2ValsFinal.length; i++) {

            a2ValsFinal[i] = a2Vals[i];
        }

        return findDuplicates(a1ValsFinal, a2ValsFinal);
    }
}
