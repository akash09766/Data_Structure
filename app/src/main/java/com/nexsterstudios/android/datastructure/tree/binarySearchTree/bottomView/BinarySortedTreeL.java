package com.nexsterstudios.android.datastructure.tree.binarySearchTree.bottomView;

import android.util.Log;

import com.nexsterstudios.android.datastructure.tree.binarySearchTree.Node;
import com.nexsterstudios.android.datastructure.tree.binarySearchTree.bottomView.NodeL;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Akash Wangalwar.(Github:akash09766) on 28-10-2021 at 22:28.
 */
public class BinarySortedTreeL {
    NodeL root;
    static int max_level = 0;

    public void insert(int value) {
        root = addRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteRecursiveNode(root, value);
    }

    private NodeL addRecursive(NodeL current, int value) {
        if (current == null) {
            return new NodeL(value);
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
            NodeL temp = findRecursive(root, value);
            if (temp == null) {
                return false;
            } else {
                return temp.value == value;
            }
        }
    }

    private NodeL findRecursive(NodeL current, int valueToFind) {
        if (current == null || valueToFind == current.value) {
            return current;
        } else if (valueToFind < current.value) {
            current = findRecursive(current.left, valueToFind);
        } else {
            current = findRecursive(current.right, valueToFind);
        }
        return current;
    }

