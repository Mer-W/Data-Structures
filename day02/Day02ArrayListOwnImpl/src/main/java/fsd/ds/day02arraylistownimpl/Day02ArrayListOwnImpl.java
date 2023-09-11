/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day02arraylistownimpl;

/**
 *
 * @author mer
 */
public class Day02ArrayListOwnImpl {

    public static void main(String[] args) {

        CustomArray arr = new CustomArray();
 System.out.println(arr.size());
        arr.add(1);
         System.out.println(arr.size());
        arr.add(2);
         System.out.println(arr.size());
        arr.add(3);
         System.out.println(arr.size());
//        arr.add(4);
//         System.out.println("size: " + arr.size());
                  System.out.println("data.length: " + arr.getData().length);

                 System.out.println(arr.toString());

        
       int[] slice = arr.getSlice(2, 1);
        System.out.println(arr.sliceStr(slice));
        

        arr.insertValueAtIndex(30,2);
                System.out.println(arr.toString());


                arr.insertValueAtIndex(32,0);
                System.out.println(arr.toString());


        
        //arr.deleteByIndex(1);
                arr.deleteByValue(3);

                System.out.println(arr.toString());
                                                System.out.println(arr.size());

                
                             arr.deleteByValue(30);

                System.out.println(arr.toString());
                
                                System.out.println(arr.size());


    }
}
