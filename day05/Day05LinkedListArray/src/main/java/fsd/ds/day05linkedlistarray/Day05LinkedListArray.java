/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day05linkedlistarray;

/**
 *
 * @author mer
 */
public class Day05LinkedListArray {

    public static void main(String[] args) {

        LinkedListArrayStr arr = new LinkedListArrayStr();

        arr.add("hello 0");

        arr.add("hello 1");
        arr.add("hello 2");
        arr.add("hello 3");

        // toString
        System.out.println(arr.toString());

        //size
        System.out.println(arr.getSize());

        //get
        System.out.println(arr.get(0));
        System.out.println(arr.get(1));

        System.out.println(arr.get(2));

        arr.insertValueAtIndex("hello insert!", 2);
        System.out.println(arr.toString());
        
        arr.replaceValueAtIndex("hello replacement!", 2);
        System.out.println(arr.toString());
        
        arr.toArray();
        
        arr.deleteByIndex(2);
        System.out.println(arr.toString());
        
                arr.deleteByValue("hello 1");
        System.out.println(arr.toString());
       
                     arr.deleteByValue("hello 3");
        System.out.println(arr.toString());

    }
}
