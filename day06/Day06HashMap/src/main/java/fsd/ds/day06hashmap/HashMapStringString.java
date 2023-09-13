/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day06hashmap;

/**
 *
 * @author mer
 */
public class HashMapStringString {

    private class Container {

        Container next;
        String key;
        String value;
    }

    // size must be a prime number always
    private Container[] hashTable = new Container[5];

    private int totalItems;

    private int computeHashValue(String key) { // hashing function
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            // hash *= 3;
            hash <<= 1;  // same as: hash *= ...
            char c = key.charAt(i);
            hash += c;
        }
        return hash;
    }

    void putValue(String key, String value) {
        // LATER: expand hashTable by about *2 when totalItems > 3*hashTable.length

        Container entry = new Container();

        entry.key = key;
        entry.value = value;

        int hash = computeHashValue(key);

        System.out.println("hash of " + entry.key + " is: " + hash);
        int bucket = hash % hashTable.length;
        System.out.println(entry.key + "'s bucket is: " + bucket);

        if (hashTable[bucket] == null) {

            hashTable[bucket] = entry;

            totalItems++;
            System.out.println(entry.key + "'s index is: 0");

            System.out.println("new entry: " + hashTable[bucket].key + " => " + hashTable[bucket].value + "\n");
        } else {

            Container elem = hashTable[bucket];

            for (int i = 0; i < totalItems; i++) {

                if (elem.key.equals(key)) {

                    elem.value = value;
                    System.out.println(entry.key + "'s index is: " + i);
                    System.out.println("new entry: " + entry.key + " => " + entry.value + "\n");

                    break;

                } else if (elem.next == null) {

                    elem.next = entry;

                    totalItems++;
                    System.out.println(entry.key + "'s index is: " + (i + 1));
                    System.out.println("new entry: " + entry.key + " => " + entry.value + "\n");

                    break;
                }

                elem = elem.next;
            }
        }
        
        tableSize();
    }

    void tableSize() {

        if (hashTable.length * 3 < totalItems) {

            int size = totalItems * 2; // ?? how to get nearest prime

            while (!isPrime(size)) {

                size++;
            }

            Container[] newTable = new Container[size];

            
        }
    }

    public boolean isPrime(int size) {

        for (int i = 2; i < size; i++) {

            if (size % i == 0) {

                return false;
            }
        }
        return true;
    }

    boolean hasKey(String key) {

        for (int i = 0; i < hashTable.length; i++) {

            Container elem = hashTable[i];

            if (elem != null) {

                for (int j = 0; j < totalItems; j++) {

                    if (elem.key.equals(key)) {
                        return true;
                    }
                    if (elem.next == null) {
                        break;
                    }
                    elem = elem.next;
                }
            }
        }
        return false;
    }

    // throw custom unchecked KeyNotFoundException
    String getValue(String key) {

        if (!hasKey(key)) {

            // error
        }

        for (int i = 0; i < hashTable.length; i++) {

            Container elem = hashTable[i];

            if (elem != null) {

                for (int j = 0; j < totalItems; j++) {

                    if (elem.key.equals(key)) {
                        return elem.value;
                    }
                    if (elem.next == null) {
                        break;
                    }
                    elem = elem.next;
                }
            }
        }

        return "no such key";
    }

    // throw custom unchecked KeyNotFoundException
    void deleteByKey(String key) {

        if (!hasKey(key)) {

            // error
        }

        for (int i = 0; i < hashTable.length; i++) {

            Container elem = hashTable[i];

            if (elem != null) {

                if (elem.key.equals(key)) {

                    hashTable[i] = elem.next;

                } else {

                    for (int j = 0; j < totalItems; j++) {

                        if (elem.next != null && elem.next.key.equals(key)) {

                            elem.next = elem.next.next;

                        }
                        if (elem.next == null) {
                            break;
                        }
                        elem = elem.next;
                    }
                }
            }
        }

        totalItems--;
    }

    public String[] getAllKeys() {

        String[] keys = new String[totalItems];

        int count = 0;

        for (int i = 0; i < hashTable.length; i++) {

            Container elem = hashTable[i];

            if (elem != null) {

                for (int j = 0; j < totalItems; j++) {

                    keys[count] = elem.key;
                    count++;

                    if (elem.next == null) {
                        break;
                    }

                    elem = elem.next;
                }

            }
        }
        return keys;
    }
    // Generic version: public K[] getAllKeys(K[] template) { ... }
/*
    public Pair<String, String>[] getAllKeyValPairs() {

        Pair<String, String>[] result = new Pair[totalItems];

        return result;
    }
     */
    int getSize() {
        return totalItems;
    }

    public void printDebug() {
    } // print hashTable content, see example below

    @Override
    public String toString() {  // comma-separated key->value pair list
        // to be able to use this as validation in Unit tests keys must be sorted
        // e.g. [ Key1 => Val1, Key2 => Val2, ... ]
        if (totalItems == 0) {
            return "";
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hashTable.length; i++) {

            Container elem = hashTable[i];

            if (elem != null) {
                for (int j = 0; j < totalItems; j++) {

                    if (j != 0) {

                        str.append(", ");
                    }

                    str.append(elem.key);
                    str.append(" => ");
                    str.append(elem.value);

                    if (elem.next == null) {
                        break;
                    }
                    elem = elem.next;
                }

                str.append("\n");
            }
        }
        return str.toString();

    }

    /*
    private class Pair<K, V> {

    K key;
    V val;
}
     */
}
