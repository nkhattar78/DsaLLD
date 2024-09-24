package com.company.trees;

public class BTNode {
    public BTNode left;
    public BTNode right;
    public int data;

    public BTNode() {    }
    public BTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
