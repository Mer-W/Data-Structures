/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fsd.ds.day06hashmapgeneric;

import java.util.Arrays;

/**
 *
 * @author mer
 */
public class Day06HashMapGeneric {

    public static void main(String[] args) {



        HashMapGeneric<String, String> map = new HashMapGeneric<>();

        
        map.putValue("Buster", "yorkie-poo");
        map.putValue("Momo", "yorkie-poo");
        map.putValue("Mischa", "chi mutt");
        map.putValue("Bijou", "poodle");
        map.putValue("Violette", "border collie");
        map.putValue("Coco", "poodle");
        map.putValue("Mischa", "chi mutt");
        map.putValue("Bijou", "poodle");
        map.putValue("Mimi", "bichon");
        map.putValue("Billie", "yorkie");
        map.putValue("Peach", "papillon");
        map.putValue("Polly", "chihuahua");
        map.putValue("Rolo", "pitty");
        map.putValue("Ryan", "pitty");

        // to string
        System.out.println("\n" + map.toString());

        // all keys
        System.out.println("\n" + Arrays.toString(map.getAllKeys(new String[] {})));

        // get size
        System.out.println("size: " + map.getSize());

        // put until resize
        map.putValue("Choco", "cat");
        map.putValue("Vinny", "border collie");
        map.putValue("Dede", "yorkie");
        map.putValue("Bruce", "cat");
//        map.putValue("Francis", "unknown");

        // to string
        System.out.println(map.toString());

        // all keys
        System.out.println("\n" + Arrays.toString(map.getAllKeys(new String[] {})));

        // get size
        System.out.println("size: " + map.getSize());

        // has key
        System.out.println(map.hasKey("Buster"));
        System.out.println(map.hasKey("Busther"));

        // get value
        try {
            System.out.println(map.getValue("Buster"));

        } catch (KeyNotFoundException e) {

            System.out.println(e.getMessage());
        }
        try {

            System.out.println(map.getValue("Busther"));
        } catch (KeyNotFoundException e) {
        }

        // delete from middle
        try {

            map.deleteByKey("Coco");

        } catch (KeyNotFoundException e) {

            System.out.println(e.getMessage());
        }
        // delete chain head
        try {

            map.deleteByKey("Francis");

        } catch (KeyNotFoundException e) {

            System.out.println(e.getMessage());
        }
        // to string
        System.out.println("\n" + map.toString());
        // get size
        System.out.println("size: " + map.getSize());
        // all keys
        System.out.println("\n" + Arrays.toString(map.getAllKeys(new String[] {})));

        System.out.println("Prime checks: \n1: " + map.isPrime(1));
        System.out.println("\n2: " + map.isPrime(2));
        System.out.println("\n3: " + map.isPrime(3));
        System.out.println("\n4: " + map.isPrime(4));
        System.out.println("\n5: " + map.isPrime(5));
        System.out.println("\n6: " + map.isPrime(6));
        System.out.println("\n7: " + map.isPrime(7));
        System.out.println("\n8: " + map.isPrime(8));
        System.out.println("\n9: " + map.isPrime(9));
        System.out.println("\n10: " + map.isPrime(10));
        System.out.println("\n37: " + map.isPrime(37));

    }
}

