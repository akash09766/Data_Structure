package com.nexsterstudios.android.datastructure.tree.binarySearchTree;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Akash Wangalwar.(Github:akash09766) on 28-10-2021 at 22:28.
 */
public class BinarySortedTree {
    Node root;

    public void insert(int value) {
        root = addRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteRecursiveNode(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public boolean find(int value) {
        if (root == null) {
            return false;
        } else {
            Node temp = findRecursive(root, value);
            if (temp == null) {
                return false;
            } else {
                return temp.value == value;
            }
        }
    }

    private Node findRecursive(Node current, int valueToFind) {
        if (current == null || valueToFind == current.value) {
            return current;
        } else if (valueToFind < current.value) {
            current = findRecursive(current.left, valueToFind);
        } else {
            current = findRecursive(current.right, valueToFind);
        }
        return current;
    }

    private Node deleteRecursiveNode(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.value) {
            // node to be deleted
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right == null) {
                return node.left;
            } else if (node.right != null && node.left == null) {
                return node.right;
            } else {
                int smallestValue = findSmallestNode(node.right);
                node.value = smallestValue;
                node.right = deleteRecursiveNode(node.right, smallestValue);
                return node;
            }
        }

        if (value < node.value) {
            node = deleteRecursiveNode(node.left, value);
        } else {
            node = deleteRecursiveNode(node.right, value);
        }
        return node;
    }

    private int findSmallestNode(Node node) {
        return node.left == null ? node.value : findSmallestNode(node.left);
    }

    private static final String TAG = BinarySortedTree.class.getSimpleName();

    public void traverseUsingInOrder(Node node) {
        if (node != null) {
            traverseUsingInOrder(node.left);
            Log.d(TAG, "----------traverseUsingInOrder----------: " + node.value);
            traverseUsingInOrder(node.right);
        }
    }

    public void traverseUsingPreOrder(Node node) {
        if (node != null) {
            Log.d(TAG, "traverseUsingPreOrder: %%%%%%%%%%%% traverseUsingPreOrder %%%%%%%%%%%% : " + node.value);
            traverseUsingPreOrder(node.left);
            traverseUsingPreOrder(node.right);
        }
    }

    public void traverseUsingPostOrder(Node node) {
        if (node != null) {
            traverseUsingPostOrder(node.left);
            traverseUsingPostOrder(node.right);
            Log.d(TAG, "traverseUsingPreOrder: @@@@ traverseUsingPostOrder @@@@ : " + node.value);
        }
    }

    public void traverseLevelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();

        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node item = nodes.remove();

            Log.d(TAG, "traverseLevelOrder: ^^^^^^^^^^^ traverseLevelOrder ^^^^^^^^^^^ : " + item.value);

            if (item.left != null) {
                nodes.add(item.left);
            }

            if (item.right != null) {
                nodes.add(item.right);
            }
        }
    }

/*    public void traverseUsingPreOrder(Node node) {
        if (node != null && node.left == null && node.right == null) {
            Log.d(TAG, "************traverseUsingPreOrder************: " + node.value);
            return;
        }
        traverseUsingPreOrder(node.left);
        if (node.right != null && node.right.left == null && node.left.left == null) {
            Log.d(TAG, "************traverseUsingPreOrder************: " + node.value);
            Log.d(TAG, "************traverseUsingPreOrder************: " + node.right.value);
        }else {
            Log.d(TAG, "************traverseUsingPreOrder************: " + node.value);
            traverseUsingPreOrder(node.right);
        }
//        traverseUsingPreOrder(node.right);
    }*/

    public Node getNode() {
        return root;
    }
}
