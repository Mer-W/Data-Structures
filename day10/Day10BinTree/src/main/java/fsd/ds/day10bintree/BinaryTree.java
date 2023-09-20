/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day10bintree;

import java.util.Iterator;

/**
 *
 * @author mer
 * @param <K> Key type
 * @param <V> Value type
 */
public class BinaryTree<K extends Comparable, V> implements Iterable<Pair<K, V>> {

    private class Node {

        K key;
        V value;
        Node left, right;
    }

    Node root;
    private int nodesCount;
    private Pair<K, V>[] pairs;
    private int index;
    
    public BinaryTree() {
    }

    // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    void put(K key, V value) {

        if (nodesCount == 0) {

            root = new Node();
            root.key = key;
            root.value = value;
            nodesCount++;
            return;
        }

        Node node = root;

        for (int i = 0; i < nodesCount; i++) {

            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            if (key.compareTo(node.key) < 0) {

                if (node.left == null) {

                    node.left = new Node();
                    node.left.key = key;
                    node.left.value = value;
                    nodesCount++;
                    return;
                }

                node = node.left;

            } else {

                if (node.right == null) {

                    node.right = new Node();
                    node.right.key = key;
                    node.right.value = value;
                    nodesCount++;
                    return;
                }

                node = node.right;
            }
        }
    }

    // throws exception if key is not found, otherwise returns the value
    public V getValByKey(K key) throws RuntimeException {

        Node node = root;

        for (int i = 0; i < nodesCount; i++) {

            if (node.key.equals(key)) {
                return node.value;
            }

            if (node.left != null && key.compareTo(node.key) < 0) {

                if (node.left.key.equals(key)) {

                    return node.left.value;
                }

                node = node.left;
            }

            if (node.right != null && key.compareTo(node.key) > 0) {

                if (node.right.key.equals(key)) {

                    return node.right.value;
                }

                node = node.right;
            }
        }
        throw new RuntimeException("key not found");

    }

    public int getSize() {
        return nodesCount;
    }

    // print out all key-value pairs (one per line) from the smallest key to the largest
    public void printAllKeyValPairs() {

        System.out.println(printPairs(root));
    }

    private String printPairs(Node node) {
        StringBuilder str = new StringBuilder();

        if (node != null) {

            str.append("\n");
            str.append(node.key.toString());
            str.append(" => ");
            str.append(node.value.toString());
   

            str.append(printPairs(node.left));
            str.append(printPairs(node.right));
        }
        return str.toString();
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {

        return new Iterator<Pair<K, V>>() {

            Pair<K, V>[] result = getAllKeyValPairs();

            int count = 0;

            @Override
            public boolean hasNext() {
                return (count < result.length);
            }

            @Override
            public Pair<K, V> next() {
                return result[count++];
            }

        };
    }

    public Pair<K, V>[] getAllKeyValPairs() {

      pairs = new Pair[nodesCount];

       fillPairArray(root);

      return pairs;
    }

    private void fillPairArray(Node node) {

        if (node != null) {

            if (node.left != null) {
                fillPairArray(node.left);
            }

            pairs[index++] = new Pair(node.key, node.value);

            if (node.right != null) {
                fillPairArray(node.right);
            }
        }

        return;
    }
}
