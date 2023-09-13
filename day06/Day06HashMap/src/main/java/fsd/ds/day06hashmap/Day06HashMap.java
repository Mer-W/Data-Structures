/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day06hashmap;

import java.util.Arrays;

/**
 *
 * @author mer
 */
public class Day06HashMap {

    public static void main(String[] args) {

        HashMapStringString map = new HashMapStringString();

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
        map.putValue("Choco", "cat");
        map.putValue("Vinny", "border collie");
        map.putValue("Dede", "yorkie");
        map.putValue("Bruce", "cat");
        map.putValue("Francis", "unknown");
        // to string
        System.out.println(map.toString());
        // get size
        System.out.println(map.getSize());

        // has key
        System.out.println(map.hasKey("Buster"));
        System.out.println(map.hasKey("Busther"));

        // get value
        System.out.println(map.getValue("Buster"));
        System.out.println(map.getValue("Busther"));

        // delete from middle
        map.deleteByKey("Coco");

        // delete chain head
        map.deleteByKey("Francis");

        // to string
        System.out.println("\n" + map.toString());

        // all keys
        System.out.println("\n" + Arrays.toString(map.getAllKeys()));

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
        System.out.println("\n11: " + map.isPrime(11));

    }
}
