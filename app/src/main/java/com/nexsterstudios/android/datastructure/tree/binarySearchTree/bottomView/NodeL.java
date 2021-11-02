package com.nexsterstudios.android.datastructure.tree.binarySearchTree.bottomView;

/**
 * Created by Akash Wangalwar.(Github:akash09766) on 28-10-2021 at 22:25.
 */
public class NodeL {
    int value;
    int hd = 0;//horizontal distance of node
    NodeL left;
    NodeL right;

    public NodeL(int value) {
        this.value = value;
        this.hd = Integer.MAX_VALUE;
    }
}
