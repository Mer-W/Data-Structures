/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fsd.ds.day05linklistgeneric;

import java.util.Arrays;

/**
 *
 * @author mer
 */
public class Day05LinkListGeneric {

    public static void main(String[] args) {
        
        // INTEGER
                        System.out.println("--------Integer instance--------");

        LinkedListArray<Integer> arr = new LinkedListArray<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        // toString
        System.out.println("toString: " + arr.toString());

        //size
        System.out.println("size: " + arr.getSize());

        //get
        System.out.println("get 0: " + arr.get(0));
        System.out.println("get 1: " + arr.get(1));

        System.out.println("get 2: " + arr.get(2));

        arr.insertValueAtIndex(5, 2);
        System.out.println("toString after insert 5 at 2: \n" + arr.toString());
        
        arr.replaceValueAtIndex(6, 2);
        System.out.println("toString after replace w/ 6 at 2: \n" + arr.toString());

        
        System.out.println("toArray: " + Arrays.toString(arr.toArray()));
        
        arr.deleteByIndex(2);
        System.out.println("toString after delete at 2: \n" + arr.toString());
                System.out.println("size: " + arr.getSize());
                
                        arr.deleteByIndex(3);
        System.out.println("toString after delete at 3: \n" + arr.toString());
                System.out.println("size: " + arr.getSize());

                arr.deleteByValue(1);
        System.out.println("toString after delete val 1: \n" + arr.toString());
                System.out.println("size: " + arr.getSize());

       
                     arr.deleteByValue(3);
        System.out.println("toString after delete val 3: \n" + arr.toString());
                System.out.println("size: " + arr.getSize());

                             arr.deleteByIndex(0);
        System.out.println("toString after delete at 0: \n" + arr.toString());
                System.out.println("size: " + arr.getSize());

        
        // STRING
        
                System.out.println("--------String instance--------");

        
        LinkedListArray<String> arrStr = new LinkedListArray<>();

        arrStr.add("hello 0");

        arrStr.add("hello 1");
        arrStr.add("hello 2");
        arrStr.add("hello 3");

        // toString
        System.out.println(arrStr.toString());

        //size
        System.out.println(arrStr.getSize());

        //get
        System.out.println(arrStr.get(0));
        System.out.println(arrStr.get(1));

        System.out.println(arrStr.get(2));

        arrStr.insertValueAtIndex("hello insert!", 2);
        System.out.println(arrStr.toString());
        
        arrStr.replaceValueAtIndex("hello replacement!", 2);
        System.out.println(arrStr.toString());
        
        System.out.println(Arrays.toString(arrStr.toArray()));
        
        arrStr.deleteByIndex(2);
        System.out.println(arrStr.toString());
        
                arrStr.deleteByValue("hello 1");
        System.out.println(arrStr.toString());
       
                     arrStr.deleteByValue("hello 3");
        System.out.println(arrStr.toString());
    }
}