    private NodeL deleteRecursiveNode(NodeL node, int value) {
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

    private int findSmallestNode(NodeL node) {
        return node.left == null ? node.value : findSmallestNode(node.left);
    }

    private static final String TAG = BinarySortedTreeL.class.getSimpleName();

    public void traverseUsingInOrder(NodeL node) {
        if (node != null) {
            traverseUsingInOrder(node.left);
            Log.d(TAG, "----------traverseUsingInOrder----------: " + node.value);
            traverseUsingInOrder(node.right);
        }
    }

    public void traverseUsingPreOrder(NodeL node) {
        if (node != null) {
            Log.d(TAG, "traverseUsingPreOrder: %%%%%%%%%%%% traverseUsingPreOrder %%%%%%%%%%%% : " + node.value);
            traverseUsingPreOrder(node.left);
            traverseUsingPreOrder(node.right);
        }
    }

    public void traverseUsingPostOrder(NodeL node) {
        if (node != null) {
            traverseUsingPostOrder(node.left);
            traverseUsingPostOrder(node.right);
            Log.d(TAG, "traverseUsingPreOrder: @@@@ traverseUsingPostOrder @@@@ : " + node.value);
        }
    }

    public void traverseLevelOrder(NodeL node) {
        if (node == null) {
            return;
        }

        Queue<NodeL> nodes = new LinkedList<>();

        nodes.add(root);

        while (!nodes.isEmpty()) {

            NodeL item = nodes.remove();

            Log.d(TAG, "traverseLevelOrder: ^^^^^^^^^^^ traverseLevelOrder ^^^^^^^^^^^ : " + item.value);

            if (item.left != null) {
                nodes.add(item.left);
            }

            if (item.right != null) {
                nodes.add(item.right);
            }
        }
    }

    public void printRightViewWithLevelOrder(NodeL node, int level) {
        if (node == null) return;

        Queue<NodeL> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                NodeL item = queue.poll();

                if (i == n) {
                    Log.d(TAG, "printRightViewWithLevelOrder: --> " + item.value);
                }

                if (item.left != null) {
                    queue.add(item.left);
                }

                if (item.right != null) {
                    queue.add(item.right);
                }
            }
        }
    }

    public void printRightView(NodeL node, int level) {
        max_level = 0;
        printRightViewRecursive(node, level);
    }

    public void printRightViewRecursive(NodeL node, int level) {
        if (node == null) {
            return;
        }

        if (max_level < level) {
            Log.d(TAG, "printRightViewRecursive: --> " + node.value);
            max_level = level;
        }

        printRightViewRecursive(node.right, level + 1);
        printRightViewRecursive(node.left, level + 1);
    }

    public void printLeftViewRecursive(NodeL node, int level) {
        if (node == null) {
            return;
        }

        if (max_level < level) {
            Log.d(TAG, "printLeftViewRecursive: : -->" + node.value);
            max_level = level;
        }

        printLeftViewRecursive(node.left, level + 1);
        printLeftViewRecursive(node.right, level + 1);
    }

    public void printLeftView_online(NodeL node) {
        StringBuffer stringBuffer = new StringBuffer();

        if (node == null) return;

        Queue<NodeL> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 1; i <= n; i++) {

                NodeL item = queue.poll();

                if (i == 1) stringBuffer.append("->" + item.value);

                if (item.left != null) {
                    queue.add(item.left);
                }
                if (item.right != null) {
                    queue.add(item.right);
                }
            }
        }

        Log.d(TAG, "printLeftView_online: " + stringBuffer);
    }

    public void printLeftView(NodeL node) {
        StringBuffer stringBuffer = new StringBuffer();

        if (node == null) {
            return;
        }

        Queue<NodeL> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        int hd = 0;
        queue.add(node);

        while (!queue.isEmpty()) {

            NodeL item = queue.remove();
            hd = item.hd;

            if (!map.containsKey(item.hd)) {
                map.put(item.hd, item.value);
            }

            if (item.left != null) {
                item.left.hd = hd + 1;
                queue.add(item.left);
            }

            if (item.right != null) {
                item.right.hd = hd + 1;
                queue.add(item.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            stringBuffer.append("->" + entry.getValue());
        }

        Log.d(TAG, "printLeftView: " + stringBuffer);
    }

    public void printBottomView(NodeL node) {
        StringBuffer stringBuffer = new StringBuffer();
        if (node == null)
            return;

        Queue<NodeL> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        int hd = 0;

        node.hd = hd;
        queue.add(node);

        while (!queue.isEmpty()) {
            NodeL item = queue.remove();
            hd = item.hd;
            map.put(hd, item.value);

            if (item.left != null) {
//                map.put((item.hd - 1), item.value);
                item.left.hd = hd - 1;
                queue.add(item.left);
            }

            if (item.right != null) {
//                map.put((item.hd + 1), item.value);
                item.right.hd = hd + 1;
                queue.add(item.right);
            }
        }


        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Log.d(TAG, "printBottomView: value : " + entry.getValue());
            stringBuffer.append(" - " + entry.getValue());
        }

        Log.d(TAG, "printBottomView: " + stringBuffer);
    }

/*    public void traverseUsingPreOrder(NodeL node) {
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

    public NodeL getNode() {
        return root;
    }

    public void printBottomView2(NodeL node) {
        if (node == null) return;
        int hd = 0;

        Queue<NodeL> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        node.hd = hd;
        queue.add(node);

        while (!queue.isEmpty()) {

            NodeL item = queue.poll();

            map.put(item.hd, item.value);

            hd = item.hd;

            if (item.left != null) {
                item.left.hd = hd - 1;
                queue.add(item.left);
            }

            if (item.right != null) {
                item.right.hd = hd + 1;
                queue.add(item.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Log.d(TAG, "printBottomView2: --> " + entry.getValue() + " and key --> " + entry.getKey());
        }
    }

    public void printTopView(NodeL node) {
        if (node == null) return;
        int hd = 0;

        Queue<NodeL> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        node.hd = hd;
        queue.add(node);

        while (!queue.isEmpty()) {

            NodeL item = queue.poll();

            if (!map.containsKey(item.hd))
                map.put(item.hd, item.value);

            hd = item.hd;

            if (item.left != null) {
                item.left.hd = hd - 1;
                queue.add(item.left);
            }

            if (item.right != null) {
                item.right.hd = hd + 1;
                queue.add(item.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Log.d(TAG, "printBottomView2: --> " + entry.getValue() + " and key --> " + entry.getKey());
        }
    }

    public void printBoundry(NodeL node) {
        if (node == null) {
            return;
        }
        Log.d(TAG, "printBoundry() :"+ node.value);
        printBoundryLeft(node.left);

        printLeaveNodes(node.left);
        printLeaveNodes(node.right);

        printBoundryRight(node.right);
    }

    private void printBoundryLeft(NodeL node) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            Log.d(TAG, "printBoundryLeft: " + node.value);
            printBoundryLeft(node.left);
        } else if (node.right != null) {
            Log.d(TAG, "printBoundryLeft: " + node.value);
            printBoundryLeft(node.right);
        }
    }


    private void printBoundryRight(NodeL node) {

        if (node == null) {
            return;
        }

        if (node.right != null) {
            printBoundryRight(node.right);
            Log.d(TAG, "printBoundryLeft: " + node.value);
        } else if (node.left != null) {
            printBoundryRight(node.left);
            Log.d(TAG, "printBoundryLeft: " + node.value);
        }
    }

    private void printLeaveNodes(NodeL node){
        if (node == null)return;

        printLeaveNodes(node.left);
        if(node.right == null && node.left == null){
            Log.d(TAG, "printLeaveNodes: "+node.value);
        }
        printLeaveNodes(node.right);
    }
}
