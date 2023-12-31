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

        Container entry = new Container();
        entry.key = key;
        entry.value = value;

        int hash = computeHashValue(key);
        int bucket = hash % hashTable.length;

        //console test
        System.out.println("hash of " + entry.key + " is: " + hash);
        System.out.println(entry.key + "'s bucket is: " + bucket);

        if (hashTable[bucket] == null) {

            hashTable[bucket] = entry;

            totalItems++;

            //console test
            System.out.println(entry.key + "'s index is: 0");
            System.out.println("new entry: " + hashTable[bucket].key + " => " + hashTable[bucket].value + "\n");

        } else {

            Container elem = hashTable[bucket];

            for (int i = 0; i < totalItems; i++) {

                if (elem.key.equals(key)) {

                    elem.value = value;

                    //console test
                    System.out.println(entry.key + "'s index is: " + i);
                    System.out.println("new entry: " + entry.key + " => " + entry.value + "\n");

                    break;
                }

                if (elem.next == null) {

                    elem.next = entry;
                    totalItems++;

                    //console test
                    System.out.println(entry.key + "'s index is: " + (i + 1));
                    System.out.println("new entry: " + entry.key + " => " + entry.value + "\n");

                    break;
                }

                elem = elem.next;
            }
        }

        checkTableSize();
    }

    void checkTableSize() {

        if (hashTable.length * 3 < totalItems) {

            int size = hashTable.length * 2; // ?? how to get nearest prime

            while (!isPrime(size)) {

                size++;
            }

            resizeTable(size);
        }
    }

    void resizeTable(int size) {

        //console test
        System.out.println("resizing table");

        Container[] newTable = new Container[size];
        Container[] oldTable = hashTable;
        hashTable = newTable;
        int total = totalItems;
        totalItems = 0;

        for (int i = 0; i < oldTable.length; i++) {

            Container elem = oldTable[i];

            if (elem != null) {

                for (int j = 0; j < total; j++) {

                    putValue(elem.key, elem.value);

                    if (elem.next == null) {

                        break;
                    }
                    elem = elem.next;
                }

            }
        }

    }

    public boolean isPrime(int size) {

        boolean[] primes = new boolean[size + 1];

        for (int i = 0; i < primes.length; i++) {
            
            primes[i] = true;
        }

        for (int i = 2; i * i <= size; i++) {

            if (primes[i]) {

                for (int j = i * i; j < size + 1; j += i) {
                    
                    primes[j] = false;
                }

            }
        }
        return primes[size];
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

    String getValue(String key) throws KeyNotFoundException {

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

        throw new KeyNotFoundException("key not found");
    }

    void deleteByKey(String key) throws KeyNotFoundException {

        boolean isFound = false;

        for (int i = 0; i < hashTable.length; i++) {

            Container elem = hashTable[i];

            if (elem != null) {

                if (elem.key.equals(key)) {

                    isFound = true;
                    hashTable[i] = elem.next;

                } else {

                    for (int j = 0; j < totalItems; j++) {

                        if (elem.next != null && elem.next.key.equals(key)) {

                            elem.next = elem.next.next;
                            isFound = true;
                            break;
                        }
                        if (elem.next == null) {
                            break;
                        }
                        elem = elem.next;
                    }
                }
            }
        }
        
        if (!isFound) {

            throw new KeyNotFoundException("key " + key + " not found");

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
    
        public Pair<String, String>[] getAllKeyValPairs() {
            
        Pair<String, String>[] pairs = new Pair[totalItems];
        
        int pairCount = 0;
        
        for (int i = 0; i < hashTable.length; i++) {
            
            for (Container elem = hashTable[i]; elem != null; elem = elem.next) {
                
                Pair<String,String> pair = new Pair(elem.key, elem.value);
                
                pairs[pairCount++] = pair;
            }
        }
        
        return pairs;
    }
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

}
