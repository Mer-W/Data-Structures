/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day10bintree;

/**
 *
 * @author mer
 */
public class Day10BinTreeStringInt {

    private class Node {

        String key;
        int value;
        Node left, right;
    }

    Node root;
    private int nodesCount;

    // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    void put(String key, int value) {

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
    public int getValByKey(String key) throws RuntimeException {
        
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
            str.append(node.key);
            str.append(" => ");
            str.append(node.value);

            str.append(printPairs(node.left));
            str.append(printPairs(node.right));
        }
        return str.toString();
    }

}
