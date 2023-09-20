/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day10bintree;

/**
 *
 * @author mer
 */
public class BinaryTreeOfInts {

    private class NodeOfInt {

        int value; // could also be key, value pair
        NodeOfInt left, right;
    }

    private NodeOfInt root;
    private int nodesCount;

    // throws exception if put attempts to insert value that already exists (a duplicate)
    void put(int value) throws IllegalArgumentException {

        if (nodesCount == 0) {

            root = new NodeOfInt();
            root.value = value;
            nodesCount++;
            return;
        }

        NodeOfInt node = root;

        for (int i = 0; i < nodesCount; i++) {

            if (node.value == value) {
                throw new IllegalArgumentException();
            }
            if (node.value > value) {

                if (node.left == null) {

                    node.left = new NodeOfInt();
                    node.left.value = value;
                    nodesCount++;
                    return;
                }

                node = node.left;

            } else {

                if (node.right == null) {

                    node.right = new NodeOfInt();
                    node.right.value = value;
                    nodesCount++;
                    return;
                }

                node = node.right;
            }
        }
    }

    public int getSize() {
        return nodesCount;
    }

    public int getRootVal() {
        return root.value;
    }

    public boolean hasValue(int val) {

        NodeOfInt node = root;

        for (int i = 0; i < nodesCount; i++) {

            if (node.value == val) {

                return true;
            }

            if (node.left != null && val < node.value) {

                if (node.left.value == val) {

                    return true;
                }

                node = node.left;
            }

            if (node.right != null && val > node.value) {

                if (node.right.value == val) {

                    return true;
                }

                node = node.right;
            }
        }
        return false;
    }

    // uses recursion to compute the sum of all values in the entire tree
    public int getSumOfAllValues() {
        return getSumOfThisAndSubNodes(root);
    }

    // private helper recursive method to implement the above method
    private int getSumOfThisAndSubNodes(NodeOfInt node) {

        int sum = 0;

        if (node != null) {

            sum += node.value;
            sum += getSumOfThisAndSubNodes(node.left);
            sum += getSumOfThisAndSubNodes(node.right);
        }
        return sum;
    }

    // uses recursion to collect all values from largest to smallest
    int[] getValuesInOrder() { // from largest to smallest
        resultArray = new int[nodesCount];
        resultIndex = 0;
        collectValuesInOrder(root);
        return resultArray;
    }
    
        int[] getValuesReverse() { // from largest to smallest
        resultArray = new int[nodesCount];
        resultIndex = 0;
        collectValuesReverse(root);
        return resultArray;
    }
    // private helper recursive method to implement the above method

    private void collectValuesInOrder(NodeOfInt node) {

        if (node != null) {

            if (node.left != null) {
                collectValuesInOrder(node.left);
            }

            resultArray[resultIndex] = node.value;
            resultIndex++;
            System.out.println(node.value);

            if (node.right != null) {
                collectValuesInOrder(node.right);
            }
        }

        return;
    }
    
        private void collectValuesReverse(NodeOfInt node) {

        if (node != null) {

            if (node.right != null) {
                collectValuesInOrder(node.right);
            }

            resultArray[resultIndex] = node.value;
            resultIndex++;
            System.out.println(node.value);

            if (node.left != null) {
                collectValuesInOrder(node.left);
            }
        }

        return;
    }
    // data structures used to make collecting values in order easier

    private int[] resultArray;
    private int resultIndex;

}
