/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day06hashmapgeneric;

/**
 *
 * @author mer
 */
public class HashMapGeneric<K, V> {

    public HashMapGeneric() {
        this.hashTable = new Container[5];
    }



    private class Container {

        Container next;
        K key;
        V value;
    }
    // size must be a prime number always

        private Container[] hashTable;

    private int totalItems;

    private int computeHashValue(K key) { // hashing function
        String str = key.toString();
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            // hash *= 3;
            hash <<= 1;  // same as: hash *= ...
            char c = str.charAt(i);
            hash += c;
        }
        return hash;
    }
    /*
    public HashMapGeneric(Container[] template) {
        
                Container[] hashtable = (Container[])java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), 5);
                this.hashTable = hashtable;
    }
*/
    void putValue(K key, V value) {

        Container entry = new Container();
        entry.key = key;
        entry.value = value;

        int hash = computeHashValue(key);
        int bucket = hash % hashTable.length;

        //console test
        System.out.println("hash of " + entry.key.toString() + " is: " + hash);
        System.out.println(entry.key.toString() + "'s bucket is: " + bucket);

        if (hashTable[bucket] == null) {

            hashTable[bucket] = entry;

            totalItems++;

            //console test
            System.out.println(entry.key.toString() + "'s index is: 0");
            System.out.println("new entry: " + hashTable[bucket].key.toString() + " => " + hashTable[bucket].value.toString() + "\n");

        } else {

            Container elem = hashTable[bucket];

            for (int i = 0; i < totalItems; i++) {

                if (elem.key.equals(key)) {

                    elem.value = value;

                    //console test
                    System.out.println(entry.key.toString() + "'s index is: " + i);
                    System.out.println("new entry: " + entry.key.toString() + " => " + entry.value.toString() + "\n");

                    break;
                }

                if (elem.next == null) {

                    elem.next = entry;
                    totalItems++;

                    //console test
                    System.out.println(entry.key.toString() + "'s index is: " + (i + 1));
                    System.out.println("new entry: " + entry.key.toString() + " => " + entry.value.toString() + "\n");

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

        Container[] newTable = (Container[])java.lang.reflect.Array.newInstance(hashTable.getClass().getComponentType(), size);
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

    boolean hasKey(K key) {

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

    V getValue(K key) throws KeyNotFoundException {

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

    void deleteByKey(K key) throws KeyNotFoundException {

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

            throw new KeyNotFoundException("key " + key.toString() + " not found");

        }
        totalItems--;
    }

    public K[] getAllKeys(K[] template) {
        
        K[] keys = (K[])java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), totalItems);


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
    
        public Pair<K, V>[] getAllKeyValPairs(Pair<K, V>[] template) {
            
           Pair<K, V>[] pairs = (Pair<K, V>[])java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), totalItems);
        
        int pairCount = 0;
        
        for (int i = 0; i < hashTable.length; i++) {
            
            for (Container elem = hashTable[i]; elem != null; elem = elem.next) {
                
                Pair<K, V> pair = new Pair(elem.key, elem.value);
                
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

                    str.append(elem.key.toString());
                    str.append(" => ");
                    str.append(elem.value.toString());

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
