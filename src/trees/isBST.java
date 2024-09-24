package com.company.trees;

import java.util.ArrayList;

public class isBST {
    public static void mainFn() {
        int[] data1 = {10,7,12, 5, 8, 11, 20};
        //int[] data1 = {10,7,12};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());

        System.out.println("Is BST: " + validateBST(binaryTree1.root, Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    static boolean validateBST(BTNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data <min || root.data > max) {
            return false;
        }

        //While going left, min will remain same and max has to be less than (current node data - 1)
        //While going right, max will remain same and min has to be less than (current node data + 1)
        return validateBST(root.left, min, root.data -1) && validateBST(root.right, root.data +1, max);
    }
}
