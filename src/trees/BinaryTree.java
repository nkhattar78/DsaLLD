package com.company.trees;

import java.util.LinkedList;
import java.util.Queue;

import static com.company.trees.TreeHelperFunctions.heightRec;

public class BinaryTree {
    BTNode root;

    public BTNode getRoot() {
        return this.root;
    }

    public BinaryTree(int[] treeData, boolean isBST) {
        if (isBST) {
            for (int i=0;i<treeData.length;i++) {
                //this.root = addNodeInBSTUsingRecursion(this.root, treeData[i]);
                this.root = addNodeInBSTIterative(this.root, treeData[i]);
            }
        }
    }

    private BTNode addNodeInBSTIterative(BTNode root, int data) {
        BTNode newNode = new BTNode(data);
        if (root != null) {
            BTNode current = root;
            while (current != null) {
                if (data <= current.data) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    }
                    current = current.right;
                }
            }
        } else  {
            root = newNode;
        }
        return root;
    }

    private BTNode addNodeInBSTUsingRecursion(BTNode root, int data) {
        if(root == null) {
            return new BTNode(data);
        } else  {
            if (data<= root.data) {
                root.left = addNodeInBSTUsingRecursion(root.left, data);
            } else {
                root.right = addNodeInBSTUsingRecursion(root.right, data);
            }
        }
        //Return unchanged root pointer
        return root;
    }
}
